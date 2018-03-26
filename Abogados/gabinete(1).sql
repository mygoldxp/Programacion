-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-03-2018 a las 10:11:41
-- Versión del servidor: 5.6.13
-- Versión de PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gabinete`
--
CREATE DATABASE IF NOT EXISTS `gabinete` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gabinete`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abogados`
--

CREATE TABLE IF NOT EXISTS `abogados` (
  `dni` varchar(12) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `ape1` varchar(30) NOT NULL,
  `ape2` varchar(30) NOT NULL,
  `dir` varchar(40) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `abogados`
--

INSERT INTO `abogados` (`dni`, `nombre`, `ape1`, `ape2`, `dir`) VALUES
('11111111Q', 'Jon', 'Jkkk', 'Kkkk', 'Kkkk'),
('22222222Q', 'Qqq', 'Qqq', 'Qqq', 'Qqqq');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abogado_lleva_casos`
--

CREATE TABLE IF NOT EXISTS `abogado_lleva_casos` (
  `Abogado_dni` varchar(12) NOT NULL,
  `Caso_expediente` varchar(5) NOT NULL,
  PRIMARY KEY (`Abogado_dni`,`Caso_expediente`),
  KEY `Caso_expediente` (`Caso_expediente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `abogado_lleva_casos`
--

INSERT INTO `abogado_lleva_casos` (`Abogado_dni`, `Caso_expediente`) VALUES
('11111111Q', '3'),
('22222222Q', '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casos`
--

CREATE TABLE IF NOT EXISTS `casos` (
  `num_exp` varchar(5) NOT NULL,
  `fecha_i` date NOT NULL,
  `fecha_f` date DEFAULT NULL,
  `estado` varchar(1) NOT NULL,
  `Cliente_dni` varchar(12) NOT NULL,
  PRIMARY KEY (`num_exp`),
  KEY `Cliente_dni` (`Cliente_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `casos`
--

INSERT INTO `casos` (`num_exp`, `fecha_i`, `fecha_f`, `estado`, `Cliente_dni`) VALUES
('3', '2018-03-21', '2018-03-21', 'W', '22222222Q'),
('4', '2018-03-21', NULL, 'A', '22222222Q'),
('5', '2018-03-21', NULL, 'Q', '22222222Q');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `dni` varchar(12) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `ape1` varchar(25) NOT NULL,
  `ape2` varchar(25) NOT NULL,
  `dir` varchar(40) NOT NULL,
  `tel` varchar(13) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`dni`, `nombre`, `ape1`, `ape2`, `dir`, `tel`) VALUES
('22222222Q', 'Asdaaaaa', 'Sfrdgdrg', 'Qfrdgdrgdr', 'Aaaaaa', '888888888');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abogado_lleva_casos`
--
ALTER TABLE `abogado_lleva_casos`
  ADD CONSTRAINT `abogado_lleva_casos_ibfk_1` FOREIGN KEY (`Abogado_dni`) REFERENCES `abogados` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `abogado_lleva_casos_ibfk_2` FOREIGN KEY (`Caso_expediente`) REFERENCES `casos` (`num_exp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `casos`
--
ALTER TABLE `casos`
  ADD CONSTRAINT `casos_ibfk_1` FOREIGN KEY (`Cliente_dni`) REFERENCES `clientes` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_casos_Cliente_dni` FOREIGN KEY (`Cliente_dni`) REFERENCES `clientes` (`dni`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
