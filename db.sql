CREATE DATABASE  IF NOT EXISTS `hosobenhnhan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hosobenhnhan`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hosobenhnhan
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bacsi`
--

DROP TABLE IF EXISTS `bacsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bacsi` (
                         `MaBacSi` int NOT NULL AUTO_INCREMENT,
                         `PersonId` int NOT NULL,
                         `MaKhoa` int NOT NULL,
                         `CapDoHanhNghe` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         PRIMARY KEY (`MaBacSi`),
                         KEY `PersonId` (`PersonId`),
                         KEY `MaKhoa` (`MaKhoa`),
                         CONSTRAINT `bacsi_ibfk_1` FOREIGN KEY (`PersonId`) REFERENCES `nguoi` (`PersonId`),
                         CONSTRAINT `bacsi_ibfk_2` FOREIGN KEY (`MaKhoa`) REFERENCES `khoa` (`MaKhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bacsi`
--

LOCK TABLES `bacsi` WRITE;
/*!40000 ALTER TABLE `bacsi` DISABLE KEYS */;
INSERT INTO `bacsi` VALUES (1,1,1,'Chuyên khoa I'),(2,2,2,'Chuyên khoa II'),(3,3,3,'Chuyên khoa III'),(4,4,4,'Chuyên khoa I'),(5,5,5,'Chuyên khoa II'),(6,6,6,'Chuyên khoa III'),(7,7,7,'Chuyên khoa I'),(8,8,8,'Chuyên khoa II'),(9,9,9,'Chuyên khoa III'),(10,10,10,'Chuyên khoa I'),(11,11,11,'Chuyên khoa II'),(12,12,12,'Chuyên khoa III'),(13,13,13,'Chuyên khoa I'),(14,14,14,'Chuyên khoa II'),(15,15,15,'Chuyên khoa III'),(16,16,16,'Chuyên khoa I'),(17,17,17,'Chuyên khoa II'),(18,18,18,'Chuyên khoa III'),(19,19,19,'Chuyên khoa I'),(20,20,20,'Chuyên khoa II'),(21,21,21,'Chuyên khoa III'),(22,22,22,'Chuyên khoa I'),(23,23,23,'Chuyên khoa II'),(24,24,24,'Chuyên khoa III'),(25,25,25,'Chuyên khoa I'),(26,26,26,'Chuyên khoa II'),(27,27,27,'Chuyên khoa III'),(28,28,28,'Chuyên khoa I'),(29,29,29,'Chuyên khoa II'),(30,30,30,'Chuyên khoa III');
/*!40000 ALTER TABLE `bacsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benhnhan`
--

DROP TABLE IF EXISTS `benhnhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benhnhan` (
                            `MaBenhNhan` int NOT NULL AUTO_INCREMENT,
                            `PersonId` int NOT NULL,
                            `MaGiamHo` int DEFAULT NULL,
                            `NhomMau` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            `TienSuBenh` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `MaBaoHiem` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                            PRIMARY KEY (`MaBenhNhan`),
                            KEY `PersonId` (`PersonId`),
                            KEY `MaGiamHo` (`MaGiamHo`),
                            CONSTRAINT `benhnhan_ibfk_1` FOREIGN KEY (`PersonId`) REFERENCES `nguoi` (`PersonId`),
                            CONSTRAINT `benhnhan_ibfk_2` FOREIGN KEY (`MaGiamHo`) REFERENCES `nguoigiamho` (`MaGiamHo`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benhnhan`
--

