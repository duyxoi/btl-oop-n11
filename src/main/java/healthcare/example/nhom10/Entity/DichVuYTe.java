    package healthcare.example.nhom10.Entity;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "dichvuyte")
    public class DichVuYTe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "MaDichVu")
        private int maDichVu;

        @Column(name = "TenDichVu")
        private String tenDichVu;

        @Column(name = "ChiPhi")
        private Double chiPhi;

        public DichVuYTe() {
        }

        public int getMaDichVu() {
            return maDichVu;
        }

        public void setMaDichVu(int maDichVu) {
            this.maDichVu = maDichVu;
        }

        public Double getChiPhi() {
            return chiPhi;
        }

        public void setChiPhi(Double chiPhi) {
            this.chiPhi = chiPhi;
        }

        public String getTenDichVu() {
            return tenDichVu;
        }

        public void setTenDichVu(String tenDichVu) {
            this.tenDichVu = tenDichVu;
        }
    }
