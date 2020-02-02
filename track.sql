-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: track
-- ------------------------------------------------------
-- Server version	5.5.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drive`
--

DROP TABLE IF EXISTS `drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drive` (
  `DID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(100) DEFAULT NULL,
  `NO_OF_RSRCS` int(11) DEFAULT NULL,
  `EXP_REQ` tinyint(4) DEFAULT NULL,
  `CTC` float DEFAULT NULL,
  `JOIN_CRT` tinyint(4) DEFAULT NULL,
  `BOND` float DEFAULT NULL,
  `POSITION` tinyint(4) DEFAULT NULL,
  `FOLLOWUP` date DEFAULT NULL,
  `EDU_CRT` tinyint(4) DEFAULT NULL,
  `CUR_STATUS` tinyint(4) DEFAULT NULL,
  `NXT_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PS_YR_REQ` int(11) DEFAULT NULL,
  `GAP_REQ` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` date DEFAULT NULL,
  `TPOID` int(11) DEFAULT NULL,
  `ACTUAL_DATE` date DEFAULT NULL,
  `GST` varchar(15) NOT NULL,
  PRIMARY KEY (`DID`,`GST`),
  KEY `TPOID_idx` (`TPOID`),
  CONSTRAINT `TPOID` FOREIGN KEY (`TPOID`) REFERENCES `tpo` (`TPOID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive`
--

LOCK TABLES `drive` WRITE;
/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
INSERT INTO `drive` VALUES (6,'TCS',3,2,3,1,2,2,'2019-02-14',1,NULL,'2020-01-20 05:42:12',NULL,NULL,NULL,NULL,NULL,''),(10,'Cognizant',2,1,3,1,1,3,'2019-02-14',1,NULL,'2020-01-20 07:24:33',NULL,NULL,NULL,NULL,NULL,''),(13,'Synechroneee',2,3,3,0,2,0,'2019-09-12',0,NULL,'2020-01-22 05:22:52',NULL,NULL,NULL,NULL,NULL,''),(16,'Infosys',2,2,3,0,2,2,'2019-02-14',0,NULL,'2020-01-28 12:23:20',NULL,NULL,NULL,NULL,NULL,''),(18,'Greenlight',2,2,3,0,3,1,'2019-03-02',0,NULL,'2020-02-01 07:52:08',NULL,NULL,NULL,NULL,NULL,''),(20,'Whitree',2,2,3,0,2,0,'2019-09-02',0,NULL,'2020-02-01 14:12:23',NULL,NULL,NULL,NULL,NULL,'123456789012345'),(21,'Yardi',2,1,4,1,1,2,'2019-02-14',1,NULL,'2020-02-01 14:29:03',NULL,NULL,NULL,NULL,NULL,'121324354645784');
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud`
--

DROP TABLE IF EXISTS `drive_stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drive_stud` (
  `DSID` int(11) NOT NULL AUTO_INCREMENT,
  `DID` int(11) DEFAULT NULL,
  `ST_ID` int(11) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TPOID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DSID`),
  KEY `DID_idx` (`DID`),
  KEY `TPOID_idx` (`TPOID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud`
--

LOCK TABLES `drive_stud` WRITE;
/*!40000 ALTER TABLE `drive_stud` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud_track`
--

DROP TABLE IF EXISTS `drive_stud_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drive_stud_track` (
  `DSR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DID` int(11) NOT NULL,
  `STID` int(11) DEFAULT NULL,
  `TPOID` int(11) DEFAULT NULL,
  `SURVIVED_STATUS` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`DSR_ID`,`DID`),
  KEY `DID_idx` (`DID`),
  KEY `TPOID_idx` (`TPOID`),
  CONSTRAINT `d` FOREIGN KEY (`DID`) REFERENCES `drive` (`DID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `m` FOREIGN KEY (`TPOID`) REFERENCES `tpo` (`TPOID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud_track`
--

LOCK TABLES `drive_stud_track` WRITE;
/*!40000 ALTER TABLE `drive_stud_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_track`
--

DROP TABLE IF EXISTS `drive_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drive_track` (
  `TR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DID` int(11) DEFAULT NULL,
  `Statuss` tinyint(4) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TPOID` int(11) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `NO_OF_STUDENTS` int(11) DEFAULT NULL,
  PRIMARY KEY (`TR_ID`),
  KEY `dd` (`DID`),
  CONSTRAINT `dd` FOREIGN KEY (`DID`) REFERENCES `drive` (`DID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_track`
--

LOCK TABLES `drive_track` WRITE;
/*!40000 ALTER TABLE `drive_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud`
--

DROP TABLE IF EXISTS `stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud` (
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(40) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud`
--

LOCK TABLES `stud` WRITE;
/*!40000 ALTER TABLE `stud` DISABLE KEYS */;
INSERT INTO `stud` VALUES ('anjali','anjali123','anj98anh@gmail.com','female','India','2345678456'),('priti','priti1234','priti123A@gmail.com','female','India','8326523456'),('anjali','anjali123','anjaliA@gmail.com','female','India','1234566782');
/*!40000 ALTER TABLE `stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpo`
--

DROP TABLE IF EXISTS `tpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpo` (
  `TPOID` int(11) NOT NULL AUTO_INCREMENT,
  `TPO_NAME` varchar(100) DEFAULT NULL,
  `TOP_EMAIL` varchar(80) DEFAULT NULL,
  `TPO_USERNAME` varchar(80) DEFAULT NULL,
  `TOP_PASSWORD` varchar(70) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ROLE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`TPOID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpo`
--

LOCK TABLES `tpo` WRITE;
/*!40000 ALTER TABLE `tpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tpo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-01 20:39:00
