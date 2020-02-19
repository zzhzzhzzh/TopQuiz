-- MySQL dump 10.13  Distrib 5.7.26, for Win32 (AMD64)
--
-- Host: localhost    Database: question
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
-- Table structure for table `t_quiz`
--

DROP TABLE IF EXISTS `t_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ques` varchar(500) NOT NULL,
  `ans` varchar(200) DEFAULT NULL,
  `quizTypeId` int(11) DEFAULT NULL,
  `quizDesc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_quizTypeId` (`quizTypeId`),
  CONSTRAINT `fk_quizTypeId` FOREIGN KEY (`quizTypeId`) REFERENCES `t_quiztype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_quiz`
--

LOCK TABLES `t_quiz` WRITE;
/*!40000 ALTER TABLE `t_quiz` DISABLE KEYS */;
INSERT INTO `t_quiz` VALUES (2,'What season comes right after winter?','Spring',1,'to test time'),(3,'Who is the first president of the United States?','George Washington',1,NULL),(4,'What is 80 minus 50?','30',1,NULL),(5,'What is the smallest prime number?','2',1,NULL),(6,'What is the closest planet to Earth?','moon',1,NULL),(7,'How do you write the number sixty-one using digits?','61',1,NULL),(8,'The superhero rescued 54 boys and 1 girl. How many people did he rescue in total?','55',1,NULL),(9,'What is the biggest value of all coins?','1 dollar',1,NULL),(10,'What is the median of 2,3,7?','3',1,NULL),(11,'What is the mode of 2,2,2,4,6?','2',1,NULL),(12,'What is the range of 1,2,4,8?','7',1,NULL),(13,'What is the average number of 3,7?','5',1,NULL),(14,'Tomorrow is Tuesday. What day is today?','Monday',1,NULL),(15,'How many days does July have?','31',1,NULL),(16,'How many minutes are in an hour?','60',1,NULL),(17,'What month is just after April?','May',1,NULL),(18,'Christmas is a holiday in which religion?','Christianity',1,NULL),(19,'What Dr. Martin Luther King, Jr. want to be when he was in college?','minister',1,NULL),(20,'What is the capital of Texas?','Austin',1,NULL),(21,'What is the closest star to Earth?','sun',1,NULL);
/*!40000 ALTER TABLE `t_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_quiztype`
--

DROP TABLE IF EXISTS `t_quiztype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_quiztype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quizTypeName` varchar(30) NOT NULL,
  `quizTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_quiztype`
--

LOCK TABLES `t_quiztype` WRITE;
/*!40000 ALTER TABLE `t_quiztype` DISABLE KEYS */;
INSERT INTO `t_quiztype` VALUES (1,'text-based','The answer is based on text.'),(2,'mouse-based',''),(3,'interactive',''),(5,'test','for test purpose');
/*!40000 ALTER TABLE `t_quiztype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','123456');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-19 10:31:40
