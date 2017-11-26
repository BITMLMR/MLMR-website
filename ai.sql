-- MySQL dump 10.10
--
-- Host: localhost    Database: ai
-- ------------------------------------------------------
-- Server version	5.0.24-community-nt

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `aid` varchar(20) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `admin_name` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `admin`
--


/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (1,'admin','123','');
UNLOCK TABLES;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `attachment_id` int(10) unsigned NOT NULL auto_increment,
  `source_id` int(10) unsigned NOT NULL default '0',
  `attachment_name` varchar(100) NOT NULL default '',
  `attachment_addr` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `attachment`
--


/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
LOCK TABLES `attachment` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `source_id` int(10) unsigned NOT NULL default '0',
  `username` varchar(45) NOT NULL default '',
  `homework_addr` varchar(255) NOT NULL default '',
  `homework_time` datetime NOT NULL default '2016-01-01 00:00:00',
  `teacher` varchar(45) default NULL,
  `correction_addr` varchar(255) NOT NULL default '',
  `correction_time` datetime NOT NULL default '2016-01-01 00:00:00',
  `homework_title` varchar(200) NOT NULL default '',
  `correction_title` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `homework`
--


/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
LOCK TABLES `homework` WRITE;

UNLOCK TABLES;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(10) unsigned NOT NULL auto_increment,
  `usename` varchar(40) NOT NULL default '',
  `question` mediumtext NOT NULL,
  `answer` mediumtext NOT NULL,
  `question_time` datetime NOT NULL default '2016-01-01 00:00:00',
  `answer_time` datetime NOT NULL default '2016-01-01 00:00:00',
  `teacher` varchar(40) NOT NULL default '',
  `title` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `message`
--


/*!40000 ALTER TABLE `message` DISABLE KEYS */;
LOCK TABLES `message` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

--
-- Table structure for table `new`
--

DROP TABLE IF EXISTS `new`;
CREATE TABLE `new` (
  `new_id` int(10) unsigned NOT NULL auto_increment,
  `new_title` varchar(250) NOT NULL default '',
  `new_content` mediumtext NOT NULL,
  `new_date` datetime NOT NULL default '2016-01-01 00:00:00',
  `new_author` varchar(45) default NULL,
  `legal` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`new_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `new`
--


/*!40000 ALTER TABLE `new` DISABLE KEYS */;
LOCK TABLES `new` WRITE;
INSERT INTO `new` VALUES (6,'教材勘误表','资源共享中有教材勘误表，其中的勘误有助于正确理解书中有关内容','2010-09-24 02:19:26','admin',1),(7,'请用学号注册，否则不能审核通过','','2010-09-30 07:15:38','admin',1),(8,'作业有中英文两种版本,英文版是为外国留学生准备的','','2010-10-05 02:47:35','admin',1),(9,'对作业的批改结果在作业文档的最后，以红色显示','','2010-10-10 01:09:54','admin',1),(10,'第三章练习题已发布','','2010-11-01 07:06:30','admin',1),(11,'研究生第1次大作业题已发布','','2010-11-06 07:10:50','admin',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `new` ENABLE KEYS */;

--
-- Table structure for table `source`
--

DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `source_id` int(10) unsigned NOT NULL auto_increment,
  `source_title` varchar(120) NOT NULL default '',
  `channel` int(10) unsigned NOT NULL default '0',
  `type` int(10) unsigned NOT NULL default '0',
  `source_date` datetime NOT NULL default '2016-01-01 00:00:00',
  `source_author` varchar(20) default NULL,
  `source_content` mediumtext,
  `legal` int(10) unsigned NOT NULL default '0',
  `tree_id` varchar(500) default NULL,
  PRIMARY KEY  (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `source`
--


/*!40000 ALTER TABLE `source` DISABLE KEYS */;
LOCK TABLES `source` WRITE;

UNLOCK TABLES;
/*!40000 ALTER TABLE `source` ENABLE KEYS */;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `content` varchar(45) NOT NULL default '',
  `username` varchar(45) NOT NULL default '',
  `time` datetime NOT NULL default '2016-01-01 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `suggestion`
--


/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
LOCK TABLES `suggestion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;

--
-- Table structure for table `tree`
--

DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `tree_id` int(10) unsigned NOT NULL auto_increment,
  `tree_name` varchar(50) default NULL,
  `parent_id` int(10) unsigned default NULL,
  `level` int(10) unsigned default NULL,
  `order` int(10) unsigned default NULL,
  PRIMARY KEY  (`tree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tree`
--


/*!40000 ALTER TABLE `tree` DISABLE KEYS */;
LOCK TABLES `tree` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `tree` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `usename` varchar(20) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `email` varchar(100) NOT NULL default '',
  `nickname` varchar(20) default NULL,
  `gender` varchar(10) NOT NULL default '0',
  `registerdate` datetime NOT NULL default '2016-01-01 00:00:00',
  `loginNum` int(10) unsigned NOT NULL default '0',
  `validateCode` varchar(20) NOT NULL default '',
  `status` varchar(20) NOT NULL default '',
  `question` varchar(500) NOT NULL default '',
  `answer` varchar(500) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (15,'admin','333333','violet_66635@163.com',NULL,'9','2010-09-01 17:54:45',99,'activated','1','333','333');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
