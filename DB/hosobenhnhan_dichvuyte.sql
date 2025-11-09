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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvuyte`
--

LOCK TABLES `dichvuyte` WRITE;
/*!40000 ALTER TABLE `dichvuyte` DISABLE KEYS */;
INSERT INTO `dichvuyte` VALUES (1,'Khám tổng quát',300000.00),(2,'Xét nghiệm máu tổng quát',250000.00),(3,'Chụp X-quang phổi',350000.00),(4,'Siêu âm bụng tổng quát',400000.00),(5,'Điện tâm đồ (ECG)',200000.00),(6,'Nội soi dạ dày',850000.00),(7,'Nội soi đại tràng',950000.00),(8,'Chụp CT Scanner',1500000.00),(9,'Cộng hưởng từ (MRI)',2200000.00),(10,'Khám chuyên khoa tim mạch',500000.00),(11,'Khám chuyên khoa thần kinh',550000.00),(12,'Khám chuyên khoa da liễu',400000.00),(13,'Khám tai mũi họng',350000.00),(14,'Khám mắt',300000.00),(15,'Khám răng hàm mặt',450000.00),(16,'Phẫu thuật tiểu phẫu',1200000.00),(17,'Phẫu thuật ngoại khoa',3500000.00),(18,'Điều trị vật lý trị liệu',600000.00),(19,'Tiêm chủng vắc-xin',250000.00),(20,'Tư vấn dinh dưỡng',200000.00);
/*!40000 ALTER TABLE `dichvuyte` ENABLE KEYS */;
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
