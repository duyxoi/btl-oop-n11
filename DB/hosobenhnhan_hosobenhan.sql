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
-- Table structure for table `hosobenhan`
--

DROP TABLE IF EXISTS `hosobenhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hosobenhan` (
  `MaHoSo` int NOT NULL AUTO_INCREMENT,
  `MaBenhNhan` int NOT NULL,
  `NgayNhapVien` date NOT NULL,
  `NgayXuatVien` date DEFAULT NULL,
  `ChanDoan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `PhuongAnDieuTri` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `KetQua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`MaHoSo`),
  KEY `MaBenhNhan` (`MaBenhNhan`),
  CONSTRAINT `hosobenhan_ibfk_1` FOREIGN KEY (`MaBenhNhan`) REFERENCES `benhnhan` (`MaBenhNhan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hosobenhan`
--

LOCK TABLES `hosobenhan` WRITE;
/*!40000 ALTER TABLE `hosobenhan` DISABLE KEYS */;
INSERT INTO `hosobenhan` VALUES (1,17,'2024-02-10','2024-02-14','Viêm phổi cộng đồng','Dùng kháng sinh, hạ sốt, hỗ trợ hô hấp','Ổn định'),(2,4,'2024-03-15','2024-03-18','Thiếu máu nhẹ','Truyền sắt và bổ sung vitamin','Khỏi'),(3,13,'2024-04-20','2024-04-24','Viêm phổi nhẹ cần chẩn đoán hình ảnh','Chụp X-quang phổi, điều trị kháng sinh','Ổn định'),(4,25,'2024-05-25','2024-05-29','Sỏi mật','Siêu âm và hội chẩn ngoại khoa','Ổn định'),(5,29,'2024-06-12','2024-06-16','Tăng huyết áp độ 2','Điều chỉnh thuốc và theo dõi tim mạch','Đỡ'),(6,11,'2024-06-30','2024-07-04','Viêm dạ dày HP (+)','Phác đồ diệt HP, ức chế bơm proton','Khỏi'),(7,20,'2024-07-10','2024-07-15','Polyp đại tràng','Nội soi cắt polyp','Khỏi'),(8,2,'2024-07-28','2024-07-31','Chấn thương ngực kín','Chụp CT lồng ngực, điều trị giảm đau','Ổn định'),(9,27,'2024-08-03','2024-08-07','Đau đầu kéo dài chưa rõ nguyên nhân','Chụp MRI não và theo dõi thần kinh','Đỡ'),(10,8,'2024-08-20','2024-08-23','Cơn đau thắt ngực ổn định','Điều trị nội khoa tim mạch','Ổn định'),(11,18,'2024-09-05','2024-09-12','Rối loạn tiền đình','Dùng thuốc và tập phục hồi chức năng','Đỡ'),(12,30,'2024-09-22','2024-09-25','Viêm da dị ứng','Dùng thuốc kháng histamin và bôi corticoid','Khỏi'),(13,1,'2024-10-03','2024-10-06','Viêm amidan cấp','Kháng sinh và hạ sốt','Khỏi'),(14,14,'2024-10-20','2024-10-22','Viêm kết mạc','Nhỏ kháng sinh, nghỉ ngơi','Khỏi'),(15,23,'2024-11-02','2024-11-07','Sâu răng, viêm tủy','Lấy tủy, trám răng','Khỏi'),(16,6,'2024-11-18','2024-11-24','U nang thượng bì nhỏ','Tiểu phẫu lấy u','Khỏi'),(17,26,'2024-12-03','2024-12-10','Thoát vị bẹn','Phẫu thuật ngoại khoa','Khỏi'),(18,9,'2024-12-19','2024-12-24','Hội chứng cổ vai gáy','Điều trị vật lý trị liệu','Đỡ'),(19,22,'2025-01-04','2025-01-08','Cúm A','Dùng thuốc kháng virus và hạ sốt','Khỏi'),(20,10,'2025-01-20','2025-01-23','Suy dinh dưỡng mức độ nhẹ','Tư vấn chế độ ăn, bổ sung vi chất','Đỡ'),(21,24,'2025-02-01','2025-02-05','Tăng men gan nhẹ','Theo dõi và điều chỉnh thuốc','Ổn định'),(22,5,'2025-02-18','2025-02-21','Viêm họng cấp','Súc họng, uống kháng sinh','Khỏi'),(23,19,'2025-03-03','2025-03-09','Áp xe răng','Rạch dẫn lưu và kháng sinh','Khỏi'),(24,21,'2025-03-15',NULL,'Chàm thể tạng bùng phát','Dùng thuốc duy trì, tái khám định kỳ','Đang điều trị'),(25,28,'2025-03-30','2025-04-03','Chấn thương phần mềm chi dưới','Chụp X-quang, cố định tạm thời','Ổn định'),(26,3,'2025-04-10','2025-04-14','Xuất huyết dạ dày nhẹ','Nội soi cầm máu, dùng PPI liều cao','Ổn định'),(27,15,'2025-04-25',NULL,'Đau đầu mạn tính','Thuốc dự phòng và theo dõi','Đang điều trị'),(28,16,'2025-05-06','2025-05-11','Hở van hai lá nhẹ','Điều trị nội khoa tim mạch','Ổn định'),(29,12,'2025-05-20',NULL,'Đau bụng chưa rõ nguyên nhân','Siêu âm, theo dõi thêm','Đang điều trị'),(30,7,'2025-06-02',NULL,'Đau thắt lưng do thoái hóa','Vật lý trị liệu, thuốc giảm đau','Đang điều trị');
/*!40000 ALTER TABLE `hosobenhan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 10:41:15
