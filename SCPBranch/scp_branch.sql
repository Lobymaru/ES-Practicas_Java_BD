-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2022 at 10:55 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scp_branch`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE `assignments` (
  `SCP` int(5) NOT NULL,
  `Empleado` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assignments`
--

INSERT INTO `assignments` (`SCP`, `Empleado`) VALUES
(1036, 1551),
(2000, 1551),
(1036, 2554);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Id` int(5) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Clase` enum('A','B','C','D','E') NOT NULL,
  `Nivel_seguridad` enum('0','1','2','3','4','5') NOT NULL,
  `Jefe` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Id`, `Nombre`, `Apellido`, `Clase`, `Nivel_seguridad`, `Jefe`) VALUES
(1551, 'Christopher', 'Zartion', 'C', '4', 2554),
(2554, 'Tomas', 'Cont', 'C', '3', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee_actor`
--

CREATE TABLE `employee_actor` (
  `Id-empleado` int(5) NOT NULL,
  `Id-reporte` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `Id` varchar(25) NOT NULL,
  `Fecha` date NOT NULL DEFAULT current_timestamp(),
  `Incidente` varchar(2000) NOT NULL,
  `Resolucion` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`Id`, `Fecha`, `Incidente`, `Resolucion`) VALUES
('NoFuncionaT.T', '2022-11-28', 'Tengo problemas para insertar elementos en las tablas de actores debido a supuestas restricciones de las claves foraneas, lo peor es que debe ser una boludez', 'Nada, esa parte me queda incompleta pese a que si me sale en la parte de asignaciones... es lo que hay me temo');

-- --------------------------------------------------------

--
-- Table structure for table `scp`
--

