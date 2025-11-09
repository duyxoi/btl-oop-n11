package healthcare.example.nhom10.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donthuoc")
public class DonThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDonThuoc")
    private int maDonThuoc;

    @Column(name = "NgayKeDon")
    private Date ngayKeDon;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MaDonThuoc",referencedColumnName = "MaDonThuoc")
    private List<KeDon> keDon;

    public DonThuoc() {
    }

    public int getMaDonThuoc() {
        return maDonThuoc;
    }

    public void setMaDonThuoc(int maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public Date getNgayKeDon() {
        return ngayKeDon;
    }

    public void setNgayKeDon(Date ngayKeDon) {
        this.ngayKeDon = ngayKeDon;
    }

    public List<KeDon> getKeDon() {
        return keDon;
    }

    public void setKeDon(List<KeDon> keDon) {
        this.keDon = keDon;
    }
}
