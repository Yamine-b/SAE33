-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 15 jan. 2023 à 18:46
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sae33`
--

-- --------------------------------------------------------

--
-- Structure de la table `donnee`
--

DROP TABLE IF EXISTS `donnee`;
CREATE TABLE IF NOT EXISTS `donnee` (
  `date` time NOT NULL,
  `Temperature` float NOT NULL,
  `Humidite` float NOT NULL,
  `Luminosite` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `donnee`
--

INSERT INTO `donnee` (`date`, `Temperature`, `Humidite`, `Luminosite`) VALUES
('18:59:56', 20, 48, 868),
('19:00:10', 20.2, 48, 1023),
('19:00:12', 20, 48, 1023),
('19:00:14', 20.2, 48, 1023),
('19:00:16', 20.2, 48, 1023),
('19:00:17', 20.2, 48, 1023),
('19:00:19', 20.2, 48, 1023),
('19:00:21', 20.2, 48, 1023),
('19:00:22', 20.2, 48, 1023),
('19:00:24', 20.2, 48, 1023),
('19:00:32', 20.2, 48, 927),
('19:13:01', 20, 48, 699),
('19:13:31', 20.6, 48, 705),
('19:13:32', 20.6, 48, 962),
('19:21:53', 20.66, 48, 858),
('19:22:11', 20.6, 48, 376),
('19:22:12', 20.6, 48, 867),
('19:30:48', 20.6, 47, 287);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `Login` varchar(100) NOT NULL,
  `Mdp` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`Login`, `Mdp`) VALUES
('yamine', 'test'),
('yamine', 'test'),
('test', 'test'),
('yyy', 't'),
('yyy', 'ttt'),
('yyy', 't'),
('yyy', 't'),
('oui', 't');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
