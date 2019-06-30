-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema turismo_loja
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema turismo_loja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `turismo_loja` DEFAULT CHARACTER SET utf8 ;
USE `turismo_loja` ;

-- -----------------------------------------------------
-- Table `turismo_loja`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `names` VARCHAR(65) NOT NULL,
  `lastNames` VARCHAR(65) NOT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `numberPhone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turismo_loja`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Category` (
  `idCat` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NULL,
  PRIMARY KEY (`idCat`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turismo_loja`.`Place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Place` (
  `idPlace` INT NOT NULL AUTO_INCREMENT,
  `principalStreet` VARCHAR(45) NULL,
  `secondaryStreet` VARCHAR(45) NULL,
  `reference` VARCHAR(45) NULL,
  `neighborhood` VARCHAR(45) NULL,
  PRIMARY KEY (`idPlace`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turismo_loja`.`State`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`State` (
  `idState` INT NOT NULL AUTO_INCREMENT,
  `state` INT(1) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idState`, `state`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turismo_loja`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turismo_loja`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Event` (
  `idEvent` INT NOT NULL AUTO_INCREMENT,
  `nameEvent` VARCHAR(45) NOT NULL,
  `cost` DOUBLE NULL,
  `date` DATE NULL,
  `hour` VARCHAR(2) NULL,
  `minutes` VARCHAR(2) NULL,
  `description` VARCHAR(200) NULL,
  `idCat` INT NOT NULL,
  `idPlace` INT NOT NULL,
  `idClient` INT NOT NULL,
  `idState` INT NOT NULL,
  `idAdmin` INT NOT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_Event_Category_idx` (`idCat` ASC),
  INDEX `fk_Event_Place1_idx` (`idPlace` ASC),
  INDEX `fk_Event_Client1_idx` (`idClient` ASC),
  INDEX `fk_Event_State1_idx` (`idState` ASC),
  INDEX `fk_Event_Admin1_idx` (`idAdmin` ASC),
  CONSTRAINT `fk_Event_Category`
    FOREIGN KEY (`idCat`)
    REFERENCES `turismo_loja`.`Category` (`idCat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Place1`
    FOREIGN KEY (`idPlace`)
    REFERENCES `turismo_loja`.`Place` (`idPlace`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Client1`
    FOREIGN KEY (`idClient`)
    REFERENCES `turismo_loja`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_State1`
    FOREIGN KEY (`idState`)
    REFERENCES `turismo_loja`.`State` (`idState`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Admin1`
    FOREIGN KEY (`idAdmin`)
    REFERENCES `turismo_loja`.`Admin` (`idAdmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `turismo_loja`.`admin` (`user`, `password`) VALUES ('user', 'user');

INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Religioso');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Deportivo');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Cultural');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Artistico');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Festival');

INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1101', '1101', 'Carlos', 'Castillo', 'cc@utpl.edu.ec', '0901');
INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1102', '1102', 'Renato', 'Balcazar', 'rb@utpl.edu.ec', '0902');

INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('1', 'Revision');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('2', 'Aprobado');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('3', 'Rechazado');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('4', 'Finalizado');

INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `neighborhood`) VALUES ('Mercadillo', 'Lourdes', 'Estadio \"Reina del Cisne\"', '24 de Mayo');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `neighborhood`) VALUES ('Alejo Garcia', 'Diego de Rojas', 'Frente a cancha de tierra', 'Zarzas1');

INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Concierto \"Juanes\"', '10', '2019-06-30', '19', '00', 'Concierto en Vivo', '4', '1', '1', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Loja se Levanta', '1', '2019-07-01', '11', '30', 'Partido Amistoso', '2', '2', '2', '1', '1');
