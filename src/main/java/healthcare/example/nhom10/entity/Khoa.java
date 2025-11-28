package healthcare.example.nhom10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhoa")
    private int maKhoa;

    @Column(name = "TenKhoa")
    private String tenKhoa;

    @Column(name = "ViTri")
    private String viTri;

    @OneToMany(mappedBy = "khoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BacSi> bacSi; // 🔹 mappedBy = "khoa" trùng với tên biến bên BacSi


    public Khoa() {
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public List<BacSi> getBacSi() {
        return bacSi;
    }

    public void setBacSi(List<BacSi> bacSi) {
        this.bacSi = bacSi;
    }
}
