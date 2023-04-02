-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.11.2-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Exportiere Datenbank Struktur für ld_kern_db
CREATE DATABASE IF NOT EXISTS `ld_kern_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ COMMENT 'DB für LD kernbohrung';
USE `ld_kern_db`;

-- Exportiere Struktur von Tabelle ld_kern_db.auftrag
CREATE TABLE IF NOT EXISTS `auftrag` (
  `Auftrags_id` int(11) NOT NULL AUTO_INCREMENT,
  `Durchmeser` int(11) NOT NULL,
  `Tiefe` int(11) NOT NULL,
  `Datum` date DEFAULT NULL,
  `Kommentar` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`Auftrags_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle ld_kern_db.kunden_tabelle
CREATE TABLE IF NOT EXISTS `kunden_tabelle` (
  `Kunden_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Adresse` varchar(50) DEFAULT NULL,
  `rabat` int(11) DEFAULT NULL,
  PRIMARY KEY (`Kunden_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle ld_kern_db.rechnungs_tabelle
CREATE TABLE IF NOT EXISTS `rechnungs_tabelle` (
  `Rechnungs_id` int(11) NOT NULL AUTO_INCREMENT,
  `Kunden_id` int(11) NOT NULL,
  `Auftrags_id` int(11) NOT NULL DEFAULT 0,
  `RechnungBetrag` float NOT NULL DEFAULT 0,
  `Datum` date DEFAULT NULL,
  PRIMARY KEY (`Rechnungs_id`),
  UNIQUE KEY `Kunden_id` (`Kunden_id`),
  UNIQUE KEY `Auftrags_id` (`Auftrags_id`),
  CONSTRAINT `Auftrag` FOREIGN KEY (`Auftrags_id`) REFERENCES `auftrag` (`Auftrags_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Kunden_id` FOREIGN KEY (`Kunden_id`) REFERENCES `kunden_tabelle` (`Kunden_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Daten Export vom Benutzer nicht ausgewählt

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
