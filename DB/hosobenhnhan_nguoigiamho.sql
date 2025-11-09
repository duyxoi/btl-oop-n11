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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 10:41:14
