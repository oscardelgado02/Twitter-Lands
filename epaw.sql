-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: epaw
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `country`
--

CREATE DATABASE epaw;
USE epaw;

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `ID` int NOT NULL,
  `_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'United States'),(2,'United States Minor Outlying Islands'),(3,'Canada'),(4,'Mexico'),(5,'Anguilla'),(6,'Antigua and Barbuda'),(7,'Aruba'),(8,'Bahamas'),(9,'Barbados'),(10,'Belize'),(11,'Bermuda'),(12,'British Virgin Islands'),(13,'Cayman Islands'),(14,'Costa Rica'),(15,'Cuba'),(16,'Dominica'),(17,'Dominican Republic'),(18,'El Salvador'),(19,'Grenada'),(20,'Guadeloupe'),(21,'Guatemala'),(22,'Haiti'),(23,'Honduras'),(24,'Jamaica'),(25,'Martinique'),(26,'Montserrat'),(27,'Netherlands Antilles'),(28,'Nicaragua'),(29,'Panama'),(30,'Puerto Rico'),(31,'Saint Kitts and Nevis'),(32,'Saint Lucia'),(33,'Saint Vincent and the Grenadines'),(34,'Trinidad and Tobago'),(35,'Turks and Caicos Islands'),(36,'US Virgin Islands'),(37,'Argentina'),(38,'Bolivia'),(39,'Brazil'),(40,'Chile'),(41,'Colombia'),(42,'Ecuador'),(43,'Falkland Islands (Malvinas)'),(44,'French Guiana'),(45,'Guyana'),(46,'Paraguay'),(47,'Peru'),(48,'Suriname'),(49,'Uruguay'),(50,'Venezuela'),(51,'United Kingdom'),(52,'Albania'),(53,'Andorra'),(54,'Austria'),(55,'Belarus'),(56,'Belgium'),(57,'Bosnia and Herzegovina'),(58,'Bulgaria'),(59,'Croatia (Hrvatska)'),(60,'Cyprus'),(61,'Czech Republic'),(62,'France'),(63,'Gibraltar'),(64,'Germany'),(65,'Greece'),(66,'Holy See (Vatican City State)'),(67,'Hungary'),(68,'Italy'),(69,'Spain'),(70,'Liechtenstein'),(71,'Luxembourg'),(72,'Macedonia'),(73,'Malta'),(74,'Moldova'),(75,'Monaco'),(76,'Montenegro'),(77,'Netherlands'),(78,'Poland'),(79,'Portugal'),(80,'Romania'),(81,'San Marino'),(82,'Serbia'),(83,'Slovakia'),(84,'Slovenia'),(85,'Ukraine'),(86,'Denmark'),(87,'Estonia'),(88,'Faroe Islands'),(89,'Finland'),(90,'Greenland'),(91,'Iceland'),(92,'Ireland'),(93,'Latvia'),(94,'Lithuania'),(95,'Norway'),(96,'Svalbard and Jan Mayen Islands'),(97,'Sweden'),(98,'Switzerland'),(99,'Turkey'),(100,'Afghanistan'),(101,'Armenia'),(102,'Azerbaijan'),(103,'Bahrain'),(104,'Bangladesh'),(105,'Bhutan'),(106,'British Indian Ocean Territory'),(107,'Brunei Darussalam'),(108,'Cambodia'),(109,'China'),(110,'Christmas Island'),(111,'Cocos (Keeling) Islands'),(112,'Georgia'),(113,'Hong Kong'),(114,'India'),(115,'Indonesia'),(116,'Iran'),(117,'Iraq'),(118,'Israel'),(119,'Japan'),(120,'Jordan'),(121,'Kazakhstan'),(122,'Korea, Democratic Peoples Republic of'),(123,'Korea, Republic of'),(124,'Kuwait'),(125,'Kyrgyzstan'),(126,'Lao'),(127,'Lebanon'),(128,'Malaysia'),(129,'Maldives'),(130,'Mongolia'),(131,'Myanmar (Burma)'),(132,'Nepal'),(133,'Oman'),(134,'Pakistan'),(135,'Philippines'),(136,'Qatar'),(137,'Russian Federation'),(138,'Saudi Arabia'),(139,'Singapore'),(140,'Sri Lanka'),(141,'Syria'),(142,'Taiwan'),(143,'Tajikistan'),(144,'Thailand'),(145,'East Timor'),(146,'Turkmenistan'),(147,'United Arab Emirates'),(148,'Uzbekistan'),(149,'Vietnam'),(150,'Yemen'),(151,'American Samoa'),(152,'Australia'),(153,'Cook Islands'),(154,'Fiji'),(155,'French Polynesia (Tahiti)'),(156,'Guam'),(157,'Kiribati'),(158,'Marshall Islands'),(159,'Micronesia, Federated States of'),(160,'Nauru'),(161,'New Caledonia'),(162,'New Zealand'),(163,'Niue'),(164,'Northern Mariana Islands'),(165,'Palau'),(166,'Papua New Guinea'),(167,'Pitcairn'),(168,'Samoa'),(169,'Solomon Islands'),(170,'Tokelau'),(171,'Tonga'),(172,'Tuvalu'),(173,'Vanuatu'),(174,'Wallis and Futuna Islands'),(175,'Algeria'),(176,'Angola'),(177,'Benin'),(178,'Botswana'),(179,'Burkina Faso'),(180,'Burundi'),(181,'Cameroon'),(182,'Cape Verde'),(183,'Central African Republic'),(184,'Chad'),(185,'Comoros'),(186,'Congo'),(187,'Congo, the Democratic Republic of the'),(188,'Dijibouti'),(189,'Egypt'),(190,'Equatorial Guinea'),(191,'Eritrea'),(192,'Ethiopia'),(193,'Gabon'),(194,'Gambia'),(195,'Ghana'),(196,'Guinea'),(197,'Guinea-Bissau'),(198,'Cote dIvoire (Ivory Coast)'),(199,'Kenya'),(200,'Lesotho'),(201,'Liberia'),(202,'Libya'),(203,'Madagascar'),(204,'Malawi'),(205,'Mali'),(206,'Mauritania'),(207,'Mauritius'),(208,'Mayotte'),(209,'Morocco'),(210,'Mozambique'),(211,'Namibia'),(212,'Niger'),(213,'Nigeria'),(214,'Reunion'),(215,'Rwanda'),(216,'Sao Tome and Principe'),(217,'Saint Helena'),(218,'Senegal'),(219,'Seychelles'),(220,'Sierra Leone'),(221,'Somalia'),(222,'South Africa'),(223,'South Sudan'),(224,'Sudan'),(225,'Swaziland'),(226,'Tanzania'),(227,'Togo'),(228,'Tunisia'),(229,'Uganda'),(230,'Western Sahara'),(231,'Zambia'),(232,'Zimbabwe'),(233,'Antarctica');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_user`
