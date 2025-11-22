package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "lichsukham")
public class LichSuKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLichSuKham")
    private int maLichSuKham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaBacSi",referencedColumnName = "MaBacSi")
    private BacSi bacSi;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaDonThuoc",referencedColumnName = "MaDonThuoc")
    private DonThuoc donThuoc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaHoSo",referencedColumnName = "MaHoSo")
    private HoSoBeNhan hoSoBeNhan;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaSoPhieu",referencedColumnName = "MaSoPhieu")
    private PhieuDichVu phieuDichVu;

    @Column(name = "NgayKham")
    private Date ngayKham;

    @Column(name = "PhongKham")
    private String phongKham;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "chuandoan")
    private String chuanDoan;

    @Column(name = "ChiPhi")
    private Long chiPhi;


//    @ManyToOne
//    @JoinColumn(name = "MaHoSo")  // tên cột khóa ngoại trong bảng lichsukham
//    private HoSoBeNhan hoSoBeNhan;

    public HoSoBeNhan getHoSoBenhNhan() {
        return hoSoBeNhan;
    }

    public void setHoSoBenhNhan(HoSoBeNhan hoSoBenhNhan) {
        this.hoSoBeNhan = hoSoBenhNhan;
    }

    public LichSuKham() {
    }

    public int getMaLichSuKham() {
        return maLichSuKham;
    }

    public void setMaLichSuKham(int maLichSuKham) {
        this.maLichSuKham = maLichSuKham;
    }

    public BacSi getBacSi() {
        return bacSi;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }

    public DonThuoc getDonThuoc() {
        return donThuoc;
    }

    public void setDonThuoc(DonThuoc donThuoc) {
        this.donThuoc = donThuoc;
    }

    public HoSoBeNhan getHoSoBeNhan() {
        return hoSoBeNhan;
    }

    public void setHoSoBeNhan(HoSoBeNhan hoSoBeNhan) {
        this.hoSoBeNhan = hoSoBeNhan;
    }

    public PhieuDichVu getPhieuDichVu() {
        return phieuDichVu;
    }

    public void setPhieuDichVu(PhieuDichVu phieuDichVu) {
        this.phieuDichVu = phieuDichVu;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getPhongKham() {
        return phongKham;
    }

    public void setPhongKham(String phongKham) {
        this.phongKham = phongKham;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public Long getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Long chiPhi) {
        this.chiPhi = chiPhi;
    }
}
