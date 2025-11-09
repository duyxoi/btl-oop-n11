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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datlichkham`
--

LOCK TABLES `datlichkham` WRITE;
/*!40000 ALTER TABLE `datlichkham` DISABLE KEYS */;
INSERT INTO `datlichkham` VALUES (6,12,21,'2025-11-01','2025-11-01 01:30:00','DA_XAC_NHAN',NULL),(7,1,21,'2025-11-01','2025-11-01 01:00:00','DA_XAC_NHAN',1),(16,1,22,'2025-11-03','2025-11-03 01:00:00','DA_XAC_NHAN',1),(17,1,21,'2025-11-03','2025-11-03 01:30:00','DA_XAC_NHAN',1),(18,6,21,'2025-11-03','2025-11-03 01:30:00','DA_XAC_NHAN',6),(19,1,21,'2025-11-05','2025-11-05 01:00:00','DA_XAC_NHAN',1);
/*!40000 ALTER TABLE `datlichkham` ENABLE KEYS */;
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
