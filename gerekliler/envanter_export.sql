-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: envanter
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `alis_bilgi`
--

DROP TABLE IF EXISTS `alis_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alis_bilgi` (
  `alis_id` int NOT NULL AUTO_INCREMENT,
  `satici_id` int NOT NULL,
  `urun_id` int NOT NULL,
  `urun_adet` int NOT NULL,
  PRIMARY KEY (`alis_id`),
  KEY `fk_urun_id1` (`urun_id`),
  KEY `fk_satici_id1` (`satici_id`),
  CONSTRAINT `fk_satici_id1` FOREIGN KEY (`satici_id`) REFERENCES `satici` (`satici_id`),
  CONSTRAINT `fk_urun_id1` FOREIGN KEY (`urun_id`) REFERENCES `urun_bilgi` (`urun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alis_bilgi`
--

LOCK TABLES `alis_bilgi` WRITE;
/*!40000 ALTER TABLE `alis_bilgi` DISABLE KEYS */;
/*!40000 ALTER TABLE `alis_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depo_bilgi`
--

DROP TABLE IF EXISTS `depo_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `depo_bilgi` (
  `depo_id` varchar(45) NOT NULL,
  `isim` varchar(45) NOT NULL,
  `sehir_id` varchar(45) NOT NULL,
  PRIMARY KEY (`depo_id`),
  KEY `idx_sehir_id` (`sehir_id`),
  CONSTRAINT `fk_sehir_id` FOREIGN KEY (`sehir_id`) REFERENCES `sehir_bilgi` (`sehir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depo_bilgi`
--

LOCK TABLES `depo_bilgi` WRITE;
/*!40000 ALTER TABLE `depo_bilgi` DISABLE KEYS */;
/*!40000 ALTER TABLE `depo_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `depo_urunleri`
--

DROP TABLE IF EXISTS `depo_urunleri`;
/*!50001 DROP VIEW IF EXISTS `depo_urunleri`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `depo_urunleri` AS SELECT 
 1 AS `depo_id`,
 1 AS `urun_id`,
 1 AS `urun_isim`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `musteri_bilgi`
--

DROP TABLE IF EXISTS `musteri_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musteri_bilgi` (
  `musteri_id` int NOT NULL AUTO_INCREMENT,
  `musteri_ad` varchar(45) NOT NULL,
  `telefon_no` varchar(45) NOT NULL,
  `e_posta` varchar(45) NOT NULL,
  `adres` varchar(45) NOT NULL,
  `sehir_id` varchar(45) NOT NULL,
  PRIMARY KEY (`musteri_id`),
  KEY `fk_sehir_id1` (`sehir_id`),
  CONSTRAINT `fk_sehir_id1` FOREIGN KEY (`sehir_id`) REFERENCES `sehir_bilgi` (`sehir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri_bilgi`
--

LOCK TABLES `musteri_bilgi` WRITE;
/*!40000 ALTER TABLE `musteri_bilgi` DISABLE KEYS */;
/*!40000 ALTER TABLE `musteri_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `musteri_sayisi`
--

DROP TABLE IF EXISTS `musteri_sayisi`;
/*!50001 DROP VIEW IF EXISTS `musteri_sayisi`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `musteri_sayisi` AS SELECT 
 1 AS `sehir_id`,
 1 AS `musteri_sayisi`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `satici`
--

DROP TABLE IF EXISTS `satici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `satici` (
  `satici_id` int NOT NULL AUTO_INCREMENT,
  `satici_ad` varchar(45) NOT NULL,
  `telefon_no` varchar(45) NOT NULL,
  `e_posta` varchar(45) NOT NULL,
  `adres` varchar(45) NOT NULL,
  `sehir_id` varchar(45) NOT NULL,
  PRIMARY KEY (`satici_id`),
  KEY `fk_sehir_id2` (`sehir_id`),
  CONSTRAINT `fk_sehir_id2` FOREIGN KEY (`sehir_id`) REFERENCES `sehir_bilgi` (`sehir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `satici`
--

LOCK TABLES `satici` WRITE;
/*!40000 ALTER TABLE `satici` DISABLE KEYS */;
/*!40000 ALTER TABLE `satici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `satis_bilgi`
--

DROP TABLE IF EXISTS `satis_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `satis_bilgi` (
  `satis_id` int NOT NULL AUTO_INCREMENT,
  `musteri_id` int NOT NULL,
  `urun_id` int NOT NULL,
  `alis_sekli` varchar(45) NOT NULL,
  `urun_adet` int NOT NULL,
  PRIMARY KEY (`satis_id`),
  KEY `fk_musteri_id` (`musteri_id`),
  KEY `idx_urun_id` (`urun_id`),
  CONSTRAINT `fk_musteri_id` FOREIGN KEY (`musteri_id`) REFERENCES `musteri_bilgi` (`musteri_id`),
  CONSTRAINT `fk_urun_id` FOREIGN KEY (`urun_id`) REFERENCES `urun_bilgi` (`urun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `satis_bilgi`
--

LOCK TABLES `satis_bilgi` WRITE;
/*!40000 ALTER TABLE `satis_bilgi` DISABLE KEYS */;
/*!40000 ALTER TABLE `satis_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sehir_bilgi`
--

DROP TABLE IF EXISTS `sehir_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sehir_bilgi` (
  `sehir_id` varchar(45) NOT NULL,
  `sehir_isim` varchar(45) NOT NULL,
  PRIMARY KEY (`sehir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sehir_bilgi`
--

LOCK TABLES `sehir_bilgi` WRITE;
/*!40000 ALTER TABLE `sehir_bilgi` DISABLE KEYS */;
INSERT INTO `sehir_bilgi` VALUES ('1','Adana'),('10','Balıkesir'),('11','Bilecik'),('12','Bingöl'),('13','Bitlis'),('14','Bolu'),('15','Burdur'),('16','Bursa'),('17','Çanakkale'),('18','Çankırı'),('19','Çorum'),('2','Adıyaman'),('20','Denizli'),('21','Diyarbakır'),('22','Edirne'),('23','Elazığ'),('24','Erzincan'),('25','Erzurum'),('26','Eskişehir'),('27','Gaziantep'),('28','Giresun'),('29','Gümüşhane'),('3','Afyon'),('30','Hakkari'),('31','Hatay'),('32','Isparta'),('33','Mersin'),('34','İstanbul'),('35','İzmir'),('36','Kars'),('37','Kastamonu'),('38','Kayseri'),('39','Kırklareli'),('4','Ağrı'),('40','Kırşehir'),('41','Kocaeli'),('42','Konya'),('43','Kütahya'),('44','Malatya'),('45','Manisa'),('46','Kahramanmaraş'),('47','Mardin'),('48','Muğla'),('49','Muş'),('5','Amasya'),('50','Nevşehir'),('51','Niğde'),('52','Ordu'),('53','Rize'),('54','Sakarya'),('55','Samsun'),('56','Siirt'),('57','Sinop'),('58','Sivas'),('59','Tekirdağ'),('6','Ankara'),('60','Tokat'),('61','Trabzon'),('62','Tunceli'),('63','Şanlıurfa'),('64','Uşak'),('65','Van'),('66','Yozgat'),('67','Zonguldak'),('68','Aksaray'),('69','Bayburt'),('7','Antalya'),('70','Karaman'),('71','Kırıkkale'),('72','Batman'),('73','Şırnak'),('74','Bartın'),('75','Ardahan'),('76','Iğdır'),('77','Yalova'),('78','Karabük'),('79','Kilis'),('8','Artvin'),('80','Osmaniye'),('81','Düzce'),('9','Aydın');
/*!40000 ALTER TABLE `sehir_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `tedarikcilerin_urunleri`
--

DROP TABLE IF EXISTS `tedarikcilerin_urunleri`;
/*!50001 DROP VIEW IF EXISTS `tedarikcilerin_urunleri`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `tedarikcilerin_urunleri` AS SELECT 
 1 AS `satici_ad`,
 1 AS `urun_ismi`,
 1 AS `fiyat`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `urun_bilgi`
--

DROP TABLE IF EXISTS `urun_bilgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urun_bilgi` (
  `urun_id` int NOT NULL,
  `isim` varchar(45) NOT NULL,
  `fiyat` int NOT NULL,
  `stok_bilgi` int NOT NULL,
  `depo_id` varchar(45) NOT NULL,
  PRIMARY KEY (`urun_id`),
  KEY `idx_depo_id` (`depo_id`),
  CONSTRAINT `fk_depo_id` FOREIGN KEY (`depo_id`) REFERENCES `depo_bilgi` (`depo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urun_bilgi`
--

LOCK TABLES `urun_bilgi` WRITE;
/*!40000 ALTER TABLE `urun_bilgi` DISABLE KEYS */;
/*!40000 ALTER TABLE `urun_bilgi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `depo_urunleri`
--

/*!50001 DROP VIEW IF EXISTS `depo_urunleri`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `depo_urunleri` AS select `d`.`depo_id` AS `depo_id`,`u`.`urun_id` AS `urun_id`,`u`.`isim` AS `urun_isim` from (`depo_bilgi` `d` join `urun_bilgi` `u` on((`d`.`depo_id` = `u`.`depo_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `musteri_sayisi`
--

/*!50001 DROP VIEW IF EXISTS `musteri_sayisi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `musteri_sayisi` AS select `m`.`sehir_id` AS `sehir_id`,count(0) AS `musteri_sayisi` from `musteri_bilgi` `m` group by `m`.`sehir_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `tedarikcilerin_urunleri`
--

/*!50001 DROP VIEW IF EXISTS `tedarikcilerin_urunleri`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tedarikcilerin_urunleri` AS select (select `satici`.`satici_ad` from `satici` where (`satici`.`satici_id` = `alis_bilgi`.`satici_id`)) AS `satici_ad`,`urun_bilgi`.`isim` AS `urun_ismi`,`urun_bilgi`.`fiyat` AS `fiyat` from (`alis_bilgi` join `urun_bilgi` on((`alis_bilgi`.`urun_id` = `urun_bilgi`.`urun_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-12 22:46:16
