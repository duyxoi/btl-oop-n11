package healthcare.example.nhom10.rest;

import healthcare.example.nhom10.Entity.DatLichKham;
import healthcare.example.nhom10.dto.LichKhamDTO;
import healthcare.example.nhom10.service.DatLichKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lich-kham")
public class DatLichKhamApiController {

    @Autowired
    private DatLichKhamService datLichKhamService;
    @GetMapping("/da-dat")
    public List<LichKhamDTO> getMaBacSiVaNgayKham() {
        return datLichKhamService.getAllMaBacSiVaNgayKham();
    }
    @PostMapping("/dat-lich")
    public ResponseEntity<?> datLich(@RequestBody DatLichKham lichMoi) {
        try {
            DatLichKham saved = datLichKhamService.save(lichMoi);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
