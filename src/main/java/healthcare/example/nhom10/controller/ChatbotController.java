package healthcare.example.nhom10.controller;

import healthcare.example.nhom10.dto.chat.ChatRequest;
import healthcare.example.nhom10.dto.chat.ChatResponse;
import healthcare.example.nhom10.service.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/benhnhan/api/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        if (request == null || request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ChatResponse("Bạn hãy nhập câu hỏi trước khi gửi nhé."));
        }

        String answer = chatbotService.handlePatientMessage(request.getMessage().trim());
        return ResponseEntity.ok(new ChatResponse(answer));
    }
}
