-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `artical_categories`
--

DROP TABLE IF EXISTS `artical_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artical_categories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CATEGORY_NAME` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `IS_SHOW` varchar(1) DEFAULT NULL COMMENT '是否首页展示',
  `SHOW_ORDER` int(11) DEFAULT NULL COMMENT '展示序号',
  `ARTICAL_COUNT` int(11) DEFAULT NULL COMMENT '文章数量',
  `introduction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artical_categories`
--

LOCK TABLES `artical_categories` WRITE;
/*!40000 ALTER TABLE `artical_categories` DISABLE KEYS */;
INSERT INTO `artical_categories` VALUES (1,'随笔感悟','N',NULL,0,''),(2,'日常积累','Y',3,0,''),(3,'智慧生活','N',NULL,0,''),(4,'名家佳作','Y',2,0,''),(5,'博文转载','Y',4,0,''),(6,'天下杂谈','N',NULL,0,''),(7,'十个冷笑话','N',NULL,0,''),(8,'Java随笔','Y',1,0,''),(9,'操作系统','N',NULL,0,''),(10,'数据库','N',NULL,0,''),(11,'金融行业','N',NULL,0,'');
/*!40000 ALTER TABLE `artical_categories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-18 17:31:10