CREATE TABLE `scp` (
  `Id` int(5) NOT NULL,
  `Apodo` varchar(20) DEFAULT NULL,
  `Clase` enum('Seguro','Euclid','Keter','Taumiel','Neutralizado','Apollyon','Archon') NOT NULL,
  `Subclase` enum('Explicado','Esoterico','Desmantelado') NOT NULL,
  `Descripcion` text DEFAULT NULL,
  `Instrucciones-contencion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scp`
--

INSERT INTO `scp` (`Id`, `Apodo`, `Clase`, `Subclase`, `Descripcion`, `Instrucciones-contencion`) VALUES
(1036, 'Nikondi', 'Euclid', 'Explicado', 'SCP-1036 designa a cualquiera de una colección de figuras de madera de un tipo consistente con objetos fetiche producidos por la cultura Kongo de África central occidental. La Fundación contiene actualmente cuatro especímenes de SCP-1036, designados SCP-1036-1, SCP-1036-5, SCP-1036-6 y SCP-1036-7.\r\n\r\nCada figura representa una forma humana (o, en algunos casos, una forma animal), típicamente representada en una postura amenazante. Cada espécimen está compuesto de madera tropical africana y decorado con materiales como polvo de sándalo rojo, resinas y fibra vegetal como hojas de palma de rafia. Cada espécimen incluye un componente (típicamente los ojos o el abdomen) hecho de metal brillante o reflectante como la plata pulida, fijado al espécimen con goma de árbol. Los especímenes contienen trazas de tierra que coinciden con ciertos sitios funerarios de la región de ██████. Se han clavado varios clavos de hierro en la madera de cada espécimen.\r\n\r\nCada espécimen está ligeramente tibio al tacto. Los análisis indican que los especímenes normalmente tienen una temperatura superficial que excede la temperatura ambiente en la cámara de contención en cuatro a ocho grados centígrados; sin embargo, el registro de observación 1036-986-B.233 indicó que inmediatamente antes del evento Kalazima-1, la temperatura superficial de SCP-1036-3 se elevó en al menos noventa grados centígrados en menos de cuatro segundos antes de que la observación fuera interrumpida.\r\n\r\nCada espécimen se asocia con una entidad incorpórea sensible que se había unido a su espécimen respectivo, antes de que la Fundación adquiriera el espécimen en cuestión, por medio de una práctica ritual chamánica tradicional del Kongo. Cada uno de los especímenes bajo custodia de la Fundación se construyó (incluyendo el cumplimiento del protocolo vinculante) no más recientemente que a mediados de la década de 1870.1 Mientras se mantenga la integridad de su respectivo espécimen SCP-1036, la entidad es incapaz de actuar libremente, aparte de comunicarse con un nganga o interactuar con una criatura viviente que hace contacto visual con el espécimen. Los especímenes SCP-1036 fueron construidos por los indígenas nganga con el fin de aplicar los poderes de la entidad vinculada para varios propósitos útiles, pero se ha perdido el conocimiento del protocolo para hacerlo; por lo tanto, los esfuerzos de la Fundación con respecto a SCP-1036 se han centrado en la contención.', 'Cada espécimen SCP-1036 debe estar contenido en un receptáculo de hierro fundido cerrado en un ambiente de baja humedad, para retardar la oxidación del receptáculo y de los clavos. En todo momento, cada espécimen debe ser manipulado cuidadosamente para minimizar la probabilidad de que se desprenda cualquier clavo del espécimen. Si la inspección de cualquier espécimen denota el riesgo de que un clavo se desprenda, consulte el documento 1036-3P.BR para conocer los protocolos de restauración.\r\n\r\nA intervalos regulares (el tiempo es calculado por el nganga (chamán) del Sitio-06 basado en observaciones astronómicas), el nganga debe fijar a cada espécimen al menos un clavo de hierro adicional que tenga una masa superior a ocho gramos.\r\n\r\nSi por alguna razón fuera necesario que personal que no sea el nganga entre en presencia de un espécimen, se recomienda que el nganga cubra primero los ojos u otros componentes reflectantes del espécimen con cinta aislante o con algún otro recubrimiento opaco.'),
(2000, 'Deus Ex Machina', 'Taumiel', 'Explicado', 'SCP-2000 es una instalación subterránea de la Fundación originalmente construida en algún momento en los últimos ███ años con el propósito de reconstruir la civilización en el caso que un escenario de fin-del-mundo de Clase-K no pueda ser evitado a tiempo para prevenir la extinción o cuasi-extinción de la humanidad. Desde su creación, SCP-2000 ha sido activado al menos dos veces. Los registros de la Fundación respecto a la construcción e historia de SCP-2000 antes de este supuesto primer uso se han perdido. Si esta pérdida de información es resultado de un accidente o fue deliberado es imposible de determinar. La porción fundamental de esta instalación comienza a 75 m bajo el nivel de suelo y se extiende hasta 100 m de profundidad.\r\n\r\nAunque el alcance de la ingeniería necesaria para recrear a SCP-2000 en su totalidad es imposible mientras se mantiene en secreto, todos los sub-sistemas de SCP-2000 se han reproducido con éxito en entornos de laboratorio; la instalación y todos los procedimientos implicados en su mantenimiento son mundanos en la naturaleza. (Véase Documento 2000-SS-EX para información relacionada con tecnologías esotéricas de la Fundación necesarias para el funcionamiento de SCP-2000). La fuente primaria de energía para la instalación es un Reactor Líquido de Fluoruro de Torio (Liquid Fluoride Thorium Reactor; LTFR) medido en 1 GW su salida total, con una vida útil de 70 años a máxima capacidad. Un generador geotérmico se ha instalado también para tomar ventaja de la actividad volcánica de la región. Este generador es capaz de dar potencia a la instalación en modo “stand-by” indefinidamente. SCP-2000 también contiene plantas de tratamiento de agua, sistemas de purificación de aire y reciclaje, alas de producción hidropónica y viviendas necesarias para sostener en forma permanente hasta 10,000 efectivos.\r\n\r\nPara cumplir con su misión principal, SCP-2000 incluye 500,000 Replicadores Homínidos de Bright/Zartion (Bright/Zartion Hominid Replicators; BZHR). En su máxima capacidad, SCP-2000 es capaz de producir 100,000 humanos viables no-anómalos por día (con un período de incubación de 5 días). Utilizando un tubo de transporte Riemanniano subterráneo para recoger materia prima de varios manantiales de agua caliente y magma subterráneo que fluye en la zona, y un banco de memoria de ordenador, almacenando datos de todos los alelos humanos conocidos, este sistema es capaz de recrear cualquier genoma humano perdido o generar nuevos y únicos genomas necesarios para repoblar la civilización humana.\r\nLos humanos producidos por este proceso pueden ser avanzados a cualquier edad deseada sin extender el período de incubación de 5 días. Además de las características de su construcción, el BZHR también tiene la capacidad de implantar recuerdos mediante la administración de alucinógenos Clase-G e hipnoterapia en desarrollo. Historias de vida, escáneres de arquetipos neuronales, y genomas de gran parte del Personal de la Fundación – incluyendo a todo el personal de Nivel de Autorización 4/2000 o superior – son mantenidos para asegurarse de que SCP-2000 pueda ser activado y el Procedimiento Lázaro-01 pueda ser iniciado mientras haya al menos un sólo humano sobreviviente.\r\n\r\nLuego de la implementación del Protocolo Ganímedes (indicando un fallo de la Fundación para prevenir un escenario de Clase-K), los sistemas de seguridad de SCP-2000 se desbloquearán, permitiendo a cualquier empleado de la Fundación iniciar el Procedimiento CYA-009. Si, luego de 20 años, SCP-2000 permanece inactivo, la seguridad se reducirá más, permitiendo a cualquier humano no-anómalo el acceso a la instalación e iniciar el procedimiento. Una vez activado, los sistemas de monitoreo interno de SCP-2000 intentarán localizar a todo el Personal con Nivel de Autorización 4/2000 y evaluar su estado. El personal primordial no encontrado será replicado utilizando el escáner de arquetipo neuronal en archivo, y despertado antes de la inicialización de los demás sistemas.\r\n\r\nUna vez este personal sea revivido, los bloqueos de seguridad regresarán a sus funciones normales. Para obtener una lista completa de las opciones de contingencia, el Personal de Nivel 5/2000 puede acceder al Documento 2000-CYA-09. Tenga en cuenta que la recepción del código \"Despejado\", como se define en el Documento 2000XKAC-1.9 sólo puede ceder si el resto de instalaciones de la Fundación se han vuelto inutilizables. De lo contrario, los elementos de Seguridad y Destacamentos Móviles revividos bajo el Procedimiento CYA-009 serán despachados a todas las instalaciones de la Fundación restantes para confirmar su función y la integridad de la realidad local.\r\n\r\nEl Procedimiento Lázaro-01 comenzará cuando un empleado con Autorización de Nivel 5/2000 ingrese la “Fecha de Recuperación” deseada dentro de la unidad de control BZHR de SCP-2000. Las unidades disponibles comenzarán la producción de líderes culturales y políticos prominentes de ese período de tiempo utilizando información descriptiva/genética en archivo, así como replicación de la población global consistente con el período escogido. Gran parte del espacio de suelo de SCP-2000 está dedicado al almacenamiento de materiales y equipos de construcción, maquinarias de fábrica, equipo de agricultura y bases de datos computacionales. Además de preocupaciones sobre la infraestructura, un gran base cultural con copias de miles de obras de arte, música, literatura, y un respaldo completo de la World Wide Web está almacenada in situ en caso de que otros repositorios sean destruidos.\r\n\r\nLos primeros seres humanos de repuesto alojados fuera del sitio deben necesariamente ser informados de la existencia y la función de SCP-2000, mientras se están creando. Esta estrategia permite a los seres humanos construidos ayudar en los esfuerzos de reconstrucción y de recolonización directamente, y el conjunto de habilidades adecuadas para la reconstrucción ha sido preseleccionado para aumentar la prevalencia en los primeros 5 millones de individuos producidos. Mientras la población global se incrementa, el proceso de diáspora y de reconstrucción se acelerará geométricamente, permitiendo a la infraestructura de agricultura y economía recuperarse tan rápido como sea posible.\r\n\r\nSi bien es posible el que algunos humanos de reemplazo no sobrevivirán el período de renovación inicial, estas personas pueden ser recreadas de forma indefinida hasta que se hayan completado todos los principales centros de población y las instalaciones de la Fundación. Activos administrativos de la Fundación durante este período se centrarán en la falsificación de los registros de citas dendrocronológicas, astronómicas, y radiométricas necesarias para mantener la apariencia de continuidad histórica. Favor ver el Documento 2000-RetCon v 2.3.3 para más detalles. En el caso de que una parte significativa de hábitats naturales también estén destruidos antes de la finalización del proyecto, refiérase al Documento 2000-OneTear v 3.0 para métodos de rebrote rápido aprobados.\r\n\r\nSe estima que la población mundial, la capacidad de fabricación, la producción agrícola, y la cultura se pueden restablecer a los niveles del 2000 d.C., 25 a 50 años en adelante después de implementado el procedimiento. Al término del Procedimiento Lázaro-01, el agente amnésico ENUI-5 será liberado en masa, haciendo que todos los seres humanos reconstruidos olviden su afiliación con los activos de la Fundación. La historia entonces se reanudará desde la fecha escogida. Cada proceso necesariamente alterará el curso de los eventos humanos debido a la gran complejidad de la interacción social humana. La investigación adicional en el modelado predictivo histórico basado en las observaciones de las terminaciones anteriores del Procedimiento Lázaro-01 está en curso.', 'La entrada a SCP-2000 está camuflada como una estación del Parque Ranger en desuso en el Parque Nacional Yellowstone. A pesar de varios intentos de invasión civil, la entrada aún no se ha vulnerado en la historia registrada de la instalación, y ninguna contención física ha sido considerada necesaria. El Protocolo Plainsight-201 está en efecto para SCP-2000. Los suministros necesarios y el personal de reemplazo pueden ser despachados a través de vehículos de carretera sin marcas o helicópteros civiles, según corresponda.\r\n\r\nNingún miembro de personal por debajo del Nivel de Autorización 4/2000 tiene permitido el acceso a la documentación respecto a SCP-2000, o a cualquier protocolo asociado con su contención y mantenimiento. Ningún miembro de personal con Nivel de Autorización inferior a 5/2000 tendrá el acceso permitido a SCP-2000 debajo del Sub-Nivel 3. Todo el personal asignado a SCP-2000 debe someterse a escaneo de arquetipo neuronal cada mes. Personal en terreno deberá someterse a un análisis semanal, los cuales serán almacenados localmente.\r\n\r\nEl personal de Nivel 4/2000 o superior en terreno no tendrá permitido abandonar el Parque Nacional Yellowstone durante el curso de su misión. En caso de traslado (ya sea electivo u obligatorio), se administrarán amnésicos de Clase A, y se implantarán falsos recuerdos consistentes con asignación a otros SCP de alta seguridad o de clase Keter. Personal adicional puede ser asignado a SCP-2000 y se le concederá Nivel de Autorización 4/2000 temporal a discreción del supervisor CCMP (actualmente Dr. Charles Gears) y Comando del O5.\r\n\r\nLa superficie exterior de SCP-2000 está rodeada por Anclas de Realidad Scranton (Scranton Reality Anchors, SRAs) cada 20 m, dispuestas hexagonalmente, para evitar incursión de interferencia anómala hostil. Cada funcionalidad de los SRA debe ser comprobada semi-anualmente y deben ser reemplazados si es necesario. Los técnicos de mantenimiento de componentes SRA pueden hacer referencia al Documento SRA-033, rev 1.0.7. Cinco (5) Sumideros Temporales Constantes de Xyank/Anastasakos (Xyank/Anastasakos Constant Temporal Sinks; XACTS) capaz de mantener el flujo de taquiones estable en toda la extensión de la instalación (máxima potencia de salida: 100 W cada uno) están instalados y deben ser mantenidos mensualmente. Los técnicos de mantenimiento de componentes XACTS pueden hacer referencia al Documento XACTS-864, rev 1.3.0.\r\n\r\nUna Variable Pseudo-Riemanniana ha sido iniciada en la entrada del Sub-Nivel 4, y debe permanecer abierta en todo momento. En caso de falla de la variable, se deberá ejecutar el Procedimiento Dead Euclid-101 inmediatamente. Otros sistemas de soporte vital no anómalo y de servicios públicos pueden ser mantenidos de acuerdo con el Protocolo de mantenimiento estándar de la Fundación, Sección 101.5 (Componentes de Misión Crítica). Siempre que sea posible, materiales y recursos no anómalos deben utilizarse para el mantenimiento y reparación de SCP-2000.\r\n\r\nEn caso de un escenario de Clase-K que no ponga en peligro la existencia o la funcionalidad de SCP-2000, se ha de promulgar el Procedimiento CYA-009 lo antes posible. El resto de las instalaciones de la Fundación en todo el mundo estarán vigilando la situación a medida que se desarrolla, preservando todos los recursos materiales posibles en el marco del Protocolo Ganímedes hasta el momento en que todos los sitios restantes respondan \"Despejado\" respecto de SCP-2000 como está definido en el Documento 2000XKAC-1.9. Tras la recepción del código “Despejado”, se implementará el Procedimiento Lázaro-01.');

-- --------------------------------------------------------

--
-- Table structure for table `scp_actor`
--

CREATE TABLE `scp_actor` (
  `Id-scp` int(5) NOT NULL,
  `Id-reporte` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD KEY `FK_scp-asignado_SCP` (`SCP`),
  ADD KEY `FK_empleado-asignado-Employe` (`Empleado`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Jefe-Empleado` (`Jefe`);

--
-- Indexes for table `employee_actor`
--
ALTER TABLE `employee_actor`
  ADD KEY `Id-reporte` (`Id-reporte`),
  ADD KEY `employee_actor_ibfk_1` (`Id-empleado`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `scp`
--
ALTER TABLE `scp`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `scp_actor`
--
ALTER TABLE `scp_actor`
  ADD KEY `FK_ID-reporte-scp_Report` (`Id-scp`),
  ADD KEY `FK_Id-reporte_Report` (`Id-reporte`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `FK_empleado-asignado-Employe` FOREIGN KEY (`Empleado`) REFERENCES `employee` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_scp-asignado_SCP` FOREIGN KEY (`SCP`) REFERENCES `scp` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK_Jefe-Empleado` FOREIGN KEY (`Jefe`) REFERENCES `employee` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `employee_actor`
--
ALTER TABLE `employee_actor`
  ADD CONSTRAINT `FK_ID-reporte-employee_Report` FOREIGN KEY (`Id-reporte`) REFERENCES `report` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_actor_ibfk_1` FOREIGN KEY (`Id-empleado`) REFERENCES `employee` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `scp_actor`
--
ALTER TABLE `scp_actor`
  ADD CONSTRAINT `FK_ID-reporte-scp_Report` FOREIGN KEY (`Id-scp`) REFERENCES `scp` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Id-reporte_Report` FOREIGN KEY (`Id-reporte`) REFERENCES `report` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
