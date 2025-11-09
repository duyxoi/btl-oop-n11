package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kedon")
public class KeDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKeDon")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaDonThuoc",referencedColumnName = "MaDonThuoc")
    private DonThuoc donThuoc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaThuoc",referencedColumnName = "MaThuoc")
    private LoaiThuoc loaiThuoc;

    public KeDon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DonThuoc getDonThuoc() {
        return donThuoc;
    }

    public void setDonThuoc(DonThuoc donThuoc) {
        this.donThuoc = donThuoc;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }
}
