package healthcare.example.nhom10.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hosobenhan")
public class HoSoBeNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHoSo")
    private int maHoSo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaBenhNhan")
    private BenhNhan benhNhan;

    @OneToMany(mappedBy = "hoSoBeNhan", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<LichSuKham> lichSuKham;


    @Column(name ="NgayNhapVien")
    private Date ngayNhapVien;

    @Column(name = "NgayXuatVien")
    private Date ngayXuatVien;

    @Column(name = "ChanDoan")
    private String chuanDoan;

    @Column(name = "PhuongAnDieuTri")
    private String phuongAnDieuTri;

    @Column(name = "KetQua")
    private String ketQua;

    public HoSoBeNhan() {
    }

    public int getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(int maHoSo) {
        this.maHoSo = maHoSo;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public List<LichSuKham> getLichSuKham() {
        return lichSuKham;
    }

    public void setLichSuKham(List<LichSuKham> lichSuKham) {
        this.lichSuKham = lichSuKham;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getPhuongAnDieuTri() {
        return phuongAnDieuTri;
    }

    public void setPhuongAnDieuTri(String phuongAnDieuTri) {
        this.phuongAnDieuTri = phuongAnDieuTri;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public Date getNgayXuatVien() {
        return ngayXuatVien;
    }

    public void setNgayXuatVien(Date ngayXuatVien) {
        this.ngayXuatVien = ngayXuatVien;
    }
}
