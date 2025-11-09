package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "benhnhan")
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBenhNhan")
    private int maBenhNhan;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonId",referencedColumnName = "PersonId")
    private Nguoi nguoi;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "MaGiamHo",referencedColumnName = "MaGiamHo")
    private NguoiGiamHo nguoiGiamHo;

    @Column(name = "NhomMau")
    private String nhomMau;

    @Column(name = "TienSuBenh")
    private String tienSuBenh;

    @Column(name = "MaBaoHiem")
    private String maBaoHiem;

    public BenhNhan() {
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public NguoiGiamHo getNguoiGiamHo() {
        return nguoiGiamHo;
    }

    public void setNguoiGiamHo(NguoiGiamHo nguoiGiamHo) {
        this.nguoiGiamHo = nguoiGiamHo;
    }

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public String getMaBaoHiem() {
        return maBaoHiem;
    }

    public void setMaBaoHiem(String maBaoHiem) {
        this.maBaoHiem = maBaoHiem;
    }

    public String getTienSuBenh() {
        return tienSuBenh;
    }

    public void setTienSuBenh(String tienSuBenh) {
        this.tienSuBenh = tienSuBenh;
    }

    public String toString(){
        return "Benh Nhan so: "+maBenhNhan+" "+nguoi;
    }
}
