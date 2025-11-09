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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'Khoa Nội Tổng Hợp','Tầng 2 - Tòa A'),(2,'Khoa Ngoại Tổng Hợp','Tầng 3 - Tòa A'),(3,'Khoa Nhi','Tầng 4 - Tòa A'),(4,'Khoa Sản','Tầng 5 - Tòa A'),(5,'Khoa Tai Mũi Họng','Tầng 2 - Tòa B'),(6,'Khoa Mắt','Tầng 3 - Tòa B'),(7,'Khoa Răng Hàm Mặt','Tầng 4 - Tòa B'),(8,'Khoa Tim Mạch','Tầng 5 - Tòa B'),(9,'Khoa Thần Kinh','Tầng 6 - Tòa A'),(10,'Khoa Da Liễu','Tầng 2 - Tòa C'),(11,'Khoa Hô Hấp','Tầng 3 - Tòa C'),(12,'Khoa Tiêu Hóa','Tầng 4 - Tòa C'),(13,'Khoa Thận - Tiết Niệu','Tầng 5 - Tòa C'),(14,'Khoa Cơ Xương Khớp','Tầng 6 - Tòa C'),(15,'Khoa Huyết Học','Tầng 7 - Tòa A'),(16,'Khoa Truyền Nhiễm','Tầng 8 - Tòa A'),(17,'Khoa Ung Bướu','Tầng 9 - Tòa A'),(18,'Khoa Phục Hồi Chức Năng','Tầng 2 - Tòa D'),(19,'Khoa Dinh Dưỡng','Tầng 3 - Tòa D'),(20,'Khoa Cấp Cứu','Tầng 1 - Tòa A'),(21,'Khoa Xét Nghiệm','Tầng 1 - Tòa B'),(22,'Khoa Chẩn Đoán Hình Ảnh','Tầng 1 - Tòa C'),(23,'Khoa Phẫu Thuật Gây Mê Hồi Sức','Tầng 2 - Tòa E'),(24,'Khoa Tâm Thần','Tầng 3 - Tòa E'),(25,'Khoa Y Học Cổ Truyền','Tầng 4 - Tòa E'),(26,'Khoa Da Liễu - Thẩm Mỹ','Tầng 5 - Tòa E'),(27,'Khoa Kiểm Soát Nhiễm Khuẩn','Tầng 6 - Tòa E'),(28,'Khoa Sơ Sinh','Tầng 7 - Tòa B'),(29,'Khoa Hồi Sức Tích Cực','Tầng 8 - Tòa B'),(30,'Khoa Y Học Hạt Nhân','Tầng 9 - Tòa B');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 10:41:14
