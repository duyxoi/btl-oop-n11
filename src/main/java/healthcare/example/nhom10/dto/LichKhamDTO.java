package healthcare.example.nhom10.dto;


import java.time.LocalDateTime;

public class LichKhamDTO {
    private int maBacSi;
    private LocalDateTime ngayKham;

    public LichKhamDTO(int maBacSi, LocalDateTime ngayKham) {
        this.maBacSi = maBacSi;
        this.ngayKham = ngayKham;
    }

    public int getMaBacSi() {
        return maBacSi;
    }

    public LocalDateTime getNgayKham() {
        return ngayKham;
    }

    public void setMaBacSi(int maBacSi) {
        this.maBacSi = maBacSi;
    }

    public void setNgayKham(LocalDateTime ngayKham) {
        this.ngayKham = ngayKham;
    }
}
