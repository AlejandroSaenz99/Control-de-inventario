-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-06-2022 a las 15:29:15
-- Versión del servidor: 10.5.12-MariaDB-cll-lve
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `u524173526_MADS`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Descripcion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Costo_Entrada` float NOT NULL,
  `Costo_Promedio_U` float NOT NULL,
  `Stock` float NOT NULL,
  `Entrada` float NOT NULL,
  `Fecha_Ultima_Entrada` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Categoria` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Punto_Reorden` float NOT NULL,
  `Estado` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Unidad_Medida` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`Id`, `Nombre`, `Descripcion`, `Costo_Entrada`, `Costo_Promedio_U`, `Stock`, `Entrada`, `Fecha_Ultima_Entrada`, `Categoria`, `Punto_Reorden`, `Estado`, `Unidad_Medida`) VALUES
(12345, 'Sillon', 'Para Sentarse', 20, 20, 100, 10, '2022-06-02', 'sala', 1, 'Activo', 'Tonelada'),
(23456, 'tv', 'tele', 500, 500, 20, 7, '2022-06-02', 'sala', 1, 'Activo', 'Tonelada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Bitacora`
--

CREATE TABLE `Bitacora` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Descripcion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Costo_Entrada` float DEFAULT NULL,
  `Stock` float NOT NULL,
  `Entrada` float DEFAULT NULL,
  `Fecha_Ultima_Entrada` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Hora` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Estado` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Categoria` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Precio` float DEFAULT NULL,
  `Salida` float DEFAULT NULL,
  `Fecha_Salida` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Costo_Promedio_U` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Categoria`
--

CREATE TABLE `Categoria` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Estado` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `Categoria`
--

INSERT INTO `Categoria` (`Id`, `Nombre`, `Estado`) VALUES
(3, 'Baño', 'Activo'),
(2, 'Cocina', 'Activo'),
(1, 'sala', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DDL`
--

CREATE TABLE `DDL` (
  `Vidas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `InventarioFisico`
--

CREATE TABLE `InventarioFisico` (
  `Numero` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Descripcion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Categoria` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Unidad_Medida` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Cantidad` float NOT NULL,
  `Fecha` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `InventarioFisico`
--

INSERT INTO `InventarioFisico` (`Numero`, `Id`, `Nombre`, `Descripcion`, `Categoria`, `Unidad_Medida`, `Cantidad`, `Fecha`) VALUES
(1, 12345, 'Sillon', 'Para Sentarse', 'sala', 'Tonelada', 100, '06-03-2022'),
(2, 12345, 'Sillon', 'Para Sentarse', 'sala', 'Tonelada', 100, '06-03-2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Motivos`
--

CREATE TABLE `Motivos` (
  `id` int(11) NOT NULL,
  `Articulo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Tipo` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Justificacion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Fecha` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `Motivos`
--

INSERT INTO `Motivos` (`id`, `Articulo`, `Tipo`, `Justificacion`, `Fecha`) VALUES
(3, '12345', 'Sistema', 'sn', '2022-06-03'),
(4, '12345', 'Sistema', 'sin', '2022-06-03'),
(5, '12345', 'Fisico', 'asdsa', '2022-06-03'),
(6, '12345', 'Sistema', 'equis', '2022-06-03'),
(7, '12345', 'Fisico', 'lol', '2022-06-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pueba`
--

CREATE TABLE `pueba` (
  `Id` int(11) NOT NULL,
  `First_Name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Last_Name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Age` float DEFAULT NULL,
  `Date` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Apellidos` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Usuario` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Contraseña` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Tipo` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`id`, `Nombre`, `Apellidos`, `Usuario`, `Contraseña`, `Tipo`) VALUES
(1, 'Jesus Alejandro', 'Saenz Saldivar', 'alex', '7112', 'Administrador'),
(3, 'jesus', 'saenz', 'jesus', '1234', 'Almacenista'),
(4, 'alex', 'saenz', 'saenz', '1', 'Solicitante');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `Bitacora`
--
ALTER TABLE `Bitacora`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`Nombre`);

--
-- Indices de la tabla `InventarioFisico`
--
ALTER TABLE `InventarioFisico`
  ADD PRIMARY KEY (`Numero`,`Id`);

--
-- Indices de la tabla `Motivos`
--
ALTER TABLE `Motivos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pueba`
--
ALTER TABLE `pueba`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32146;

--
-- AUTO_INCREMENT de la tabla `Bitacora`
--
ALTER TABLE `Bitacora`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Motivos`
--
ALTER TABLE `Motivos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pueba`
--
ALTER TABLE `pueba`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
