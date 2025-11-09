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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaithuoc`
--

LOCK TABLES `loaithuoc` WRITE;
/*!40000 ALTER TABLE `loaithuoc` DISABLE KEYS */;
INSERT INTO `loaithuoc` VALUES (1,'Paracetamol 500mg',15000.00,'2026-01-01'),(2,'Amoxicillin 500mg',25000.00,'2026-02-15'),(3,'Vitamin C 500mg',12000.00,'2026-03-10'),(4,'Cephalexin 500mg',28000.00,'2026-04-05'),(5,'Lansoprazole 30mg',35000.00,'2026-05-01'),(6,'Omeprazole 20mg',32000.00,'2026-05-01'),(7,'Azithromycin 250mg',45000.00,'2026-06-01'),(8,'Metronidazole 250mg',22000.00,'2026-06-20'),(9,'Domperidone 10mg',18000.00,'2026-07-10'),(10,'Esomeprazole 40mg',30000.00,'2026-07-10'),(11,'Lorastad 10mg',27000.00,'2026-07-30'),(12,'Diclofenac 50mg',24000.00,'2026-08-10'),(13,'Ibuprofen 400mg',21000.00,'2026-08-10'),(14,'Panadol Extra',15000.00,'2026-09-01'),(15,'Cefuroxime 250mg',40000.00,'2026-09-01'),(16,'Captopril 25mg',20000.00,'2026-09-30'),(17,'Amlodipine 5mg',22000.00,'2026-09-30'),(18,'Cetirizine 10mg',15000.00,'2026-10-10'),(19,'Efferalgan 500mg',18000.00,'2026-10-20'),(20,'Clarithromycin 250mg',42000.00,'2026-10-20'),(21,'Prednisolone 5mg',12000.00,'2026-11-01'),(22,'Metformin 500mg',18000.00,'2026-11-15'),(23,'Gliclazide 80mg',25000.00,'2026-11-15'),(24,'Alprazolam 0.5mg',35000.00,'2026-12-01'),(25,'Simvastatin 20mg',28000.00,'2026-12-01'),(26,'Ciprofloxacin 500mg',26000.00,'2026-12-15'),(27,'Diclofenac Sodium 75mg',27000.00,'2026-12-15'),(28,'Montelukast 10mg',30000.00,'2027-01-01'),(29,'Amoxicillin + Clavulanic 1g',42000.00,'2027-01-20'),(30,'Vitamin B Complex',15000.00,'2027-02-01'),(31,'Calcium D3 500mg',18000.00,'2027-02-01'),(32,'Enalapril 10mg',23000.00,'2027-02-10'),(33,'Atenolol 50mg',25000.00,'2027-02-10'),(34,'Loratadine 10mg',15000.00,'2027-03-01');
/*!40000 ALTER TABLE `loaithuoc` ENABLE KEYS */;
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
