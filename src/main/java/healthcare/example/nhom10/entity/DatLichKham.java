package healthcare.example.nhom10.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "datlichkham")
public class DatLichKham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLichKham")
    private int maLichKham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaKhoa")
    private Khoa khoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaBacSi")
    private BacSi bacSi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaBenhNhan")
    private BenhNhan benhNhan;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayTaoLich")
    private Date ngayTaoLich;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayKham")
    private LocalDateTime ngayKham;


    @Column(name = "TrangThai", length = 20)
    private String trangThai = "DA_XAC_NHAN"; // default từ SQL
    public DatLichKham() {}

    // ====== GETTER & SETTER ======


    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLichKham() {
        return maLichKham;
    }

    public void setMaLichKham(int maLichKham) {
        this.maLichKham = maLichKham;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public BacSi getBacSi() {
        return bacSi;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public Date getNgayTaoLich() {
        return ngayTaoLich;
    }

    public void setNgayTaoLich(Date ngayTaoLich) {
        this.ngayTaoLich = ngayTaoLich;
    }

    public LocalDateTime getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(LocalDateTime ngayKham) {
        this.ngayKham = ngayKham;
    }

    @Override
    public String toString() {
        return "DatLichKham{" +
                "maLichKham=" + maLichKham +
                ", dichVuYTe=" + (khoa != null ? khoa.getTenKhoa() : "null") +
                ", bacSi=" + (bacSi != null ? bacSi.getNguoi().getHoTen() : "null") +
                ", benhNhan=" + (benhNhan != null ? benhNhan.getNguoi().getHoTen() : "null") +
                ", ngayKham=" + ngayKham +
                '}';
    }
}
