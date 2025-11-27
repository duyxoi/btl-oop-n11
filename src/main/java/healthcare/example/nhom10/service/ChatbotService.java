package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.DatLichKham;
import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.common.CustomUserDetails;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
public class ChatbotService {

    private final ChatClient chatClient;
    private final BenhNhanService benhNhanService;
    private final DatLichKhamService datLichKhamService;

    public ChatbotService(ChatClient.Builder chatClientBuilder,
                          BenhNhanService benhNhanService,
                          DatLichKhamService datLichKhamService) {

        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Bạn là chatbot hỗ trợ bệnh nhân trong hệ thống quản lý hồ sơ bệnh án.
                        Nhiệm vụ chính:
                        - Giải thích cách sử dụng hệ thống (xem hồ sơ, xem lịch khám, đặt/hủy lịch).
                        - Giải thích các thuật ngữ đơn giản trong hồ sơ bệnh án và lịch sử khám.
                        - Tóm tắt lịch khám, hồ sơ, chi phí dựa trên dữ liệu đã cung cấp.
                        GIỚI HẠN:
                        - Không tự chẩn đoán bệnh.
                        - Không tự kê đơn, đổi thuốc hoặc thay đổi chỉ định của bác sĩ.
                        - Nếu câu hỏi liên quan tới cấp cứu hoặc điều trị cụ thể, hãy khuyến khích bệnh nhân hỏi trực tiếp bác sĩ
                          hoặc tới cơ sở y tế gần nhất.
                        Hãy trả lời ngắn gọn, dễ hiểu, tiếng Việt, xưng "mình" với bệnh nhân.
                        """)
                .build();

        this.benhNhanService = benhNhanService;
        this.datLichKhamService = datLichKhamService;
    }

    /**
     * Xử lý một câu hỏi từ bệnh nhân
     */
    public String handlePatientMessage(String userMessage) {
        // Lấy user đang login
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof CustomUserDetails userDetails)) {
            // Không lấy được thông tin người dùng -> trả lời chung chung
            return callModelSafely("""
                    Bệnh nhân (không xác định danh tính trong hệ thống) hỏi: "%s".
                    Hãy trả lời theo đúng vai trò trợ lý ảo của phòng khám.
                    """.formatted(userMessage));
        }

        Nguoi nguoi = userDetails.getNguoi();

        String lower = userMessage.toLowerCase();

        // 1. Nếu liên quan tới lịch khám -> kèm context lịch khám
        if (lower.contains("lịch khám") || lower.contains("lịch hẹn") || lower.contains("tái khám")) {

            String context = buildLichKhamContextForPatient(nguoi);

            String prompt = """
                    Đây là thông tin một số lịch khám của bệnh nhân (gần nhất):

                    %s

                    Dựa trên thông tin trên, hãy trả lời câu hỏi của bệnh nhân:
                    "%s"

                    Nếu bệnh nhân hỏi cách xem lịch trên web, hãy hướng dẫn rõ đường đi menu trong hệ thống:
                    - Vào mục "Lịch khám" trong menu bệnh nhân.
                    - Có thể xem dạng bảng hoặc dạng lịch (calendar).
                    """
                    .formatted(context, userMessage);

            return callModelSafely(prompt);
        }

        // 2. Các câu hỏi khác (cách dùng hệ thống, thuật ngữ, ...)
        String helperPrompt = """
                Bệnh nhân hỏi: "%s"

                Nếu câu hỏi liên quan tới:
                - Cách xem hồ sơ bệnh án, lịch sử khám, đơn thuốc:
                    + Hướng dẫn vào mục "Hồ sơ bệnh án" trong giao diện bệnh nhân.
                    + Hướng dẫn vào mục "Lịch sử khám" (nếu có).
                - Cách đặt lịch khám:
                    + Hướng dẫn vào chức năng "Đặt lịch khám" trong giao diện bệnh nhân.
                Nếu là câu hỏi khác trong phạm vi trợ lý, hãy trả lời theo system prompt đã được cấu hình.
                """
                .formatted(userMessage);

        return callModelSafely(helperPrompt);
    }

    /**
     * Gọi model qua Spring AI
     */
    private String callModelSafely(String prompt) {
        try {
            return chatClient
                    .prompt()
                    .user(prompt)
                    .call()
                    .content();
        } catch (Exception e) {
            e.printStackTrace();
            return "Hiện chatbot đang gặp sự cố kỹ thuật khi kết nối tới Gemini, " +
                    "nên chưa trả lời được. Bạn thử lại sau hoặc liên hệ trực tiếp phòng khám giúp mình nhé.";
        }
    }

    /**
     * Lấy một số lịch khám gần đây của bệnh nhân và format thành text
     * để gửi kèm vào prompt cho Gemini.
     */
    private String buildLichKhamContextForPatient(Nguoi nguoi) {
        // getBenhNhanByNguoi() trả về Optional<BenhNhan> nên phải orElse(null)
        BenhNhan benhNhan = benhNhanService.getBenhNhanByNguoi(nguoi).orElse(null);
        if (benhNhan == null) {
            return "Không tìm thấy thông tin bệnh nhân tương ứng với tài khoản hiện tại.";
        }

        // Dùng đúng method bạn đang có trong DatLichKhamService
        List<DatLichKham> lichKhams = datLichKhamService.getByBenhNhan(benhNhan);

        if (lichKhams == null || lichKhams.isEmpty()) {
            return "Bệnh nhân hiện chưa có lịch khám nào.";
        }

        // Sắp xếp theo ngày khám mới nhất trước
        lichKhams.sort(Comparator.comparing(DatLichKham::getNgayKham).reversed());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();

        lichKhams.stream()
                .limit(5)
                .forEach(lich -> sb.append("- Mã lịch: ").append(lich.getMaLichKham())
                        .append(", Ngày giờ: ").append(lich.getNgayKham().format(dtf))
                        .append(", Bác sĩ: ").append(lich.getBacSi().getNguoi().getHoTen())
                        .append(", Khoa: ").append(lich.getBacSi().getKhoa().getTenKhoa())
                        .append(", Trạng thái: ").append(lich.getTrangThai())
                        .append('\n'));

        return sb.toString();
    }
}
