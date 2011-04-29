-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.34-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mycontacts
--

CREATE DATABASE IF NOT EXISTS mycontacts;
USE mycontacts;

--
-- Definition of table `contactdetails`
--

DROP TABLE IF EXISTS `contactdetails`;
CREATE TABLE `contactdetails` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactdetails`
--

/*!40000 ALTER TABLE `contactdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactdetails` ENABLE KEYS */;


--
-- Definition of table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `contactid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY (`contactid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contacts`
--

/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` (`contactid`,`firstname`,`middlename`,`lastname`,`address`,`mobile`,`emailid`) VALUES 
 (1,'Sabbir','Kumar','Manandhar','Bhaktapur','9841753847','leo.shabr@gmail.com');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;


--
-- Definition of table `principal`
--

DROP TABLE IF EXISTS `principal`;
CREATE TABLE `principal` (
  `emailid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `contactid` int(10) unsigned NOT NULL,
  `authority` varchar(45) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailid`),
  KEY `FK_principle_1` (`contactid`),
  CONSTRAINT `FK_principle_1` FOREIGN KEY (`contactid`) REFERENCES `contacts` (`contactid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `principal`
--

/*!40000 ALTER TABLE `principal` DISABLE KEYS */;
INSERT INTO `principal` (`emailid`,`username`,`password`,`contactid`,`authority`,`name`) VALUES 
 ('leo.shabr@gmail.com','sabbir','4bd5361ee9f4a9ad8d7470efeb124d122d14d5bd',1,'USER_ROLE','sabbir');
/*!40000 ALTER TABLE `principal` ENABLE KEYS */;


--
-- Definition of table `usercontacts`
--

DROP TABLE IF EXISTS `usercontacts`;
CREATE TABLE `usercontacts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `contactid` int(10) unsigned NOT NULL,
  `shared` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usercontacts_1` (`userid`),
  KEY `FK_usercontacts_2` (`contactid`),
  CONSTRAINT `FK_usercontacts_1` FOREIGN KEY (`userid`) REFERENCES `principal` (`emailid`),
  CONSTRAINT `FK_usercontacts_2` FOREIGN KEY (`contactid`) REFERENCES `contacts` (`contactid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usercontacts`
--

/*!40000 ALTER TABLE `usercontacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercontacts` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
