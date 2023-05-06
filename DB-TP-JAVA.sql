-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gimnasiojava
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `total_cupos` int(11) DEFAULT NULL,
  `dia` varchar(45) DEFAULT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `legajo` int(11) DEFAULT NULL,
  `idtipo_clase` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `legajoFK_idx` (`legajo`),
  KEY `idtipoClaseFK_idx` (`idtipo_clase`),
  CONSTRAINT `idtipoClaseFK` FOREIGN KEY (`idtipo_clase`) REFERENCES `tipo_clase` (`idtipo_clase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `legajoFK` FOREIGN KEY (`legajo`) REFERENCES `profesional` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` VALUES (1,10,'Lunes','20:00',30269528,1),(2,8,'Lunes','19:00',35216633,2),(3,10,'Martes','19:00',30269528,1),(4,5,'Miercoles','21:00',30269528,1),(5,10,'Viernes','10:00',35216633,3),(6,10,'Jueves','10:00',41316826,4);
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuota` (
  `mes` int(11) NOT NULL,
  `precio` varchar(45) NOT NULL,
  `idcuota` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(11) NOT NULL,
  `anio` int(5) DEFAULT NULL,
  `fecha_pago` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idcuota`,`dni`),
  KEY `dniFK2_idx` (`dni`),
  CONSTRAINT `fk1` FOREIGN KEY (`dni`) REFERENCES `socio` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