LOCK TABLES `benhnhan` WRITE;
/*!40000 ALTER TABLE `benhnhan` DISABLE KEYS */;
INSERT INTO `benhnhan` VALUES (1,41,8,'O','Viêm mũi dị ứng','3094827156'),(2,42,NULL,'A','Tăng huyết áp','4102938576'),(3,43,6,'B','Không rõ','5810627349'),(4,44,NULL,'AB','Đái tháo đường','6739041258'),(5,45,4,'O','Rối loạn mỡ máu','7820453916'),(6,46,NULL,'A','Không','8941203765'),(7,47,NULL,'B','Viêm dạ dày','9056724183'),(8,48,NULL,'AB','Gout','1029384756'),(9,49,7,'O','Không','2143658709'),(10,50,NULL,'A','Không','3254781906'),(11,51,NULL,'B','Viêm xoang','4365972810'),(12,52,NULL,'AB','Không','5476813920'),(13,53,5,'O','Không','6587093142'),(14,54,NULL,'A','Viêm khớp','7698204351'),(15,55,NULL,'B','Không','8709136245'),(16,56,9,'AB','Không','9810247356'),(17,57,NULL,'O','Không','1928374650'),(18,58,NULL,'A','Không','2039485761'),(19,59,10,'B','Không','3140596872'),(20,60,NULL,'AB','Không','4251607983'),(21,61,NULL,'O','Không','5362718094'),(22,62,NULL,'A','Không','6473829015'),(23,63,2,'B','Không','7584930126'),(24,64,NULL,'AB','Không','8695041237'),(25,65,NULL,'O','Không','9706152348'),(26,66,NULL,'A','Không','0817263459'),(27,67,3,'B','Không','1928374651'),(28,68,NULL,'AB','Không','2938475610'),(29,69,1,'O','Không','3948576120'),(30,70,NULL,'A','Không','4959687231'),(32,73,NULL,'A','Trĩ nội mãn tính','12345678910'),(33,74,NULL,'A','Dạ dày thái tràng','12345678911');
/*!40000 ALTER TABLE `benhnhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datlichkham`
--

DROP TABLE IF EXISTS `datlichkham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datlichkham` (
                               `MaLichKham` int NOT NULL AUTO_INCREMENT,
                               `MaBacSi` int DEFAULT NULL,
                               `MaBenhNhan` int DEFAULT NULL,
                               `NgayTaoLich` date DEFAULT NULL,
                               `NgayKham` timestamp NOT NULL,
                               `TrangThai` varchar(20) DEFAULT 'DA_XAC_NHAN',
                               `MaKhoa` int DEFAULT NULL,
                               PRIMARY KEY (`MaLichKham`),
                               KEY `MaBacSi` (`MaBacSi`),
                               KEY `MaBenhNhan` (`MaBenhNhan`),
                               KEY `fk_datlichkham_3` (`MaKhoa`),
                               CONSTRAINT `datlichkham_ibfk_1` FOREIGN KEY (`MaBacSi`) REFERENCES `bacsi` (`MaBacSi`),
                               CONSTRAINT `datlichkham_ibfk_2` FOREIGN KEY (`MaBenhNhan`) REFERENCES `benhnhan` (`MaBenhNhan`),
                               CONSTRAINT `fk_datlichkham_3` FOREIGN KEY (`MaKhoa`) REFERENCES `khoa` (`MaKhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datlichkham`
--

LOCK TABLES `datlichkham` WRITE;
/*!40000 ALTER TABLE `datlichkham` DISABLE KEYS */;
INSERT INTO `datlichkham` VALUES (28,1,22,'2025-11-25','2025-11-25 01:30:00','DA_XAC_NHAN',1);
/*!40000 ALTER TABLE `datlichkham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvuyte`
--

DROP TABLE IF EXISTS `dichvuyte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvuyte` (
                             `MaDichVu` int NOT NULL AUTO_INCREMENT,
                             `TenDichVu` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                             `ChiPhi` decimal(18,2) NOT NULL,
                             PRIMARY KEY (`MaDichVu`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvuyte`
--

LOCK TABLES `dichvuyte` WRITE;
/*!40000 ALTER TABLE `dichvuyte` DISABLE KEYS */;
INSERT INTO `dichvuyte` VALUES (1,'Khám tổng quát',300000.00),(2,'Xét nghiệm máu tổng quát',250000.00),(3,'Chụp X-quang phổi',350000.00),(4,'Siêu âm bụng tổng quát',400000.00),(5,'Điện tâm đồ (ECG)',200000.00),(6,'Nội soi dạ dày',850000.00),(7,'Nội soi đại tràng',950000.00),(8,'Chụp CT Scanner',1500000.00),(9,'Cộng hưởng từ (MRI)',2200000.00),(10,'Khám chuyên khoa tim mạch',500000.00),(11,'Khám chuyên khoa thần kinh',550000.00),(12,'Khám chuyên khoa da liễu',400000.00),(13,'Khám tai mũi họng',350000.00),(14,'Khám mắt',300000.00),(15,'Khám răng hàm mặt',450000.00),(16,'Phẫu thuật tiểu phẫu',1200000.00),(17,'Phẫu thuật ngoại khoa',3500000.00),(18,'Điều trị vật lý trị liệu',600000.00),(19,'Tiêm chủng vắc-xin',250000.00),(20,'Tư vấn dinh dưỡng',200000.00),(21,'Khám Chim',10000.00),(22,'Khám Lồn',123000.00);
/*!40000 ALTER TABLE `dichvuyte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donthuoc`
--

DROP TABLE IF EXISTS `donthuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donthuoc` (
                            `MaDonThuoc` int NOT NULL AUTO_INCREMENT,
                            `NgayKeDon` date NOT NULL,
                            PRIMARY KEY (`MaDonThuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donthuoc`
--

LOCK TABLES `donthuoc` WRITE;
/*!40000 ALTER TABLE `donthuoc` DISABLE KEYS */;
INSERT INTO `donthuoc` VALUES (1,'2024-02-11'),(2,'2024-03-16'),(3,'2024-04-21'),(4,'2024-05-26'),(5,'2024-06-13'),(6,'2024-07-01'),(7,'2024-07-11'),(8,'2024-07-29'),(9,'2024-08-04'),(10,'2024-08-21'),(11,'2024-09-06'),(12,'2024-09-23'),(13,'2024-10-04'),(14,'2024-10-21'),(15,'2024-11-03'),(16,'2024-11-19'),(17,'2024-12-04'),(18,'2024-12-20'),(19,'2025-01-05'),(20,'2025-01-21'),(21,'2025-02-02'),(22,'2025-02-19'),(23,'2025-03-04'),(24,'2025-03-16'),(25,'2025-03-31'),(26,'2025-04-11'),(27,'2025-04-26'),(28,'2025-05-07'),(29,'2025-05-21'),(30,'2025-06-03'),(31,'2025-11-08'),(32,'2025-11-01'),(33,'2025-11-01'),(34,'2025-11-01'),(35,'2025-11-01'),(36,'2025-11-01'),(37,'2025-11-01'),(38,'2025-11-03'),(39,'2025-11-03'),(40,'2025-11-12'),(41,'2025-11-12'),(42,'2025-11-23');
/*!40000 ALTER TABLE `donthuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hosobenhan`
--

DROP TABLE IF EXISTS `hosobenhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hosobenhan` (
                              `MaHoSo` int NOT NULL AUTO_INCREMENT,
                              `MaBenhNhan` int NOT NULL,
                              `NgayNhapVien` date DEFAULT NULL,
                              `NgayXuatVien` date DEFAULT NULL,
                              `ChanDoan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              `PhuongAnDieuTri` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              `KetQua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              PRIMARY KEY (`MaHoSo`),
                              KEY `MaBenhNhan` (`MaBenhNhan`),
                              CONSTRAINT `hosobenhan_ibfk_1` FOREIGN KEY (`MaBenhNhan`) REFERENCES `benhnhan` (`MaBenhNhan`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hosobenhan`
--

LOCK TABLES `hosobenhan` WRITE;
/*!40000 ALTER TABLE `hosobenhan` DISABLE KEYS */;
INSERT INTO `hosobenhan` VALUES (1,17,'2024-02-10','2024-02-14','Viêm phổi cộng đồng','Dùng kháng sinh, hạ sốt, hỗ trợ hô hấp','Ổn định'),(2,4,'2024-03-15','2024-03-18','Thiếu máu nhẹ','Truyền sắt và bổ sung vitamin','Khỏi'),(3,13,'2024-04-20','2024-04-24','Viêm phổi nhẹ cần chẩn đoán hình ảnh','Chụp X-quang phổi, điều trị kháng sinh','Ổn định'),(4,25,'2024-05-25','2024-05-29','Sỏi mật','Siêu âm và hội chẩn ngoại khoa','Ổn định'),(5,29,'2024-06-12','2024-06-16','Tăng huyết áp độ 2','Điều chỉnh thuốc và theo dõi tim mạch','Đỡ'),(6,11,'2024-06-30','2024-07-04','Viêm dạ dày HP (+)','Phác đồ diệt HP, ức chế bơm proton','Khỏi'),(7,20,'2024-07-10','2024-07-15','Polyp đại tràng','Nội soi cắt polyp','Khỏi'),(8,2,'2024-07-28','2024-07-31','Chấn thương ngực kín','Chụp CT lồng ngực, điều trị giảm đau','Ổn định'),(9,27,'2024-08-03','2024-08-07','Đau đầu kéo dài chưa rõ nguyên nhân','Chụp MRI não và theo dõi thần kinh','Đỡ'),(10,8,'2024-08-20','2024-08-23','Cơn đau thắt ngực ổn định','Điều trị nội khoa tim mạch','Ổn định'),(11,18,'2024-09-05','2024-09-12','Rối loạn tiền đình','Dùng thuốc và tập phục hồi chức năng','Đỡ'),(12,30,'2024-09-22','2024-09-25','Viêm da dị ứng','Dùng thuốc kháng histamin và bôi corticoid','Khỏi'),(13,1,'2024-10-03','2024-10-06','Viêm amidan cấp','Kháng sinh và hạ sốt','Khỏi'),(14,14,'2024-10-20','2024-10-22','Viêm kết mạc','Nhỏ kháng sinh, nghỉ ngơi','Khỏi'),(15,23,'2024-11-02','2024-11-07','Sâu răng, viêm tủy','Lấy tủy, trám răng','Khỏi'),(16,6,'2024-11-18','2024-11-24','U nang thượng bì nhỏ','Tiểu phẫu lấy u','Khỏi'),(17,26,'2024-12-03','2024-12-10','Thoát vị bẹn','Phẫu thuật ngoại khoa','Khỏi'),(18,9,'2024-12-19','2024-12-24','Hội chứng cổ vai gáy','Điều trị vật lý trị liệu','Đỡ'),(19,22,'2025-01-04','2025-01-08','Cúm A','Dùng thuốc kháng virus và hạ sốt','Khỏi'),(20,10,'2025-01-20','2025-01-23','Suy dinh dưỡng mức độ nhẹ','Tư vấn chế độ ăn, bổ sung vi chất','Đỡ'),(21,24,'2025-02-01','2025-02-05','Tăng men gan nhẹ','Theo dõi và điều chỉnh thuốc','Ổn định'),(22,5,'2025-02-18','2025-02-21','Viêm họng cấp','Súc họng, uống kháng sinh','Khỏi'),(23,19,'2025-03-03','2025-03-09','Áp xe răng','Rạch dẫn lưu và kháng sinh','Khỏi'),(24,21,'2025-03-17','2025-11-12','Chàm thể tạng bùng phátt','Dùng thuốc duy trì, tái khám định kì','Đang điều trị'),(25,28,'2025-03-30','2025-04-03','Chấn thương phần mềm chi dưới','Chụp X-quang, cố định tạm thời','Ổn định'),(26,3,'2025-04-10','2025-04-14','Xuất huyết dạ dày nhẹ','Nội soi cầm máu, dùng PPI liều cao','Ổn định'),(27,15,'2025-04-25',NULL,'Đau đầu mạn tính','Thuốc dự phòng và theo dõi','Đang điều trị'),(28,16,'2025-05-06','2025-05-11','Hở van hai lá nhẹ','Điều trị nội khoa tim mạch','Ổn định'),(29,12,'2025-05-20',NULL,'Đau bụng chưa rõ nguyên nhân','Siêu âm, theo dõi thêm','Đang điều trị'),(30,7,'2025-06-02',NULL,'Đau thắt lưng do thoái hóa','Vật lý trị liệu, thuốc giảm đau','Đang điều trị'),(31,33,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hosobenhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kedon`
--

DROP TABLE IF EXISTS `kedon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kedon` (
                         `MaKeDon` int NOT NULL AUTO_INCREMENT,
                         `MaDonThuoc` int DEFAULT NULL,
                         `MaThuoc` int DEFAULT NULL,
                         `lieuluong` varchar(50) DEFAULT NULL,
                         `huongdansudung` text,
                         PRIMARY KEY (`MaKeDon`),
                         KEY `MaDonThuoc` (`MaDonThuoc`),
                         KEY `MaThuoc` (`MaThuoc`),
                         CONSTRAINT `kedon_ibfk_1` FOREIGN KEY (`MaDonThuoc`) REFERENCES `donthuoc` (`MaDonThuoc`),
                         CONSTRAINT `kedon_ibfk_2` FOREIGN KEY (`MaThuoc`) REFERENCES `loaithuoc` (`MaThuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kedon`
--

LOCK TABLES `kedon` WRITE;
/*!40000 ALTER TABLE `kedon` DISABLE KEYS */;
INSERT INTO `kedon` VALUES (1,1,1,NULL,NULL),(2,2,2,NULL,NULL),(3,3,3,NULL,NULL),(4,4,4,NULL,NULL),(5,5,5,NULL,NULL),(6,6,6,NULL,NULL),(7,7,7,NULL,NULL),(8,8,8,NULL,NULL),(9,9,9,NULL,NULL),(10,10,10,NULL,NULL),(11,11,11,NULL,NULL),(12,12,12,NULL,NULL),(13,13,13,NULL,NULL),(14,14,14,NULL,NULL),(15,15,15,NULL,NULL),(16,16,16,NULL,NULL),(17,17,17,NULL,NULL),(18,18,18,NULL,NULL),(19,19,19,NULL,NULL),(20,20,20,NULL,NULL),(21,21,21,NULL,NULL),(22,22,22,NULL,NULL),(23,23,23,NULL,NULL),(24,24,24,NULL,NULL),(25,25,25,NULL,NULL),(26,26,26,NULL,NULL),(27,27,27,NULL,NULL),(28,28,28,NULL,NULL),(29,29,29,NULL,NULL),(30,30,30,NULL,NULL),(31,1,5,NULL,NULL),(32,6,9,NULL,NULL),(33,5,3,NULL,NULL),(34,31,1,'2 viên 1 ngày','1 sáng'),(35,32,14,'ấ','ầd'),(36,33,18,'va','dsa'),(37,34,18,'fa','fa'),(38,35,23,'ấ','gaga'),(39,36,14,'ga','ga'),(40,37,15,'va','1 sáng'),(41,38,15,'2 viên 1 ngày','1 sáng'),(42,39,15,'2 viên 1 ngày','1 sáng , 1 tối'),(43,39,14,'2 viên 1 ngày','1 sáng , 1 tối'),(44,40,13,'2 viên 1 ngày','1 sáng'),(45,41,1,'ấ','ga'),(46,42,15,'2 viên 1 ngày','1 sáng');
/*!40000 ALTER TABLE `kedon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
                        `MaKhoa` int NOT NULL AUTO_INCREMENT,
                        `TenKhoa` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                        `ViTri` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                        PRIMARY KEY (`MaKhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'Khoa Nội Tổng Hợp','Tầng 2 - Tòa A'),(2,'Khoa Ngoại Tổng Hợp','Tầng 3 - Tòa A'),(3,'Khoa Nhi','Tầng 4 - Tòa A'),(4,'Khoa Sản','Tầng 5 - Tòa A'),(5,'Khoa Tai Mũi Họng','Tầng 2 - Tòa B'),(6,'Khoa Mắt','Tầng 3 - Tòa B'),(7,'Khoa Răng Hàm Mặt','Tầng 4 - Tòa B'),(8,'Khoa Tim Mạch','Tầng 5 - Tòa B'),(9,'Khoa Thần Kinh','Tầng 6 - Tòa A'),(10,'Khoa Da Liễu','Tầng 2 - Tòa C'),(11,'Khoa Hô Hấp','Tầng 3 - Tòa C'),(12,'Khoa Tiêu Hóa','Tầng 4 - Tòa C'),(13,'Khoa Thận - Tiết Niệu','Tầng 5 - Tòa C'),(14,'Khoa Cơ Xương Khớp','Tầng 6 - Tòa C'),(15,'Khoa Huyết Học','Tầng 7 - Tòa A'),(16,'Khoa Truyền Nhiễm','Tầng 8 - Tòa A'),(17,'Khoa Ung Bướu','Tầng 9 - Tòa A'),(18,'Khoa Phục Hồi Chức Năng','Tầng 2 - Tòa D'),(19,'Khoa Dinh Dưỡng','Tầng 3 - Tòa D'),(20,'Khoa Cấp Cứu','Tầng 1 - Tòa A'),(21,'Khoa Xét Nghiệm','Tầng 1 - Tòa B'),(22,'Khoa Chẩn Đoán Hình Ảnh','Tầng 1 - Tòa C'),(23,'Khoa Phẫu Thuật Gây Mê Hồi Sức','Tầng 2 - Tòa E'),(24,'Khoa Tâm Thần','Tầng 3 - Tòa E'),(25,'Khoa Y Học Cổ Truyền','Tầng 4 - Tòa E'),(26,'Khoa Da Liễu - Thẩm Mỹ','Tầng 5 - Tòa E'),(27,'Khoa Kiểm Soát Nhiễm Khuẩn','Tầng 6 - Tòa E'),(28,'Khoa Sơ Sinh','Tầng 7 - Tòa B'),(29,'Khoa Hồi Sức Tích Cực','Tầng 8 - Tòa B'),(30,'Khoa Y Học Hạt Nhân','Tầng 9 - Tòa B'),(31,'Khoa Tâm Lý Học','Tầng 5 - Tòa A');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichsukham`
--

DROP TABLE IF EXISTS `lichsukham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichsukham` (
                              `MaLichSuKham` int NOT NULL AUTO_INCREMENT,
                              `MaBacSi` int NOT NULL,
                              `MaDonThuoc` int NOT NULL,
                              `MaHoSo` int NOT NULL,
                              `NgayKham` date DEFAULT NULL,
                              `PhongKham` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                              `MaSoPhieu` int DEFAULT NULL,
                              `GhiChu` text,
                              `chuandoan` text,
                              `ChiPhi` int DEFAULT '0',
                              PRIMARY KEY (`MaLichSuKham`),
                              KEY `MaBacSi` (`MaBacSi`),
                              KEY `MaDonThuoc` (`MaDonThuoc`),
                              KEY `MaHoSo` (`MaHoSo`),
                              KEY `fk_lichsukham_phieudichvu` (`MaSoPhieu`),
                              CONSTRAINT `fk_lichsukham_phieudichvu` FOREIGN KEY (`MaSoPhieu`) REFERENCES `phieudichvu` (`MaSoPhieu`),
                              CONSTRAINT `lichsukham_ibfk_2` FOREIGN KEY (`MaBacSi`) REFERENCES `bacsi` (`MaBacSi`),
                              CONSTRAINT `lichsukham_ibfk_3` FOREIGN KEY (`MaDonThuoc`) REFERENCES `donthuoc` (`MaDonThuoc`),
                              CONSTRAINT `lichsukham_ibfk_4` FOREIGN KEY (`MaHoSo`) REFERENCES `hosobenhan` (`MaHoSo`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichsukham`
--

LOCK TABLES `lichsukham` WRITE;
/*!40000 ALTER TABLE `lichsukham` DISABLE KEYS */;
INSERT INTO `lichsukham` VALUES (1,1,1,1,'2024-02-10','Khoa Nội Tổng Hợp - Tầng 2 - Tòa A',1,NULL,NULL,350000),(2,21,2,2,'2024-03-15','Khoa Xét Nghiệm - Tầng 1 - Tòa B',2,NULL,NULL,275000),(3,22,3,3,'2024-04-20','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',3,NULL,NULL,362000),(4,22,4,4,'2024-05-25','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',4,NULL,NULL,428000),(5,8,5,5,'2024-06-12','Khoa Tim Mạch - Tầng 5 - Tòa B',5,NULL,NULL,247000),(6,12,6,6,'2024-06-30','Khoa Tiêu Hóa - Tầng 4 - Tòa C',6,NULL,NULL,900000),(7,12,7,7,'2024-07-10','Khoa Tiêu Hóa - Tầng 4 - Tòa C',7,NULL,NULL,995000),(8,22,8,8,'2024-07-28','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',8,NULL,NULL,1522000),(9,22,9,9,'2024-08-03','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',9,NULL,NULL,2218000),(10,8,10,10,'2024-08-20','Khoa Tim Mạch - Tầng 5 - Tòa B',10,NULL,NULL,530000),(11,9,11,11,'2024-09-05','Khoa Thần Kinh - Tầng 6 - Tòa A',11,NULL,NULL,577000),(12,10,12,12,'2024-09-22','Khoa Da Liễu - Tầng 2 - Tòa C',12,NULL,NULL,424000),(13,5,13,13,'2024-10-03','Khoa Tai Mũi Họng - Tầng 2 - Tòa B',13,NULL,NULL,371000),(14,6,14,14,'2024-10-20','Khoa Mắt - Tầng 3 - Tòa B',14,NULL,NULL,315000),(15,7,15,15,'2024-11-02','Khoa Răng Hàm Mặt - Tầng 4 - Tòa B',15,NULL,NULL,490000),(16,2,16,16,'2024-11-18','Khoa Ngoại Tổng Hợp - Tầng 3 - Tòa A',16,NULL,NULL,1220000),(17,2,17,17,'2024-12-03','Khoa Ngoại Tổng Hợp - Tầng 3 - Tòa A',17,NULL,NULL,3522000),(18,18,18,18,'2024-12-19','Khoa Phục Hồi Chức Năng - Tầng 2 - Tòa D',18,NULL,NULL,615000),(19,16,19,19,'2025-01-04','Khoa Truyền Nhiễm - Tầng 8 - Tòa A',19,NULL,NULL,268000),(20,19,20,20,'2025-01-20','Khoa Dinh Dưỡng - Tầng 3 - Tòa D',20,NULL,NULL,242000),(21,21,21,21,'2025-02-01','Khoa Xét Nghiệm - Tầng 1 - Tòa B',21,NULL,NULL,262000),(22,5,22,22,'2025-02-18','Khoa Tai Mũi Họng - Tầng 2 - Tòa B',22,NULL,NULL,368000),(23,7,23,23,'2025-03-03','Khoa Răng Hàm Mặt - Tầng 4 - Tòa B',23,NULL,NULL,475000),(24,10,24,24,'2025-03-15','Khoa Da Liễu - Tầng 2 - Tòa C',24,NULL,NULL,435000),(25,22,25,25,'2025-03-30','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',25,NULL,NULL,1528000),(26,12,26,26,'2025-04-10','Khoa Tiêu Hóa - Tầng 4 - Tòa C',26,NULL,NULL,876000),(27,9,27,27,'2025-04-25','Khoa Thần Kinh - Tầng 6 - Tòa A',27,NULL,NULL,577000),(28,8,28,28,'2025-05-06','Khoa Tim Mạch - Tầng 5 - Tòa B',28,NULL,NULL,530000),(29,22,29,29,'2025-05-20','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',29,NULL,NULL,442000),(30,18,30,30,'2025-06-02','Khoa Phục Hồi Chức Năng - Tầng 2 - Tòa D',30,NULL,NULL,615000),(34,2,40,24,'2025-11-12','Tầng 3 - Tòa A',33,'khong co','viem chim',971000),(35,2,41,24,'2025-11-12','Tầng 3 - Tòa A',34,'khog','benh tri',315000),(36,1,42,31,'2025-11-23','Tầng 2 - Tòa A',35,'uống thuốc đầy đủ','trĩ',340000);
/*!40000 ALTER TABLE `lichsukham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaithuoc`
--

DROP TABLE IF EXISTS `loaithuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaithuoc` (
                             `MaThuoc` int NOT NULL AUTO_INCREMENT,
                             `TenThuoc` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                             `GiaThuoc` decimal(18,2) NOT NULL,
                             `HanSuDung` date NOT NULL,
                             PRIMARY KEY (`MaThuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaithuoc`
--

LOCK TABLES `loaithuoc` WRITE;
/*!40000 ALTER TABLE `loaithuoc` DISABLE KEYS */;
INSERT INTO `loaithuoc` VALUES (1,'Paracetamol 500mg',15000.00,'2026-01-01'),(2,'Amoxicillin 500mg',25000.00,'2026-02-15'),(3,'Vitamin C 500mg',12000.00,'2026-03-10'),(4,'Cephalexin 500mg',28000.00,'2026-04-05'),(5,'Lansoprazole 30mg',35000.00,'2026-05-01'),(6,'Omeprazole 20mg',32000.00,'2026-05-01'),(7,'Azithromycin 250mg',45000.00,'2026-06-01'),(8,'Metronidazole 250mg',22000.00,'2026-06-20'),(9,'Domperidone 10mg',18000.00,'2026-07-10'),(10,'Esomeprazole 40mg',30000.00,'2026-07-10'),(11,'Lorastad 10mg',27000.00,'2026-07-30'),(12,'Diclofenac 50mg',24000.00,'2026-08-10'),(13,'Ibuprofen 400mg',21000.00,'2026-08-10'),(14,'Panadol Extra',15000.00,'2026-09-01'),(15,'Cefuroxime 250mg',40000.00,'2026-09-01'),(16,'Captopril 25mg',20000.00,'2026-09-30'),(17,'Amlodipine 5mg',22000.00,'2026-09-30'),(18,'Cetirizine 10mg',15000.00,'2026-10-10'),(19,'Efferalgan 500mg',18000.00,'2026-10-20'),(20,'Clarithromycin 250mg',42000.00,'2026-10-20'),(21,'Prednisolone 5mg',12000.00,'2026-11-01'),(22,'Metformin 500mg',18000.00,'2026-11-15'),(23,'Gliclazide 80mg',25000.00,'2026-11-15'),(24,'Alprazolam 0.5mg',35000.00,'2026-12-01'),(25,'Simvastatin 20mg',28000.00,'2026-12-01'),(26,'Ciprofloxacin 500mg',26000.00,'2026-12-15'),(27,'Diclofenac Sodium 75mg',27000.00,'2026-12-15'),(28,'Montelukast 10mg',30000.00,'2027-01-01'),(29,'Amoxicillin + Clavulanic 1g',42000.00,'2027-01-20'),(30,'Vitamin B Complex',15000.00,'2027-02-01'),(31,'Calcium D3 500mg',18000.00,'2027-02-01'),(32,'Enalapril 10mg',23000.00,'2027-02-10'),(33,'Atenolol 50mg',25000.00,'2027-02-10'),(34,'Loratadine 10mg',15000.00,'2027-03-01'),(35,'morphin 50g',50000000.00,'2027-06-09'),(36,'thuốc lắc',1232100.00,'2027-09-12');
/*!40000 ALTER TABLE `loaithuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi`
--

DROP TABLE IF EXISTS `nguoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi` (
                         `PersonId` int NOT NULL AUTO_INCREMENT,
                         `cccd` varchar(20) DEFAULT NULL,
                         `HoTen` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `NgaySinh` date NOT NULL,
                         `GioiTinh` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                         `DiaChi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                         `SDT` varchar(20) DEFAULT NULL,
                         `Email` varchar(50) DEFAULT NULL,
                         `username` varchar(50) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `role` varchar(20) DEFAULT NULL,
                         `enabled` tinyint DEFAULT NULL,
                         PRIMARY KEY (`PersonId`),
                         UNIQUE KEY `SDT` (`SDT`),
                         UNIQUE KEY `Email` (`Email`),
                         UNIQUE KEY `username` (`username`),
                         UNIQUE KEY `cccd` (`cccd`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi`
--

LOCK TABLES `nguoi` WRITE;
/*!40000 ALTER TABLE `nguoi` DISABLE KEYS */;
INSERT INTO `nguoi` VALUES (1,'100000000001','Hoang Dinh Duy','1990-03-12','Nam','Hà Nội','0971811294','nguyen.van.an1@example.com','100000000001','{noop}100000000001','ROLE_DOCTOR',1),(2,'100000000002','Trần Thị Bình','1985-07-22','Nữ','Hồ Chí Minh','0901000002','tran.thi.binh2@example.com','100000000002','{noop}100000000002','ROLE_DOCTOR',1),(3,'100000000003','Lê Văn Cường','1978-11-05','Nam','Đà Nẵng','0901000003','le.van.cuong3@example.com','100000000003','{noop}100000000003','ROLE_DOCTOR',1),(4,'100000000004','Phạm Thị Dung','1995-01-30','Nữ','Hải Phòng','0901000004','pham.thi.dung4@example.com','100000000004','{noop}100000000004','ROLE_DOCTOR',1),(5,'100000000005','Hoàng Minh Đức','2000-06-18','Nam','Cần Thơ','0901000005','hoang.minh.duc5@example.com','100000000005','{noop}100000000005','ROLE_DOCTOR',1),(6,'100000000006','Phan Thị Hạnh','1992-10-09','Nữ','Hà Nội','0901000006','phan.thi.hanh6@example.com','100000000006','{noop}100000000006','ROLE_DOCTOR',1),(7,'100000000007','Vũ Minh Hoàng','1988-04-25','Nam','Hồ Chí Minh','0901000007','vu.minh.hoang7@example.com','100000000007','{noop}100000000007','ROLE_DOCTOR',1),(8,'100000000008','Đặng Thị Huyền','1997-09-14','Nữ','Đà Nẵng','0901000008','dang.thi.huyen8@example.com','100000000008','{noop}100000000008','ROLE_DOCTOR',1),(9,'100000000009','Bùi Văn Khang','1969-12-02','Nam','Hải Phòng','0901000009','bui.van.khang9@example.com','100000000009','{noop}100000000009','ROLE_DOCTOR',1),(10,'100000000010','Đỗ Thị Lan','2001-05-20','Nữ','Hồ Chí Minh','0901000010','do.thi.lan10@example.com','100000000010','{noop}100000000010','ROLE_DOCTOR',1),(11,'100000000011','Hồ Văn Long','1991-08-03','Nam','Hà Nội','0901000011','ho.van.long11@example.com','100000000011','{noop}100000000011','ROLE_DOCTOR',1),(12,'100000000012','Dương Thị Mai','1982-02-27','Nữ','Đồng Nai','0901000012','duong.thi.mai12@example.com','100000000012','{noop}100000000012','ROLE_DOCTOR',1),(13,'100000000013','Lý Văn Minh','1975-11-11','Nam','Bình Dương','0901000013','ly.van.minh13@example.com','100000000013','{noop}100000000013','ROLE_DOCTOR',1),(14,'100000000014','Nguyễn Thị Nga','1998-07-07','Nữ','Hải Dương','0901000014','nguyen.thi.nga14@example.com','100000000014','{noop}100000000014','ROLE_DOCTOR',1),(15,'100000000015','Trịnh Văn Nam','1980-03-29','Nam','Quảng Ninh','0901000015','trinh.van.nam15@example.com','100000000015','{noop}100000000015','ROLE_DOCTOR',1),(16,'100000000016','Ngô Thị Oanh','1994-12-19','Nữ','Thanh Hóa','0901000016','ngo.thi.oanh16@example.com','100000000016','{noop}100000000016','ROLE_DOCTOR',1),(17,'100000000017','Cao Văn Phúc','1965-01-02','Nam','Nam Định','0901000017','cao.van.phuc17@example.com','100000000017','{noop}100000000017','ROLE_DOCTOR',1),(18,'100000000018','Lâm Thị Quỳnh','2002-09-26','Nữ','Bà Rịa - Vũng Tàu','0901000018','lam.thi.quynh18@example.com','100000000018','{noop}100000000018','ROLE_DOCTOR',1),(19,'100000000019','Lê Thị Rạng','1987-05-13','Nữ','Hà Nội','0901000019','le.thi.rang19@example.com','100000000019','{noop}100000000019','ROLE_DOCTOR',1),(20,'100000000020','Phan Văn Sơn','1993-06-01','Nam','Hồ Chí Minh','0901000020','phan.van.son20@example.com','100000000020','{noop}100000000020','ROLE_DOCTOR',1),(21,'100000000021','Trần Văn Toàn','1972-10-16','Nam','Kon Tum','0901000021','tran.van.toan21@example.com','100000000021','{noop}100000000021','ROLE_DOCTOR',1),(22,'100000000022','Hoàng Thị Uyên','1996-04-08','Nữ','Vĩnh Phúc','0901000022','hoang.thi.uyen22@example.com','100000000022','{noop}100000000022','ROLE_DOCTOR',1),(23,'100000000023','Vũ Thị Vy','1989-11-30','Nữ','Hải Phòng','0901000023','vu.thi.vy23@example.com','100000000023','{noop}100000000023','ROLE_DOCTOR',1),(24,'100000000024','Đặng Văn Xuân','1999-02-05','Nam','Quảng Nam','0901000024','dang.van.xuan24@example.com','100000000024','{noop}100000000024','ROLE_DOCTOR',1),(25,'100000000025','Bùi Thị Yến','1983-08-21','Nữ','An Giang','0901000025','bui.thi.yen25@example.com','100000000025','{noop}100000000025','ROLE_DOCTOR',1),(26,'100000000026','Đỗ Văn Zương','1977-09-09','Nam','Bắc Ninh','0901000026','do.van.zuong26@example.com','100000000026','{noop}100000000026','ROLE_DOCTOR',1),(27,'100000000027','Nguyễn Minh Ánh','1990-12-24','Nữ','Hà Nội','0901000027','nguyen.minh.anh27@example.com','100000000027','{noop}100000000027','ROLE_DOCTOR',1),(28,'100000000028','Trần Quốc Bảo','1986-03-03','Nam','Hồ Chí Minh','0901000028','tran.quoc.bao28@example.com','100000000028','{noop}100000000028','ROLE_DOCTOR',1),(29,'100000000029','Lê Thị Chi','1991-05-17','Nữ','Đà Nẵng','0901000029','le.thi.chi29@example.com','100000000029','{noop}100000000029','ROLE_DOCTOR',1),(30,'100000000030','Phạm Văn Dũng','1984-07-09','Nam','Hải Phòng','0901000030','pham.van.dung30@example.com','100000000030','{noop}100000000030','ROLE_DOCTOR',1),(31,'100000000031','Hoàng Thị Em','2000-11-01','Nữ','Hồ Chí Minh','0901000031','hoang.thi.em31@example.com','100000000031','{noop}100000000031','ROLE_PATIENT',1),(32,'100000000032','Phan Minh Giang','1995-02-15','Nam','Hà Nội','0901000032','phan.minh.giang32@example.com','100000000032','{noop}100000000032','ROLE_PATIENT',1),(33,'100000000033','Võ Thị Hà','1981-06-06','Nữ','Bắc Giang','0901000033','vo.thi.ha33@example.com','100000000033','{noop}100000000033','ROLE_PATIENT',1),(34,'100000000034','Đặng Minh Hòa','1992-08-12','Nam','Bà Rịa - Vũng Tàu','0901000034','dang.minh.hoa34@example.com','100000000034','{noop}100000000034','ROLE_PATIENT',1),(35,'100000000035','Bùi Thị Hồng','1979-04-28','Nữ','Nam Định','0901000035','bui.thi.hong35@example.com','100000000035','{noop}100000000035','ROLE_PATIENT',1),(36,'100000000036','Đỗ Văn Khoa','1997-09-03','Nam','Hải Dương','0901000036','do.van.khoa36@example.com','100000000036','{noop}100000000036','ROLE_PATIENT',1),(37,'100000000037','Hồ Thị Lan Anh','1988-01-20','Nữ','Hồ Chí Minh','0901000037','ho.thi.lananh37@example.com','100000000037','{noop}100000000037','ROLE_PATIENT',1),(38,'100000000038','Dương Văn Minh','1968-10-10','Nam','Hà Nội','0901000038','duong.van.minh38@example.com','100000000038','{noop}100000000038','ROLE_PATIENT',1),(39,'100000000039','Lý Thị Ngọc','1994-05-29','Nữ','Quảng Bình','0901000039','ly.thi.ngoc39@example.com','100000000039','{noop}100000000039','ROLE_PATIENT',1),(40,'100000000040','Trịnh Văn Phát','1976-12-12','Nam','Quảng Trị','0901000040','trinh.van.phat40@example.com','100000000040','{noop}100000000040','ROLE_PATIENT',1),(41,'100000000041','Ngô Thị Quế','1993-03-18','Nữ','Hải Phòng','0901000041','ngo.thi.que41@example.com','100000000041','{noop}100000000041','ROLE_PATIENT',1),(42,'100000000042','Cao Minh Quân','1982-07-27','Nam','Bình Định','0901000042','cao.minh.quan42@example.com','100000000042','{noop}100000000042','ROLE_PATIENT',1),(43,'100000000043','Lâm Thị Sen','1999-11-15','Nữ','Đà Nẵng','0901000043','lam.thi.sen43@example.com','100000000043','{noop}100000000043','ROLE_PATIENT',1),(44,'100000000044','Lê Văn Tùng','1974-02-08','Nam','Hà Nội','0901000044','le.van.tung44@example.com','100000000044','{noop}100000000044','ROLE_PATIENT',1),(45,'100000000045','Phan Thị Uyên','1996-09-30','Nữ','Hồ Chí Minh','0901000045','phan.thi.uyen45@example.com','100000000045','{noop}100000000045','ROLE_PATIENT',1),(46,'100000000046','Trần Minh Vũ','1987-06-04','Nam','Long An','0901000046','tran.minh.vu46@example.com','100000000046','{noop}100000000046','ROLE_PATIENT',1),(47,'100000000047','Hoàng Thị Xoan','1991-10-23','Nữ','Hà Nội','0901000047','hoang.thi.xoan47@example.com','100000000047','{noop}100000000047','ROLE_PATIENT',1),(48,'100000000048','Vũ Văn Yên','1980-01-07','Nam','Hải Phòng','0901000048','vu.van.yen48@example.com','100000000048','{noop}100000000048','ROLE_PATIENT',1),(49,'100000000049','Đặng Thị Ánh','1998-04-02','Nữ','Bắc Ninh','0901000049','dang.thi.anh49@example.com','100000000049','{noop}100000000049','ROLE_PATIENT',1),(50,'100000000050','Bùi Minh Bình','1973-05-05','Nam','Hồ Chí Minh','0901000050','bui.minh.binh50@example.com','100000000050','{noop}100000000050','ROLE_PATIENT',1),(51,'100000000051','Đỗ Thị Cẩm','1992-12-29','Nữ','Khánh Hòa','0901000051','do.thi.cam51@example.com','100000000051','{noop}100000000051','ROLE_PATIENT',1),(52,'100000000052','Hồ Văn Duy','1989-08-18','Nam','Quảng Ngãi','0901000052','ho.van.duy52@example.com','100000000052','{noop}100000000052','ROLE_PATIENT',1),(53,'100000000053','Dương Thị Giàu','1995-02-02','Nữ','Phú Yên','0901000053','duong.thi.giau53@example.com','100000000053','{noop}100000000053','ROLE_PATIENT',1),(54,'100000000054','Lý Văn Hùng','1970-03-15','Nam','Bình Thuận','0901000054','ly.van.hung54@example.com','100000000054','{noop}100000000054','ROLE_PATIENT',1),(55,'100000000055','Nguyễn Thị Hương','1984-09-19','Nữ','Hà Nội','0901000055','nguyen.thi.huong55@example.com','100000000055','{noop}100000000055','ROLE_PATIENT',1),(56,'100000000056','Trần Văn Kết','1997-01-25','Nam','Hồ Chí Minh','0901000056','tran.van.ket56@example.com','100000000056','{noop}100000000056','ROLE_PATIENT',1),(57,'100000000057','Phạm Thị Lệ','1990-11-06','Nữ','Gia Lai','0901000057','pham.thi.le57@example.com','100000000057','{noop}100000000057','ROLE_PATIENT',1),(58,'100000000058','Hoàng Văn Minh','1981-07-01','Nam','Bến Tre','0901000058','hoang.van.minh58@example.com','100000000058','{noop}100000000058','ROLE_PATIENT',1),(59,'100000000059','Phan Thị Ngân','1994-05-24','Nữ','Hải Dương','0901000059','phan.thi.ngan59@example.com','100000000059','{noop}100000000059','ROLE_PATIENT',1),(60,'100000000060','Võ Minh Nhật','1978-02-28','Nam','Kiên Giang','0901000060','vo.minh.nhat60@example.com','100000000060','{noop}100000000060','ROLE_PATIENT',1),(61,'100000000061','Đặng Thị Oanh','1986-10-20','Nữ','Hà Nội','0901000061','dang.thi.oanh61@example.com','100000000061','{noop}100000000061','ROLE_PATIENT',1),(62,'100000000062','Bùi Văn Phước','1993-03-02','Nam','Vĩnh Long','0901000062','bui.van.phuoc62@example.com','100000000062','{noop}100000000062','ROLE_PATIENT',1),(63,'100000000063','Đỗ Thị Quỳnh','1999-06-12','Nữ','Hồ Chí Minh','0901000063','do.thi.quynh63@example.com','100000000063','{noop}100000000063','ROLE_PATIENT',1),(64,'100000000064','Hồ Minh Sang','1985-04-14','Nam','Quảng Ninh','0901000064','ho.minh.sang64@example.com','100000000064','{noop}100000000064','ROLE_PATIENT',1),(65,'100000000065','Dương Thị Sen','1991-09-08','Nữ','Bà Rịa - Vũng Tàu','0901000065','duong.thi.sen65@example.com','100000000065','{noop}100000000065','ROLE_PATIENT',1),(66,'100000000066','Lý Minh Tâm','1976-12-31','Nam','Hà Nội','0901000066','ly.minh.tam66@example.com','100000000066','{noop}100000000066','ROLE_PATIENT',1),(67,'100000000067','Nguyễn Thị Thanh','1998-08-11','Nữ','Bắc Giang','0901000067','nguyen.thi.thanh67@example.com','100000000067','{noop}100000000067','ROLE_PATIENT',1),(68,'100000000068','Trần Văn Tú','1983-11-23','Nam','Vĩnh Phúc','0901000068','tran.van.tu68@example.com','100000000068','{noop}100000000068','ROLE_PATIENT',1),(69,'100000000069','Phạm Thị Uyên','1996-02-20','Nữ','Nam Định','0901000069','pham.thi.uyen69@example.com','100000000069','{noop}100000000069','ROLE_PATIENT',1),(70,'100000000070','Hoàng Văn Zê','1992-05-04','Nam','Hồ Chí Minh','0901000070','hoang.van.ze70@example.com','100000000070','{noop}100000000070','ROLE_PATIENT',1),(71,'034205007114','Hoàng Đình Duy','2005-06-01','Nam','Thái Bình','0904427440','duyhoangdinh17','034205007114','{noop}034205007114','ROLE_ADMIN',1),(73,'03420569901','Hoàng Đình Hiu','2000-01-04','Nam','Thanh Chương Phú Thọ','09876582631',NULL,'dinhhiu8907','{noop}324356475645342','ROLE_PATIENT',1),(74,'03420569906','Trần Văn Toàn','2007-10-16','Nam','Xóm 3 Nam Thịnh Thái Bình','09876582635','vantoanck08@gmail.com','vanToan09','{noop}12345678','ROLE_PATIENT',1);
/*!40000 ALTER TABLE `nguoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoigiamho`
--

DROP TABLE IF EXISTS `nguoigiamho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoigiamho` (
                               `MaGiamHo` int NOT NULL AUTO_INCREMENT,
                               `PersonId` int NOT NULL,
                               `NgheNghiep` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                               `MoiQuanHe` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                               `NgayGiamHo` date NOT NULL,
                               PRIMARY KEY (`MaGiamHo`),
                               KEY `PersonId` (`PersonId`),
                               CONSTRAINT `nguoigiamho_ibfk_1` FOREIGN KEY (`PersonId`) REFERENCES `nguoi` (`PersonId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoigiamho`
--

LOCK TABLES `nguoigiamho` WRITE;
/*!40000 ALTER TABLE `nguoigiamho` DISABLE KEYS */;
INSERT INTO `nguoigiamho` VALUES (1,31,'Giáo viên','Cha','2023-01-15'),(2,32,'Kỹ sư','Mẹ','2023-03-22'),(3,33,'Kinh doanh','Anh','2023-06-05'),(4,34,'Nhân viên văn phòng','Chị','2023-08-19'),(5,35,'Hưu trí','Ông','2023-10-01'),(6,36,'Hưu trí','Bà','2024-02-12'),(7,37,'Bác sĩ','Cha','2024-05-09'),(8,38,'Công nhân','Mẹ','2024-07-20'),(9,39,'Tài xế','Anh','2024-09-03'),(10,40,'Tự do','Chị','2024-11-14');
/*!40000 ALTER TABLE `nguoigiamho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieudichvu`
--

DROP TABLE IF EXISTS `phieudichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieudichvu` (
                               `MaSoPhieu` int NOT NULL AUTO_INCREMENT,
                               `MaDichVu` int NOT NULL,
                               `SoLuong` int NOT NULL,
                               PRIMARY KEY (`MaSoPhieu`),
                               KEY `MaDichVu` (`MaDichVu`),
                               CONSTRAINT `phieudichvu_ibfk_3` FOREIGN KEY (`MaDichVu`) REFERENCES `dichvuyte` (`MaDichVu`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieudichvu`
--

LOCK TABLES `phieudichvu` WRITE;
/*!40000 ALTER TABLE `phieudichvu` DISABLE KEYS */;
INSERT INTO `phieudichvu` VALUES (1,1,1),(2,2,2),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1),(11,11,2),(12,12,1),(13,13,1),(14,14,1),(15,15,2),(16,16,1),(17,17,1),(18,18,2),(19,19,1),(20,20,1),(21,2,1),(22,13,1),(23,15,1),(24,12,1),(25,8,1),(26,6,1),(27,11,1),(28,10,1),(29,4,1),(30,18,1),(31,18,1),(32,9,1),(33,7,1),(34,1,1),(35,1,1);
/*!40000 ALTER TABLE `phieudichvu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-25 21:39:55
