-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 23-05-2024 a las 16:29:24
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `muebleria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abonos`
--

DROP TABLE IF EXISTS `abonos`;
CREATE TABLE IF NOT EXISTS `abonos` (
  `id_abono` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_datosTransaccion` int NOT NULL,
  `id_usuario` int NOT NULL,
  `fecha_abono` date NOT NULL,
  `monto_abono` decimal(20,0) NOT NULL,
  PRIMARY KEY (`id_abono`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `abonos`
--

INSERT INTO `abonos` (`id_abono`, `id_cliente`, `id_datosTransaccion`, `id_usuario`, `fecha_abono`, `monto_abono`) VALUES
(1, 3, 2, 2, '2024-05-12', 400),
(2, 4, 3, 3, '2024-05-12', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

DROP TABLE IF EXISTS `articulos`;
CREATE TABLE IF NOT EXISTS `articulos` (
  `id_articulo` int NOT NULL AUTO_INCREMENT,
  `id_categoria` int NOT NULL,
  `nombre_articulo` varchar(70) NOT NULL,
  `descripcion_articulo` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `condicion_articulo` varchar(50) NOT NULL,
  `color_articulo` varchar(20) NOT NULL,
  `precio_articulo` double(10,2) NOT NULL,
  `stock_articulo` int NOT NULL,
  PRIMARY KEY (`id_articulo`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`id_articulo`, `id_categoria`, `nombre_articulo`, `descripcion_articulo`, `condicion_articulo`, `color_articulo`, `precio_articulo`, `stock_articulo`) VALUES
(1, 3, 'Colchon basicos', 'Matrimonial de resortes', 'Sin garantia', 'Rayado', 1000.00, 4),
(2, 1, 'Colchon basico', 'Individual de resortes', 'Sin garantia', 'Rayado', 990.00, 26),
(3, 2, 'Cama gardenia', 'Cama matrimonial con tambor tubular', 'Matrimonial', 'Vino', 1850.00, 7),
(4, 2, 'Cama gardenia', 'Cama con tambor tubular', 'Individual', 'Vino', 1850.00, 4),
(5, 3, 'Base de vinil', 'Base de madera tapizada de vinil', 'Matrimonial', 'Chocolate', 1200.00, 8),
(7, 5, 'Tokio', '3 piezas', 'Garantia sobre reparacion', 'Gris', 7990.00, 1),
(8, 12, 'Michoacana', 'Una pieza', 'Sin garantia', 'Chocolate', 4500.00, 0),
(9, 10, 'Librero popeye', '2 piezas-60\"', 'Sin garantia', 'Chocolate', 3490.00, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `categoria`) VALUES
(1, 'Colchones'),
(2, 'Camas'),
(3, 'Bases'),
(4, 'Comedores 1'),
(5, 'Salas'),
(6, 'Recamaras'),
(7, 'Roperos'),
(8, 'Comodas'),
(9, 'Tocadores'),
(10, 'Centros de entretenimiento'),
(11, 'Alacenas'),
(12, 'Vitrinas'),
(13, 'Linea blanca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(50) NOT NULL,
  `apellidos_cliente` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefono_cliente` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `colonia_cliente` varchar(30) NOT NULL,
  `calle_cliente` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numero_ext_cliente` varchar(10) NOT NULL,
  `codigo_postal_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre_cliente`, `apellidos_cliente`, `telefono_cliente`, `colonia_cliente`, `calle_cliente`, `numero_ext_cliente`, `codigo_postal_cliente`) VALUES
(1, 'Angelica', 'Guerrero', '7714378192', 'Apepelco', 'Las Granjas', '4', '42180'),
(2, 'Fernando', 'Montes Hernandez', '7712431729', 'Militar', 'Venustiano Carranza', '6', '404200'),
(3, 'Noel', 'Bautista', '771268319', 'Bosques', 'Los bosques', '4', '21893'),
(4, 'Cristian', 'Cordova', '771246892', 'Providencia', 'La provincia', '3', '14214');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_transaccion`
--

DROP TABLE IF EXISTS `datos_transaccion`;
CREATE TABLE IF NOT EXISTS `datos_transaccion` (
  `id_datosTransaccion` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_cliente` int NOT NULL,
  `fecha_transaccion` date NOT NULL,
  `importe_total` double(10,2) NOT NULL,
  `aCuenta` double(10,2) NOT NULL,
  `valorPagar` double(10,2) NOT NULL,
  `tipo_transaccion` varchar(20) NOT NULL,
  `condicion_transaccion` varchar(40) NOT NULL,
  PRIMARY KEY (`id_datosTransaccion`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `datos_transaccion`
--

INSERT INTO `datos_transaccion` (`id_datosTransaccion`, `id_usuario`, `id_cliente`, `fecha_transaccion`, `importe_total`, `aCuenta`, `valorPagar`, `tipo_transaccion`, `condicion_transaccion`) VALUES
(1, 2, 1, '2024-05-12', 990.00, 900.00, 90.00, 'Venta', '2 dias'),
(2, 2, 3, '2024-05-12', 2840.00, 300.00, 2140.00, 'Apartado', '3 meses'),
(3, 5, 4, '2024-05-12', 3490.00, 400.00, 0.00, 'Apartado', '2 meses');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liquidaciones`
--

DROP TABLE IF EXISTS `liquidaciones`;
CREATE TABLE IF NOT EXISTS `liquidaciones` (
  `id_cliente` int NOT NULL,
  `id_datosTransaccion` int NOT NULL,
  `Id_usuario` int NOT NULL,
  `fecha_liquidacion` date NOT NULL,
  `monto_liquidacion` decimal(20,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `liquidaciones`
--

INSERT INTO `liquidaciones` (`id_cliente`, `id_datosTransaccion`, `Id_usuario`, `fecha_liquidacion`, `monto_liquidacion`) VALUES
(4, 3, 2, '2024-05-12', 2890.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE IF NOT EXISTS `transacciones` (
  `id_transaccion` int NOT NULL AUTO_INCREMENT,
  `id_datosTransaccion` int NOT NULL,
  `id_articulo` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(20,2) NOT NULL,
  `importe` decimal(20,2) NOT NULL,
  `metodo_pago` varchar(30) NOT NULL,
  PRIMARY KEY (`id_transaccion`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `transacciones`
--

INSERT INTO `transacciones` (`id_transaccion`, `id_datosTransaccion`, `id_articulo`, `cantidad`, `precio_unitario`, `importe`, `metodo_pago`) VALUES
(1, 1, 2, 1, 990.00, 990.00, 'Efectivo'),
(2, 2, 3, 1, 1850.00, 1850.00, 'Con tarjeta'),
(3, 2, 2, 1, 990.00, 990.00, 'Con tarjeta'),
(4, 3, 9, 1, 3490.00, 3490.00, 'Efectivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apellidos_usuario` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefono_usuario` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password_usuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rol_usuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id_usuario`, `nombre_usuario`, `apellidos_usuario`, `telefono_usuario`, `password_usuario`, `rol_usuario`) VALUES
(1, 'Angelica', 'Guerrero', '7713565104', 'uno', 'Empleado'),
(2, 'Liz', 'San Agustin Garcia', '7714441419', 'hola', 'Empleado'),
(3, 'Juan', 'Lopez', '127817331', 'juan1', 'Cargador'),
(5, 'Daniela', 'Gallardo', '771273913', '1234', 'Cargador');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
