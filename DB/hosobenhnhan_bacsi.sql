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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 10:41:15