--

DROP TABLE IF EXISTS `country_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_user` (
  `username_user` varchar(200) NOT NULL,
  `ID_country` int NOT NULL,
  PRIMARY KEY (`username_user`,`ID_country`),
  KEY `ID_country` (`ID_country`),
  CONSTRAINT `country_user_ibfk_1` FOREIGN KEY (`username_user`) REFERENCES `user` (`username`),
  CONSTRAINT `country_user_ibfk_2` FOREIGN KEY (`ID_country`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_user`
--

LOCK TABLES `country_user` WRITE;
/*!40000 ALTER TABLE `country_user` DISABLE KEYS */;
INSERT INTO `country_user` VALUES ('arnausito70',1),('javierelmelenas',1),('oskins',68),('arnausito70',69),('edu',69),('javierelmelenas',69),('edu',119);
/*!40000 ALTER TABLE `country_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `_name` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `countryID` int DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `countryID` (`countryID`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`countryID`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (2,'BBF','Playa Barcelona','Barcelona Beach Festival',69,'02/07/2022'),(4,'Mobile World Congress','Barcelona','La mayor convención del mundo de la tecnología',69,'27/02/2023');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `username_follower` varchar(200) NOT NULL,
  `username_followed` varchar(200) NOT NULL,
  PRIMARY KEY (`username_follower`,`username_followed`),
  KEY `username_followed` (`username_followed`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`username_follower`) REFERENCES `user` (`username`),
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`username_followed`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES ('javierelmelenas','arnausito70'),('oskins','arnausito70'),('edu','javierelmelenas'),('oskins','javierelmelenas'),('javierelmelenas','oskins');
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_tweet`
--

DROP TABLE IF EXISTS `like_tweet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_tweet` (
  `tweet_ID` int NOT NULL,
  `uname` varchar(200) NOT NULL,
  PRIMARY KEY (`tweet_ID`,`uname`),
  KEY `uname` (`uname`),
  CONSTRAINT `like_tweet_ibfk_1` FOREIGN KEY (`tweet_ID`) REFERENCES `tweet` (`tweetID`),
  CONSTRAINT `like_tweet_ibfk_2` FOREIGN KEY (`uname`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_tweet`
--

LOCK TABLES `like_tweet` WRITE;
/*!40000 ALTER TABLE `like_tweet` DISABLE KEYS */;
INSERT INTO `like_tweet` VALUES (4,'arnausito70'),(9,'edu'),(4,'javierelmelenas'),(6,'javierelmelenas');
/*!40000 ALTER TABLE `like_tweet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendation`
--

DROP TABLE IF EXISTS `recommendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendation` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `_name` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `total_rate` float DEFAULT NULL,
  `countryID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `countryID` (`countryID`),
  CONSTRAINT `recommendation_ibfk_1` FOREIGN KEY (`countryID`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation`
--

LOCK TABLES `recommendation` WRITE;
/*!40000 ALTER TABLE `recommendation` DISABLE KEYS */;
INSERT INTO `recommendation` VALUES (2,'Bar El Manolo','Rbla. Guipúscoa, 29-33',9,69);
/*!40000 ALTER TABLE `recommendation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tweet`
--

DROP TABLE IF EXISTS `tweet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tweet` (
  `tweetID` int NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `_timestamp` timestamp NULL DEFAULT NULL,
  `countryID` int DEFAULT NULL,
  `likes` int DEFAULT NULL,
  PRIMARY KEY (`tweetID`),
  KEY `userName` (`userName`),
  KEY `countryID` (`countryID`),
  CONSTRAINT `tweet_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `user` (`username`),
  CONSTRAINT `tweet_ibfk_2` FOREIGN KEY (`countryID`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweet`
--

LOCK TABLES `tweet` WRITE;
/*!40000 ALTER TABLE `tweet` DISABLE KEYS */;
INSERT INTO `tweet` VALUES (4,'Me gustan los macarrones','arnausito70','2022-06-26 21:14:21',69,2),(5,'I\'m the first user tweeting in United States!','arnausito70','2022-06-26 21:14:41',1,0),(6,'I love this app!','arnausito70','2022-06-26 21:15:20',1,1),(8,'Ciao a tutti!','oskins','2022-06-26 21:21:41',68,0),(9,'Ya cayó la noche','javierelmelenas','2022-06-26 23:19:02',69,1);
/*!40000 ALTER TABLE `tweet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(200) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `_password` varchar(200) DEFAULT NULL,
  `birthday_date` varchar(200) DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  `admin_check` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('arnausito70','arnau.camarero01@estudiant.upf.edu','Holamellamoarnau1','16/01/2001','male',69,0),('edu','eduardo.ruiz02@estudiant.upf.edu','soyEdu4','12/09/1998','male',69,0),('javierelmelenas','javipelolargo@hotmail.com','Mipeloesmuylargo2','10/3/1994','male',69,0),('oskins','oskins@gmail.com','Oskins3','02/11/1995','male',69,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_recommendation`
--

DROP TABLE IF EXISTS `user_recommendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_recommendation` (
  `username_user` varchar(200) NOT NULL,
  `ID_recommendation` int NOT NULL,
  `rate` float DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`username_user`,`ID_recommendation`),
  KEY `ID_recommendation` (`ID_recommendation`),
  CONSTRAINT `user_recommendation_ibfk_1` FOREIGN KEY (`username_user`) REFERENCES `user` (`username`),
  CONSTRAINT `user_recommendation_ibfk_2` FOREIGN KEY (`ID_recommendation`) REFERENCES `recommendation` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_recommendation`
--

LOCK TABLES `user_recommendation` WRITE;
/*!40000 ALTER TABLE `user_recommendation` DISABLE KEYS */;
INSERT INTO `user_recommendation` VALUES ('arnausito70',2,10,'Muy buen bar de tapas, totalmente recomendado'),('javierelmelenas',2,8,'Sitio muy familiar y amigable con los clientes');
/*!40000 ALTER TABLE `user_recommendation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-27  1:43:34
