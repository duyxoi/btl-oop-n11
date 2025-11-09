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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benhnhan`
--

LOCK TABLES `benhnhan` WRITE;
/*!40000 ALTER TABLE `benhnhan` DISABLE KEYS */;
INSERT INTO `benhnhan` VALUES (1,41,8,'O','Viêm mũi dị ứng','3094827156'),(2,42,NULL,'A','Tăng huyết áp','4102938576'),(3,43,6,'B','Không rõ','5810627349'),(4,44,NULL,'AB','Đái tháo đường','6739041258'),(5,45,4,'O','Rối loạn mỡ máu','7820453916'),(6,46,NULL,'A','Không','8941203765'),(7,47,NULL,'B','Viêm dạ dày','9056724183'),(8,48,NULL,'AB','Gout','1029384756'),(9,49,7,'O','Không','2143658709'),(10,50,NULL,'A','Không','3254781906'),(11,51,NULL,'B','Viêm xoang','4365972810'),(12,52,NULL,'AB','Không','5476813920'),(13,53,5,'O','Không','6587093142'),(14,54,NULL,'A','Viêm khớp','7698204351'),(15,55,NULL,'B','Không','8709136245'),(16,56,9,'AB','Không','9810247356'),(17,57,NULL,'O','Không','1928374650'),(18,58,NULL,'A','Không','2039485761'),(19,59,10,'B','Không','3140596872'),(20,60,NULL,'AB','Không','4251607983'),(21,61,NULL,'O','Không','5362718094'),(22,62,NULL,'A','Không','6473829015'),(23,63,2,'B','Không','7584930126'),(24,64,NULL,'AB','Không','8695041237'),(25,65,NULL,'O','Không','9706152348'),(26,66,NULL,'A','Không','0817263459'),(27,67,3,'B','Không','1928374651'),(28,68,NULL,'AB','Không','2938475610'),(29,69,1,'O','Không','3948576120'),(30,70,NULL,'A','Không','4959687231');
/*!40000 ALTER TABLE `benhnhan` ENABLE KEYS */;
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
