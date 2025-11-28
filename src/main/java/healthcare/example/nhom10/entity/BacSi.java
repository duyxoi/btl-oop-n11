package healthcare.example.nhom10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bacsi")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBacSi")
    private int maBacSi;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    private Nguoi nguoi;

    @Column(name = "CapDoHanhNghe")
    private String capDoHanhNghe;

    @ManyToOne
    @JoinColumn(name = "MaKhoa") // khóa ngoại trong bảng bác sĩ
    private Khoa khoa; // 🔹 tên biến là 'khoa' (chữ thường)

    public BacSi() {
    }

    public int getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(int maBacSi) {
        this.maBacSi = maBacSi;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public String getCapDoHanhNghe() {
        return capDoHanhNghe;
    }

    public void setCapDoHanhNghe(String capDoHanhNghe) {
        this.capDoHanhNghe = capDoHanhNghe;
    }


    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
}
