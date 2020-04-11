CREATE DATABASE  IF NOT EXISTS `bombapatch` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bombapatch`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bombapatch
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `campeonato`
--

DROP TABLE IF EXISTS `campeonato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campeonato` (
  `id_campeonato` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_campeonato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato`
--

LOCK TABLES `campeonato` WRITE;
/*!40000 ALTER TABLE `campeonato` DISABLE KEYS */;
/*!40000 ALTER TABLE `campeonato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato_estatistica`
--

DROP TABLE IF EXISTS `campeonato_estatistica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campeonato_estatistica` (
  `id_estatistica` int NOT NULL AUTO_INCREMENT,
  `pontuacao` double DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `idcampeonato` int DEFAULT NULL,
  `colocacao` int DEFAULT NULL,
  PRIMARY KEY (`id_estatistica`),
  KEY `id_usuario_idx` (`id_usuario`),
  KEY `idcampeonato` (`idcampeonato`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idcampeonato` FOREIGN KEY (`idcampeonato`) REFERENCES `campeonato` (`id_campeonato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato_estatistica`
--

LOCK TABLES `campeonato_estatistica` WRITE;
/*!40000 ALTER TABLE `campeonato_estatistica` DISABLE KEYS */;
/*!40000 ALTER TABLE `campeonato_estatistica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador_time`
--

DROP TABLE IF EXISTS `jogador_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogador_time` (
  `id_jogador` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `id_time` int DEFAULT NULL,
  `gols` int DEFAULT NULL,
  `eh_artilheiro` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_jogador`),
  KEY `id_time_idx` (`id_time`),
  CONSTRAINT `id_time` FOREIGN KEY (`id_time`) REFERENCES `time` (`id_time`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador_time`
--

LOCK TABLES `jogador_time` WRITE;
/*!40000 ALTER TABLE `jogador_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `jogador_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partida` (
  `id_partida` int NOT NULL AUTO_INCREMENT,
  `id_campeonato` int DEFAULT NULL,
  `num_partida` int DEFAULT NULL,
  `time1` int DEFAULT NULL,
  `time2` int DEFAULT NULL,
  `placar_time1` int DEFAULT NULL,
  `placar_time2` int DEFAULT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `id_campeonato_idx` (`id_campeonato`),
  KEY `time1_idx` (`time1`),
  KEY `time2_idx` (`time2`),
  CONSTRAINT `id_campeonato` FOREIGN KEY (`id_campeonato`) REFERENCES `campeonato` (`id_campeonato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `time1` FOREIGN KEY (`time1`) REFERENCES `time` (`id_time`),
  CONSTRAINT `time2` FOREIGN KEY (`time2`) REFERENCES `time` (`id_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `id_time` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `pontuacao_total` double DEFAULT NULL,
  PRIMARY KEY (`id_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `senha_UNIQUE` (`senha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_time`
--

DROP TABLE IF EXISTS `usuario_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_time` (
  `idusuario` int DEFAULT NULL,
  `idtime` int DEFAULT NULL,
  `idcampeonato` int DEFAULT NULL,
  `idusuario_time` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idusuario_time`),
  KEY `idusuario` (`idusuario`),
  KEY `idtime` (`idtime`),
  KEY `campeonatoid` (`idcampeonato`),
  CONSTRAINT `campeonatoid` FOREIGN KEY (`idcampeonato`) REFERENCES `campeonato` (`id_campeonato`),
  CONSTRAINT `idtime` FOREIGN KEY (`idtime`) REFERENCES `time` (`id_time`),
  CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_time`
--

LOCK TABLES `usuario_time` WRITE;
/*!40000 ALTER TABLE `usuario_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-11 13:31:02