INSERT INTO `cuota` VALUES (3,'4000',1,35216759,2023,'2/3/2023'),(4,'4000',2,35216759,2023,'2/4/2023'),(5,'3800',3,35216759,2023,'2/4/2023'),(2,'4000',4,37311851,2023,'2/2/2023'),(7,'4000',5,37316789,2020,'5/6/2020'),(2,'1000',6,40316756,2023,'2/2/2023'),(3,'1000',7,40316756,2023,'2/3/2023'),(4,'1000',8,40316756,2023,'2/4/2023'),(10,'500',9,41316836,2022,'10/10/2021'),(5,'4000',10,41316836,2023,'2/5/2023');
/*!40000 ALTER TABLE `cuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesional`
--

DROP TABLE IF EXISTS `profesional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesional` (
  `dni` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `dni_usuarioProf_FK` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41316827 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesional`
--

LOCK TABLES `profesional` WRITE;
/*!40000 ALTER TABLE `profesional` DISABLE KEYS */;
INSERT INTO `profesional` VALUES (27456987,'Luis','Bazzi','123456'),(30269528,'Maria','Ramirez','123456'),(35216633,'Silvana','Cortez','123456'),(41316826,'Mauro','Perez','123456');
/*!40000 ALTER TABLE `profesional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `dniFK_idx` (`dni`),
  KEY `codigofk_idx` (`codigo`),
  CONSTRAINT `codigo_clase_FK` FOREIGN KEY (`codigo`) REFERENCES `clase` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `dni_socio_FK` FOREIGN KEY (`dni`) REFERENCES `socio` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (50,'5/5/2023',35216759,1),(51,'5/5/2023',35216759,2),(52,'3/5/2023',37311851,1),(53,'3/5/2023',37316789,1),(54,'1/5/2023',40316756,2),(55,'2/4/2023',40316756,3),(56,'2/4/2023',41316836,4),(57,'2/4/2023',41316836,5),(58,'1/5/2023',40316756,6);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutina`
--

DROP TABLE IF EXISTS `rutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutina` (
  `idrutina` int(11) NOT NULL AUTO_INCREMENT,
  `dia` varchar(15) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `dniP` int(11) DEFAULT NULL,
  `idtiporutina` int(11) DEFAULT NULL,
  `series_repeticiones` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrutina`),
  KEY `dnifk2_idx` (`dni`),
  KEY `lagejoFk2_idx` (`dniP`),
  KEY `idtipoRutinaFK_idx` (`idtiporutina`),
  CONSTRAINT `dnifk2` FOREIGN KEY (`dni`) REFERENCES `socio` (`dni`) ON UPDATE CASCADE,
  CONSTRAINT `idtipoRutinaFK` FOREIGN KEY (`idtiporutina`) REFERENCES `tiporutina` (`idtipo`) ON UPDATE CASCADE,
  CONSTRAINT `legajoFk2` FOREIGN KEY (`dniP`) REFERENCES `profesional` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutina`
--

LOCK TABLES `rutina` WRITE;
/*!40000 ALTER TABLE `rutina` DISABLE KEYS */;
INSERT INTO `rutina` VALUES (1,'5/5/2023',35216759,30269528,4,'4 series x 8/15 reps'),(2,'5/5/2023',35216759,30269528,4,'5 series x 8/15 reps.'),(3,'9/5/2023',35216759,41316826,11,'4 series x 8/10 reps.'),(4,'8/5/2023',40316756,35216633,3,'6 series x 8/10 reps.'),(5,'8/5/2023',40316756,35216633,5,'8 series x 8/10 reps.'),(6,'8/5/2023',40316756,35216633,1,'1 series x 8/10 reps.');
/*!40000 ALTER TABLE `rutina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `dni` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `num_celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `dni_usuario_FK` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (30526985,'dni','java','Camilo','Armando','3476216673'),(35216759,'dni','java','Angelina','Savio','3476216677'),(37311851,'dni','java','Silvana ','Dominguez','341615875'),(37316789,'dni','java','Cecilia','Pistelli','3471618599'),(40316756,'dni','java','Agustin ','Bazzi','3476613365'),(41312036,'dni','java','Faustina','Santos','341523398'),(41316836,'dni','java','Juan','Perez','3476523398'),(41316845,'dni','java','Juan Martin','Plano','3476523350');
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_clase`
--

DROP TABLE IF EXISTS `tipo_clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_clase` (
  `idtipo_clase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_clase` varchar(45) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idtipo_clase`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_clase`
--

LOCK TABLES `tipo_clase` WRITE;
/*!40000 ALTER TABLE `tipo_clase` DISABLE KEYS */;
INSERT INTO `tipo_clase` VALUES (1,'Zumba','Ejercicios aeróbicos al ritmo de música latina'),(2,'Yoga','Ejercicios de respiración y meditación para mejorar la salud general'),(3,'Spinning ','Ejercicio aeróbico y cardiovascular que se realiza sobre una bicicleta estática en el que se trabaja el tren inferior: las piernas y los glúteos'),(4,'CrossFit ','Técnica de entrenamiento que conecta movimientos de diferentes disciplinas, tales como la halterofilia, el entrenamiento metabólico o el gimnástico. Consiste en acometer un programa de ejercicios (flexiones, tracción, etc), en un tiempo determinado y con un número definido de veces');
/*!40000 ALTER TABLE `tipo_clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiporutina`
--

DROP TABLE IF EXISTS `tiporutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporutina` (
  `idtipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiporutina`
--

LOCK TABLES `tiporutina` WRITE;
/*!40000 ALTER TABLE `tiporutina` DISABLE KEYS */;
INSERT INTO `tiporutina` VALUES (1,'Sentadillas con barra'),(2,'Flexiones '),(3,'Prensa en máquina'),(4,'Zancada con mancuernas'),(5,'Peso muerto'),(6,' Extensión de gemelos'),(7,'Dominadas'),(8,'Remo sentado'),(10,'Peso muerto rumano'),(11,'Abdominales con  elevaciones de piernas'),(12,'Abdominales crunches'),(13,'Abdominales oblíquos con polea'),(14,'Fondos de tríceps'),(15,'Francés de tríceps barra Z');
/*!40000 ALTER TABLE `tiporutina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `dni` int(11) NOT NULL,
  `contra` varchar(45) NOT NULL,
  `nivel` int(11) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (27456987,'123456',1),(30269528,'123456',1),(30526985,'java',2),(35216633,'123456',1),(35216759,'java',2),(37311851,'java',2),(37316789,'java',2),(40316756,'java',2),(41312036,'java',2),(41316826,'123456',1),(41316836,'java',2),(41316845,'java',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-05 20:16:06
