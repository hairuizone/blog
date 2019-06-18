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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `BOOK_NAME` varchar(255) DEFAULT NULL COMMENT '书籍名称',
  `AUTHOR` varchar(255) DEFAULT NULL COMMENT '作者',
  `PUBLISH_DATE` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `URL` varchar(255) DEFAULT NULL COMMENT '书籍所在网络URL',
  `LOCAL_PATH` varchar(255) DEFAULT NULL COMMENT '本地存放地址',
  `ADD_DATE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'普罗旺斯的一年','（英）彼得·梅尔','2011-05-01',NULL,'E:/myblog/普罗旺斯的一年.pdf','2019-06-17'),(2,'不抱怨的世界','威尔 鲍温','2009-04-01',NULL,'E:/myblog/不抱怨的世界.pdf','2019-06-17'),(3,'钢铁是怎样炼成的','保尔·柯察金','1996-10-01',NULL,'E:/myblog/钢铁是怎样炼成的.pdf','2019-06-17'),(4,'平凡的世界','路遥','1986-01-01',NULL,'E:/myblog/平凡的世界.pdf','2019-06-17'),(5,'苏菲的世界','乔斯坦·贾德','1991-01-01',NULL,'E:/myblog/苏菲的世界.pdf','2019-06-17'),(6,'围城','钱钟书','1947-01-01',NULL,'E:/myblog/围城.pdf','2019-06-17'),(7,'普罗旺斯的一年','（英）彼得·梅尔','2011-05-01',NULL,'E:/myblog/普罗旺斯的一年.pdf','2019-06-17'),(8,'不抱怨的世界','威尔 鲍温','2009-04-01',NULL,'E:/myblog/不抱怨的世界.pdf','2019-06-17'),(9,'钢铁是怎样炼成的','保尔·柯察金','1996-10-01',NULL,'E:/myblog/钢铁是怎样炼成的.pdf','2019-06-17'),(10,'平凡的世界','路遥','1986-01-01',NULL,'E:/myblog/平凡的世界.pdf','2019-06-17'),(11,'苏菲的世界','乔斯坦·贾德','1991-01-01',NULL,'E:/myblog/苏菲的世界.pdf','2019-06-17'),(12,'围城','钱钟书','1947-01-01',NULL,'E:/myblog/围城.pdf','2019-06-17');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-18 17:31:08
