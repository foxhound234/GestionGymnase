-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 26 nov. 2018 à 15:38
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
-- Base de données :  `gymnase`
--

-- --------------------------------------------------------

--
-- Structure de la table `accueillir`
--

DROP TABLE IF EXISTS `accueillir`;
CREATE TABLE IF NOT EXISTS `accueillir` (
  `refSalle` varchar(5) NOT NULL,
  `nomSportAutorise` varchar(25) NOT NULL,
  PRIMARY KEY (`refSalle`,`nomSportAutorise`),
  KEY `fk2` (`nomSportAutorise`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `accueillir`
--

INSERT INTO `accueillir` (`refSalle`, `nomSportAutorise`) VALUES
('A', 'BasketBall'),
('C', 'BasketBall'),
('A', 'HandBall'),
('C', 'HandBall'),
('A', 'Tennis'),
('B', 'Tennis');

-- --------------------------------------------------------

--
-- Structure de la table `association`
--

DROP TABLE IF EXISTS `association`;
CREATE TABLE IF NOT EXISTS `association` (
  `refAsso` varchar(20) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `nomResponsable` varchar(30) NOT NULL,
  PRIMARY KEY (`refAsso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `association`
--

INSERT INTO `association` (`refAsso`, `ville`, `adresse`, `nomResponsable`) VALUES
('AST', 'Tr?gueux', '12 rue des lilas', 'BENOIT Bertrand'),
('COB', 'Saint Brieuc', '12 Bd Cl?menceau', 'JACQUEMIN J?rome'),
('TCP', 'Pl?rin', '21 rue des peupliers', 'SARMIN Odette'),
('TCSB', 'Saint Brieuc', 'La vall?e du Leff', 'GARCIN Lucie');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `refEmploye` varchar(5) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `sexe` varchar(1) NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `cp` varchar(6) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `tel` varchar(14) NOT NULL,
  PRIMARY KEY (`refEmploye`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pratiquer`
--

DROP TABLE IF EXISTS `pratiquer`;
CREATE TABLE IF NOT EXISTS `pratiquer` (
  `refAsso` varchar(20) NOT NULL,
  `nomSport` varchar(25) NOT NULL,
  PRIMARY KEY (`refAsso`,`nomSport`),
  KEY `fk4` (`nomSport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pratiquer`
--

INSERT INTO `pratiquer` (`refAsso`, `nomSport`) VALUES
('AST', 'BasketBall'),
('COB', 'BasketBall'),
('AST', 'FootBall'),
('COB', 'HandBall'),
('TCP', 'Tennis'),
('TCSB', 'Tennis');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `refSalle` varchar(5) NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `refAsso` varchar(20) NOT NULL,
  PRIMARY KEY (`refSalle`,`date`,`heure`),
  KEY `fk5` (`refAsso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `refSalle` varchar(5) NOT NULL,
  `surface` float NOT NULL,
  `typeRevetement` varchar(30) NOT NULL,
  PRIMARY KEY (`refSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`refSalle`, `surface`, `typeRevetement`) VALUES
('A', 800, 'dur'),
('B', 960, 'souple'),
('C', 880, 'semi dur');

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

DROP TABLE IF EXISTS `sport`;
CREATE TABLE IF NOT EXISTS `sport` (
  `nomSport` varchar(25) NOT NULL,
  PRIMARY KEY (`nomSport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sport`
--

INSERT INTO `sport` (`nomSport`) VALUES
('BasketBall'),
('FootBall'),
('HandBall'),
('Tennis');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `accueillir`
--
ALTER TABLE `accueillir`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`refSalle`) REFERENCES `salle` (`refSalle`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`nomSportAutorise`) REFERENCES `sport` (`nomSport`);

--
-- Contraintes pour la table `pratiquer`
--
ALTER TABLE `pratiquer`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`refAsso`) REFERENCES `association` (`refAsso`),
  ADD CONSTRAINT `fk4` FOREIGN KEY (`nomSport`) REFERENCES `sport` (`nomSport`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`refAsso`) REFERENCES `association` (`refAsso`),
  ADD CONSTRAINT `fk6` FOREIGN KEY (`refSalle`) REFERENCES `salle` (`refSalle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
