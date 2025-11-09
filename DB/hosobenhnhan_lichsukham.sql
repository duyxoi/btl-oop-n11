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
  PRIMARY KEY (`MaLichSuKham`),
  KEY `MaBacSi` (`MaBacSi`),
  KEY `MaDonThuoc` (`MaDonThuoc`),
  KEY `MaHoSo` (`MaHoSo`),
  KEY `fk_lichsukham_phieudichvu` (`MaSoPhieu`),
  CONSTRAINT `fk_lichsukham_phieudichvu` FOREIGN KEY (`MaSoPhieu`) REFERENCES `phieudichvu` (`MaSoPhieu`),
  CONSTRAINT `lichsukham_ibfk_2` FOREIGN KEY (`MaBacSi`) REFERENCES `bacsi` (`MaBacSi`),
  CONSTRAINT `lichsukham_ibfk_3` FOREIGN KEY (`MaDonThuoc`) REFERENCES `donthuoc` (`MaDonThuoc`),
  CONSTRAINT `lichsukham_ibfk_4` FOREIGN KEY (`MaHoSo`) REFERENCES `hosobenhan` (`MaHoSo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichsukham`
--

LOCK TABLES `lichsukham` WRITE;
/*!40000 ALTER TABLE `lichsukham` DISABLE KEYS */;
INSERT INTO `lichsukham` VALUES (1,1,1,1,'2024-02-10','Khoa Nội Tổng Hợp - Tầng 2 - Tòa A',1,NULL),(2,21,2,2,'2024-03-15','Khoa Xét Nghiệm - Tầng 1 - Tòa B',2,NULL),(3,22,3,3,'2024-04-20','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',3,NULL),(4,22,4,4,'2024-05-25','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',4,NULL),(5,8,5,5,'2024-06-12','Khoa Tim Mạch - Tầng 5 - Tòa B',5,NULL),(6,12,6,6,'2024-06-30','Khoa Tiêu Hóa - Tầng 4 - Tòa C',6,NULL),(7,12,7,7,'2024-07-10','Khoa Tiêu Hóa - Tầng 4 - Tòa C',7,NULL),(8,22,8,8,'2024-07-28','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',8,NULL),(9,22,9,9,'2024-08-03','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',9,NULL),(10,8,10,10,'2024-08-20','Khoa Tim Mạch - Tầng 5 - Tòa B',10,NULL),(11,9,11,11,'2024-09-05','Khoa Thần Kinh - Tầng 6 - Tòa A',11,NULL),(12,10,12,12,'2024-09-22','Khoa Da Liễu - Tầng 2 - Tòa C',12,NULL),(13,5,13,13,'2024-10-03','Khoa Tai Mũi Họng - Tầng 2 - Tòa B',13,NULL),(14,6,14,14,'2024-10-20','Khoa Mắt - Tầng 3 - Tòa B',14,NULL),(15,7,15,15,'2024-11-02','Khoa Răng Hàm Mặt - Tầng 4 - Tòa B',15,NULL),(16,2,16,16,'2024-11-18','Khoa Ngoại Tổng Hợp - Tầng 3 - Tòa A',16,NULL),(17,2,17,17,'2024-12-03','Khoa Ngoại Tổng Hợp - Tầng 3 - Tòa A',17,NULL),(18,18,18,18,'2024-12-19','Khoa Phục Hồi Chức Năng - Tầng 2 - Tòa D',18,NULL),(19,16,19,19,'2025-01-04','Khoa Truyền Nhiễm - Tầng 8 - Tòa A',19,NULL),(20,19,20,20,'2025-01-20','Khoa Dinh Dưỡng - Tầng 3 - Tòa D',20,NULL),(21,21,21,21,'2025-02-01','Khoa Xét Nghiệm - Tầng 1 - Tòa B',21,NULL),(22,5,22,22,'2025-02-18','Khoa Tai Mũi Họng - Tầng 2 - Tòa B',22,NULL),(23,7,23,23,'2025-03-03','Khoa Răng Hàm Mặt - Tầng 4 - Tòa B',23,NULL),(24,10,24,24,'2025-03-15','Khoa Da Liễu - Tầng 2 - Tòa C',24,NULL),(25,22,25,25,'2025-03-30','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',25,NULL),(26,12,26,26,'2025-04-10','Khoa Tiêu Hóa - Tầng 4 - Tòa C',26,NULL),(27,9,27,27,'2025-04-25','Khoa Thần Kinh - Tầng 6 - Tòa A',27,NULL),(28,8,28,28,'2025-05-06','Khoa Tim Mạch - Tầng 5 - Tòa B',28,NULL),(29,22,29,29,'2025-05-20','Khoa Chẩn Đoán Hình Ảnh - Tầng 1 - Tòa C',29,NULL),(30,18,30,30,'2025-06-02','Khoa Phục Hồi Chức Năng - Tầng 2 - Tòa D',30,NULL);
/*!40000 ALTER TABLE `lichsukham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 10:41:13
