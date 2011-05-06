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
-- Definition of table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `contactid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY (`contactid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contacts`
--

/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` (`contactid`,`firstname`,`middlename`,`lastname`,`address`,`mobile`,`emailid`) VALUES 
 (1,'Sabbir','Kumar','Manandhar','Bhaktapur','9841753847','leo.shabr@gmail.com'),
 (2,'Bishwa','Hang','Rai','Jhapa','9841562354','nawa@n.com'),
 (3,'Biru','Charan','Sainju','Suryabinayak','9841585559','nawa@n.com'),
 (4,'Samit',' ','Pokharel','Pokhara','98415987562','nawa@n.com');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;


--
-- Definition of table `principal`
--

DROP TABLE IF EXISTS `principal`;
CREATE TABLE `principal` (
  `emailid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `principal`
--

/*!40000 ALTER TABLE `principal` DISABLE KEYS */;
INSERT INTO `principal` (`emailid`,`username`,`password`,`authority`) VALUES 
 ('leo.shabr@gmail.com','sabbir','4bd5361ee9f4a9ad8d7470efeb124d122d14d5bd','USER_ROLE'),
 ('nawa@n.com','nawaraj','059333939c3f06e0ab9b259b13a8e5bc90852bea','ROLE_AUTHENTICATED'),
 ('v@v.com','voldemort','00d021f0d82501995e5e5d19ba4e96038980a7b6','ROLE_AUTHENTICATED');
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
