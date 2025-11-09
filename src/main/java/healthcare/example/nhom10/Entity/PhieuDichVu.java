package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phieudichvu")
public class PhieuDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSoPhieu")
    private int maSoPhieu;

    @Column(name = "MaDichVu")
    private int maDichVu;

    @Column(name = "SoLuong")
    private int soLuong;

    public PhieuDichVu() {
    }

    public int getMaSoPhieu() {
        return maSoPhieu;
    }

    public void setMaSoPhieu(int maSoPhieu) {
        this.maSoPhieu = maSoPhieu;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
