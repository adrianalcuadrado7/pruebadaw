-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.6-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bd_votaciones
DROP DATABASE IF EXISTS `bd_votaciones`;
CREATE DATABASE IF NOT EXISTS `bd_votaciones` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_votaciones`;

-- Volcando estructura para tabla bd_votaciones.candidatos
DROP TABLE IF EXISTS `candidatos`;
CREATE TABLE IF NOT EXISTS `candidatos` (
  `id_candidato` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_apellidos` varchar(50) NOT NULL,
  `orden` int(11) NOT NULL DEFAULT 0,
  `id_partido` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_candidato`),
  KEY `FK_candidatos_partidos` (`id_partido`),
  CONSTRAINT `FK_candidatos_partidos` FOREIGN KEY (`id_partido`) REFERENCES `partidos` (`id_partidos`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones.candidatos: ~20 rows (aproximadamente)
DELETE FROM `candidatos`;
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
INSERT INTO `candidatos` (`id_candidato`, `nombre_apellidos`, `orden`, `id_partido`) VALUES
	(1, 'Carmen Navarro Lacoba', 1, 1),
	(2, 'Manuel Serrano López', 2, 1),
	(3, 'Manuel Serena  Fernández', 3, 1),
	(4, 'Cristina García Martínez', 4, 1),
	(5, 'Manuel Gabriel González Ramos', 1, 2),
	(6, 'María Luisa Vilches Ruiz', 2, 2),
	(7, 'José Carlos Díaz Rodríguez', 3, 2),
	(8, 'Estefanía Escribano Villena', 4, 2),
	(9, 'María Dolores Arteaga Espinosa de los Monteros', 1, 4),
	(10, 'Hugo Gabriel Guillen Malagón', 2, 4),
	(11, 'Ana Isabel Martínez Molina', 3, 4),
	(12, 'Cristian Cuerda González', 4, 4),
	(13, 'María Pérez Segovia', 1, 3),
	(14, 'Emilio Zamora Martínez', 2, 3),
	(15, 'Darcy Gioconda Cárdenas Barrera', 3, 3),
	(16, 'Sergio León Bullón', 4, 3),
	(17, 'Rafael Fernández-Lomana Gutiérrez', 1, 5),
	(18, 'Juan Francisco Robles Descalzo', 2, 5),
	(19, 'María Remedios Gil Martínez', 3, 5),
	(20, 'María Teresa Fernández Lara', 4, 5);
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votaciones.informacion
DROP TABLE IF EXISTS `informacion`;
CREATE TABLE IF NOT EXISTS `informacion` (
  `id_informacion` int(11) NOT NULL AUTO_INCREMENT,
  `circunscripcion` varchar(50) NOT NULL,
  `candidato_elegir` int(11) NOT NULL,
  `tipo_consulta` varchar(50) NOT NULL,
  `fecha_consulta` date NOT NULL,
  `estado_escrutinio` enum('cerrado','abierto','finalizado') NOT NULL,
  PRIMARY KEY (`id_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones.informacion: ~0 rows (aproximadamente)
DELETE FROM `informacion`;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` (`id_informacion`, `circunscripcion`, `candidato_elegir`, `tipo_consulta`, `fecha_consulta`, `estado_escrutinio`) VALUES
	(1, 'Albacete', 4, 'Elecciones Generales 10N', '2019-11-19', 'cerrado');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votaciones.partidos
DROP TABLE IF EXISTS `partidos`;
CREATE TABLE IF NOT EXISTS `partidos` (
  `id_partidos` int(11) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(50) NOT NULL,
  `siglas` varchar(50) NOT NULL,
  `logo` varchar(200) NOT NULL,
  `votos` int(255) NOT NULL,
  PRIMARY KEY (`id_partidos`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones.partidos: ~5 rows (aproximadamente)
DELETE FROM `partidos`;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` (`id_partidos`, `denominacion`, `siglas`, `logo`, `votos`) VALUES
	(1, 'Partido socialista obrero español', 'PSOE', 'psoe.jpg', 27074),
	(2, 'Partido popular', 'PP', 'pp.png', 26588),
	(3, 'Unidas podemos', 'UP', 'podemos.png', 10219),
	(4, 'Ciudadanos', 'Cs', 'ciudadanos.png', 8711),
	(5, 'Vox', 'VOX', 'vox.png', 20478);
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votaciones.votante
DROP TABLE IF EXISTS `votante`;
CREATE TABLE IF NOT EXISTS `votante` (
  `id_votante` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(50) NOT NULL,
  `password` varbinary(16) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `domicilio` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `votado` enum('N','S') NOT NULL,
  `rol` varchar(50) NOT NULL,
  PRIMARY KEY (`id_votante`),
  UNIQUE KEY `nif` (`nif`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones.votante: ~0 rows (aproximadamente)
DELETE FROM `votante`;
/*!40000 ALTER TABLE `votante` DISABLE KEYS */;
INSERT INTO `votante` (`id_votante`, `nif`, `password`, `nombre`, `apellidos`, `domicilio`, `fecha_nac`, `votado`, `rol`) VALUES
	(2, '1111', _binary 0x6EF37049BE49B9BD4EDCC1D72899A38D, 'adrian', 'Rodriguez Morote', 'Concejal Castillo', '1999-07-30', 'N', 'votante');
/*!40000 ALTER TABLE `votante` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
