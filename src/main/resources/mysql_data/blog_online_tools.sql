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
-- Table structure for table `online_tools`
--

DROP TABLE IF EXISTS `online_tools`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_tools` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `TOOL_NAME` varchar(50) DEFAULT NULL COMMENT '工具名称',
  `URL` varchar(255) DEFAULT NULL COMMENT '网址',
  `INTRODUCE` longtext COMMENT '工具介绍',
  `ADD_DATE` varchar(20) DEFAULT NULL COMMENT '添加日期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_tools`
--

LOCK TABLES `online_tools` WRITE;
/*!40000 ALTER TABLE `online_tools` DISABLE KEYS */;
INSERT INTO `online_tools` VALUES (1,'程序员在线工具','http://www.ofmonkey.com/','','2019-06-17'),(2,'在线代码格式化','http://tool.oschina.net/codeformat/','','2019-06-17'),(3,'身份证号码查询验证','http://qq.ip138.com/baidu-id/index.asp','','2019-06-17'),(4,'全国各地车牌查询表','http://www.ip138.com/carlist.htm','','2019-06-17'),(5,'彩票开奖结果查询','https://caipiao.ip138.com/','','2019-06-17'),(6,'邮编查询区号查询','http://www.ip138.com/post/','','2019-06-17'),(7,'有道在线翻译','http://fanyi.youdao.com/','','2019-06-17'),(8,'代码在线运行','https://tool.lu/coderunner/','','2019-06-17'),(9,'在线透明favicon ico图标文件制作','http://www.atool9.com/ico.php','','2019-06-17'),(10,'脚本之家在线工具','http://tools.jb51.net/','','2019-06-17');
/*!40000 ALTER TABLE `online_tools` ENABLE KEYS */;
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
