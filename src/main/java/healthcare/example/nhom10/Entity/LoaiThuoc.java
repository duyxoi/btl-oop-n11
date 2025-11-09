package healthcare.example.nhom10.Entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loaithuoc")
public class LoaiThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThuoc")
    private int maThuoc;

    @Column(name = "TenThuoc")
    private String tenThuoc;

    @Column(name = "GiaThuoc")
    private double giaThuoc;

    @Column(name = "HanSuDung")
    private Date hanSuDung;

    public LoaiThuoc() {
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(double giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
}
