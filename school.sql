-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: schooldemo
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int DEFAULT NULL,
  `grade_level` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1,'2020级','小龙','2020211301051','xiaolong'),(2,1,'2020级','小鹿 ','2020211301052','xiaolu'),(3,2,'2020级','小林','2020211301053','xiaolin'),(4,2,'2020级','小灵 ','2020211301054','xiaoling'),(5,1,'2020级','小双','2020211301055','xiaoshuang'),(6,2,'2020级','小聪','2020211301056','xiaocong'),(7,1,'2020级','小笨','2020211301057','xiaobeng'),(8,2,'2020级','小巫','2020211301058','xiaowu'),(9,1,'2020级','小明','2020211301059','xiaoming'),(10,1,'2020级','小红','2020211301040','xiaohong'),(11,2,'2020级','张三','2020211301041','zhangsan'),(12,2,'2020级','李四','2020211301042','lisi');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_grade`
--

DROP TABLE IF EXISTS `student_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_code` int DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_teacher` varchar(255) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_grade`
--

LOCK TABLES `student_grade` WRITE;
/*!40000 ALTER TABLE `student_grade` DISABLE KEYS */;
INSERT INTO `student_grade` VALUES (1,20210001,'数据结构','王五',76,'小龙 ','2020211301051'),(2,20210001,'数据结构','王五',67,'小鹿 ','2020211301052'),(3,20210001,'数据结构','王五',87,'小双','2020211301055'),(4,20210001,'数据结构','王五',56,'小笨','2020211301057'),(5,20210001,'数据结构','王五',68,'小明','2020211301059'),(6,20210001,'数据结构','王五',89,'小红','2020211301040'),(7,20210001,'数据结构','王六',93,'小林','2020211301053'),(8,20210001,'数据结构','王六',34,'小灵 ','2020211301054'),(9,20210001,'数据结构','王六',54,'小聪','2020211301056'),(10,20210001,'数据结构','王六',88,'小巫','2020211301058'),(11,20210001,'数据结构','王六',76,'张三','2020211301041'),(12,20210001,'数据结构','王六',59,'李四','2020211301042'),(13,20210002,'操作系统','王五',87,'小龙 ','2020211301051'),(14,20210002,'操作系统','王五',54,'小鹿 ','2020211301052'),(15,20210002,'操作系统','王五',78,'小双','2020211301055'),(16,20210002,'操作系统','王五',89,'小笨','2020211301057'),(17,20210002,'操作系统','王五',90,'小明','2020211301059'),(18,20210002,'操作系统','王五',97,'小红','2020211301040'),(19,20210002,'操作系统','王六',45,'小林','2020211301053'),(20,20210002,'操作系统','王六',34,'小灵 ','2020211301054'),(21,20210002,'操作系统','王六',23,'小聪','2020211301056'),(22,20210002,'操作系统','王六',67,'小巫','2020211301058'),(23,20210002,'操作系统','王六',85,'张三','2020211301041'),(24,20210002,'操作系统','王六',82,'李四','2020211301042'),(25,20210003,'计算机组成原理','王五',67,'小龙 ','2020211301051'),(26,20210003,'计算机组成原理','王五',76,'小鹿 ','2020211301052'),(27,20210003,'计算机组成原理','王五',58,'小双','2020211301055'),(28,20210003,'计算机组成原理','王五',47,'小笨','2020211301057'),(29,20210003,'计算机组成原理','王五',90,'小明','2020211301059'),(30,20210003,'计算机组成原理','王五',89,'小红','2020211301040'),(31,20210003,'计算机组成原理','王六',78,'小林','2020211301053'),(32,20210003,'计算机组成原理','王六',77,'小灵 ','2020211301054'),(33,20210003,'计算机组成原理','王六',89,'小聪','2020211301056'),(34,20210003,'计算机组成原理','王六',88,'小巫','2020211301058'),(35,20210003,'计算机组成原理','王六',67,'张三','2020211301041'),(36,20210003,'计算机组成原理','王六',77,'李四','2020211301042'),(37,20210004,'计算机网络','王五',80,'小龙 ','2020211301051'),(38,20210004,'计算机网络','王五',78,'小鹿 ','2020211301052'),(39,20210004,'计算机网络','王五',98,'小双','2020211301055'),(40,20210004,'计算机网络','王五',89,'小笨','2020211301057'),(41,20210004,'计算机网络','王五',67,'小明','2020211301059'),(42,20210004,'计算机网络','王五',45,'小红','2020211301040'),(43,20210004,'计算机网络','王六',57,'小林','2020211301053'),(44,20210004,'计算机网络','王六',66,'小灵 ','2020211301054'),(45,20210004,'计算机网络','王六',60,'小聪','2020211301056'),(46,20210004,'计算机网络','王六',45,'小巫','2020211301058'),(47,20210004,'计算机网络','王六',48,'张三','2020211301041'),(48,20210004,'计算机网络','王六',82,'李四','2020211301042'),(49,20210005,'C语言程序设计','王五',82,'小龙 ','2020211301051'),(50,20210005,'C语言程序设计','王五',45,'小鹿 ','2020211301052'),(51,20210005,'C语言程序设计','王五',89,'小双','2020211301055'),(52,20210005,'C语言程序设计','王五',89,'小笨','2020211301057'),(53,20210005,'C语言程序设计','王五',65,'小明','2020211301059'),(54,20210005,'C语言程序设计','王五',45,'小红','2020211301040'),(55,20210005,'C语言程序设计','王六',54,'小林','2020211301053'),(56,20210005,'C语言程序设计','王六',99,'小灵 ','2020211301054'),(57,20210005,'C语言程序设计','王六',60,'小聪','2020211301056'),(58,20210005,'C语言程序设计','王六',65,'小巫','2020211301058'),(59,20210005,'C语言程序设计','王六',98,'张三','2020211301041'),(60,20210005,'C语言程序设计','王六',66,'李四','2020211301042'),(61,20210006,'Java程序设计','王五',83,'小龙 ','2020211301051'),(62,20210006,'Java程序设计','王五',77,'小鹿 ','2020211301052'),(63,20210006,'Java程序设计','王五',89,'小双','2020211301055'),(64,20210006,'Java程序设计','王五',98,'小笨','2020211301057'),(65,20210006,'Java程序设计','王五',67,'小明','2020211301059'),(66,20210006,'Java程序设计','王五',45,'小红','2020211301040'),(67,20210006,'Java程序设计','王六',54,'小林','2020211301053'),(68,20210006,'Java程序设计','王六',97,'小灵 ','2020211301054'),(69,20210006,'Java程序设计','王六',60,'小聪','2020211301056'),(70,20210006,'Java程序设计','王六',67,'小巫','2020211301058'),(71,20210006,'Java程序设计','王六',77,'张三','2020211301041'),(72,20210006,'Java程序设计','王六',56,'李四','2020211301042');
/*!40000 ALTER TABLE `student_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_course`
--

DROP TABLE IF EXISTS `sys_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_code` int DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_teacher` varchar(255) DEFAULT NULL,
  `course_class` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_course`
--

LOCK TABLES `sys_course` WRITE;
/*!40000 ALTER TABLE `sys_course` DISABLE KEYS */;
INSERT INTO `sys_course` VALUES (1,20210001,'数据结构','王五',1),(2,20210001,'数据结构','王六',2),(3,20210002,'操作系统','王五',1),(4,20210002,'操作系统','王六',2),(5,20210003,'计算机组成原理','王五',1),(6,20210003,'计算机组成原理','王六',2),(7,20210004,'计算机网络','王五',1),(8,20210004,'计算机网络','王六',2),(9,20210005,'C语言程序设计','王五',1),(10,20210005,'C语言程序设计','王六',2),(11,20210006,'Java程序设计','王五',1),(12,20210006,'Java程序设计','王六',2);
/*!40000 ALTER TABLE `sys_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(155) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `work_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'王五','wangwu','2020211301067'),(2,'王六','wangliu','2020211301068');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_uer_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='所有用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('zhangsan','25d55ad283aa400af464c76d713c07ad',1,2),('lisi','25d55ad283aa400af464c76d713c07ad',2,2),('wangwu','25d55ad283aa400af464c76d713c07ad',3,1),('xiaoming','25d55ad283aa400af464c76d713c07ad',4,2),('xiaohong','25d55ad283aa400af464c76d713c07ad',5,2),('admin','25d55ad283aa400af464c76d713c07ad',6,3),('xiaolong','25d55ad283aa400af464c76d713c07ad',7,2),('xiaolu','25d55ad283aa400af464c76d713c07ad',8,2),('xiaolin','25d55ad283aa400af464c76d713c07ad',9,2),('xiaoling','25d55ad283aa400af464c76d713c07ad',10,2),('xiaoshuang','25d55ad283aa400af464c76d713c07ad',11,2),('xiaocong','25d55ad283aa400af464c76d713c07ad',12,2),('xiaobeng','25d55ad283aa400af464c76d713c07ad',13,2),('xiaowu','25d55ad283aa400af464c76d713c07ad',14,2),('wangliu','25d55ad283aa400af464c76d713c07ad',15,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-01 21:59:13
