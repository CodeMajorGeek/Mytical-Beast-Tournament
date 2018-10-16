-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 16 oct. 2018 à 15:57
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tournament`
--

-- --------------------------------------------------------

--
-- Structure de la table `tournament`
--

DROP TABLE IF EXISTS `tournament`;
CREATE TABLE IF NOT EXISTS `tournament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `APIRequestID` int(11) NOT NULL,
  `TourneyID` varchar(255) NOT NULL,
  `APIFrameworkTime` varchar(255) NOT NULL,
  `APITotalTime` varchar(255) NOT NULL,
  `APIServiceTime` varchar(255) NOT NULL,
  `URL` varchar(255) NOT NULL,
  `Result` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tournament`
--

INSERT INTO `tournament` (`id`, `Title`, `APIRequestID`, `TourneyID`, `APIFrameworkTime`, `APITotalTime`, `APIServiceTime`, `URL`, `Result`) VALUES
(1, 'test', 5846304, 'xSC21810164', '1.04ms', '20.14ms', '19.1ms', 'http://binarybeast.com/xSC21810164', 200),
(2, 'test', 5846305, 'xSC21810165', '0.687ms', '21.27ms', '20.583ms', 'http://binarybeast.com/xSC21810165', 200),
(3, 'test', 5846365, 'xSC21810166', '1.051ms', '17.139ms', '16.088ms', 'http://binarybeast.com/xSC21810166', 200);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
