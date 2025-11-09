package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "nguoigiamho")
public class NguoiGiamHo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGiamHo")
    private int maGiamHo;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonId",referencedColumnName = "PersonId")
    private Nguoi nguoi;

    @Column(name = "NgheNghiep")
    private String ngheNghiep;

    @Column(name = "MoiQuanHe")
    private String moiQuanHe;

    @Column(name = "NgayGiamHo")
    private Date ngayGiamHo;



    public NguoiGiamHo() {
    }

    public int getMaGiamHo() {
        return maGiamHo;
    }

    public void setMaGiamHo(int maGiamHo) {
        this.maGiamHo = maGiamHo;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getMoiQuanHe() {
        return moiQuanHe;
    }

    public void setMoiQuanHe(String moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
    }

    public Date getNgayGiamHo() {
        return ngayGiamHo;
    }

    public void setNgayGiamHo(Date ngayGiamHo) {
        this.ngayGiamHo = ngayGiamHo;
    }

    @Override
    public String toString() {
        return this.maGiamHo+" "+this.nguoi.toString();
    }
}
