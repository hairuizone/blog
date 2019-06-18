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
-- Table structure for table `editmd`
--

DROP TABLE IF EXISTS `editmd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editmd` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `content` longtext COMMENT '文本内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editmd`
--

LOCK TABLES `editmd` WRITE;
/*!40000 ALTER TABLE `editmd` DISABLE KEYS */;
INSERT INTO `editmd` VALUES (1,'**asdfa\n# Markdown语法\n## 一、更改字体、大小、颜色\n<font face=\"黑体\">黑体</font>  <font face=\"微软雅黑\">微软雅黑</font>  <font face=\"宋体\">宋体</font>  <font face=\"STCAIYUN\">我是华文彩云</font>\n<font color=red>我是红色</font>  <font color=#008000>我是绿色</font>  <font color=Blue>我是蓝色</font>\n<font size=5>我是尺寸</font>\n<font face=\"黑体\" color=green size=5>我是黑体，绿色，尺寸为5</font>\n## 二、为文字添加背景色\n<table><tr><td bgcolor=green><font face=\"黑体\" size=5>背景色-green</font></td></tr><tr><td bgcolor=yellow>背景色-yellow</td></tr><tr><td bgcolor=blue>背景色-blue</td></tr></table>');
/*!40000 ALTER TABLE `editmd` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-18 17:31:09
