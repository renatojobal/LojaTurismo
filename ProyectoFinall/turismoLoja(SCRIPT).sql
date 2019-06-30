-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema turismoLoja
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema turismoLoja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `turismoLoja` DEFAULT CHARACTER SET latin1 ;
USE `turismoLoja` ;

-- -----------------------------------------------------
-- Table `turismoLoja`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`admin` (
  `idAdmin` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(24) NULL DEFAULT NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `turismoLoja`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`category` (
  `idCat` INT(11) NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(65) NULL DEFAULT NULL,
  PRIMARY KEY (`idCat`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `turismoLoja`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`client` (
  `idClient` INT(11) NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(10) NULL DEFAULT NULL,
  `password` VARCHAR(24) NULL DEFAULT NULL,
  `names` VARCHAR(65) NULL DEFAULT NULL,
  `lastNames` VARCHAR(65) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `numberPhone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `turismoLoja`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`place` (
  `idPlace` INT(11) NOT NULL AUTO_INCREMENT,
  `principalStreet` VARCHAR(45) NULL DEFAULT NULL,
  `secondaryStreet` VARCHAR(45) NULL DEFAULT NULL,
  `reference` VARCHAR(150) NULL DEFAULT NULL,
  `neighborhood` VARCHAR(90) NULL DEFAULT NULL,
  PRIMARY KEY (`idPlace`))
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `turismoLoja`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`state` (
  `idState` INT(11) NOT NULL AUTO_INCREMENT,
  `state` INT(11) NULL DEFAULT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idState`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `turismoLoja`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismoLoja`.`events` (
  `idEvent` INT(11) NOT NULL AUTO_INCREMENT,
  `nameEvent` VARCHAR(45) NULL DEFAULT NULL,
  `cost` FLOAT NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `hour` VARCHAR(2) NOT NULL,
  `minutes` VARCHAR(2) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `idCat` INT(11) NOT NULL,
  `idPlace` INT(11) NOT NULL,
  `idClient` INT(11) NOT NULL,
  `idState` INT(11) NOT NULL,
  `idAdmin` INT(11) NOT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_events_category_idx` (`idCat` ASC),
  INDEX `fk_events_place_idx` (`idPlace` ASC),
  INDEX `fk_events_client_idx` (`idClient` ASC),
  INDEX `fk_events_state_idx` (`idState` ASC),
  INDEX `fk_events_admin_idx` (`idAdmin` ASC),
  CONSTRAINT `fk_events_admin`
    FOREIGN KEY (`idAdmin`)
    REFERENCES `turismoLoja`.`admin` (`idAdmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_category`
    FOREIGN KEY (`idCat`)
    REFERENCES `turismoLoja`.`category` (`idCat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_client`
    FOREIGN KEY (`idClient`)
    REFERENCES `turismoLoja`.`client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_place`
    FOREIGN KEY (`idPlace`)
    REFERENCES `turismoLoja`.`place` (`idPlace`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_state`
    FOREIGN KEY (`idState`)
    REFERENCES `turismoLoja`.`state` (`idState`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `turismoloja`.`admin` (`user`, `password`) VALUES ('user', 'password');

INSERT INTO `turismoloja`.`category` (`categoryName`) VALUES ('Reliogoso');
INSERT INTO `turismoloja`.`category` (`categoryName`) VALUES ('Deportivo');
INSERT INTO `turismoloja`.`category` (`categoryName`) VALUES ('Cultural');
INSERT INTO `turismoloja`.`category` (`categoryName`) VALUES ('Religioso');
INSERT INTO `turismoloja`.`category` (`categoryName`) VALUES ('Festival');

INSERT INTO `turismoloja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1101', '1101', 'Carlos', 'Castillo', 'cc@utpl.edu.ec', '0901');
INSERT INTO `turismoloja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1102', '1102', 'Luis', 'Perez', 'lp@utpl.edu.ec', '0902');

INSERT INTO `turismoloja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `neighborhood`) VALUES ('Mercadillo', 'Lourdes', 'Frente al Estadio', '24 De Mayo');
INSERT INTO `turismoloja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `neighborhood`) VALUES ('Alejo Garcia', 'Diego de Rojas', 'Frente a cancha de tierra ', 'Zarzas1');

INSERT INTO `turismoloja`.`state` (`state`, `description`) VALUES ('1', 'Revision');
INSERT INTO `turismoloja`.`state` (`state`, `description`) VALUES ('2', 'Aprobado');
INSERT INTO `turismoloja`.`state` (`state`, `description`) VALUES ('3', 'Rechazado');
INSERT INTO `turismoloja`.`state` (`state`, `description`) VALUES ('4', 'Finalizado');



UPDATE `turismoloja`.`admin` SET `idAdmin`='1' WHERE `idAdmin`='2';

UPDATE `turismoloja`.`category` SET `idCat`='1' WHERE `idCat`='6';
UPDATE `turismoloja`.`category` SET `idCat`='2' WHERE `idCat`='7';
UPDATE `turismoloja`.`category` SET `idCat`='3' WHERE `idCat`='8';
UPDATE `turismoloja`.`category` SET `idCat`='4' WHERE `idCat`='9';
UPDATE `turismoloja`.`category` SET `idCat`='5' WHERE `idCat`='10';

UPDATE `turismoloja`.`client` SET `idClient`='1' WHERE `idClient`='5';
UPDATE `turismoloja`.`client` SET `idClient`='2' WHERE `idClient`='6';

UPDATE `turismoloja`.`place` SET `idPlace`='1' WHERE `idPlace`='43';
UPDATE `turismoloja`.`place` SET `idPlace`='2' WHERE `idPlace`='44';

UPDATE `turismoloja`.`state` SET `idState`='1' WHERE `idState`='5';
UPDATE `turismoloja`.`state` SET `idState`='2' WHERE `idState`='6';
UPDATE `turismoloja`.`state` SET `idState`='3' WHERE `idState`='7';
UPDATE `turismoloja`.`state` SET `idState`='4' WHERE `idState`='8';

INSERT INTO `turismoloja`.`events` (`idEvent`, `nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('', 'Concierto', '2', '2019-06-25', '19', '30', 'Concieto en Vivo', '5', '1', '1', '1', '1');
INSERT INTO `turismoloja`.`events` (`idEvent`, `nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('', 'Misa', '2', '2019-06-30', '08', '00', 'Misa', '4', '2', '2', '1', '1');

UPDATE `turismoloja`.`events` SET `idEvent`='1' WHERE `idEvent`='32';
UPDATE `turismoloja`.`events` SET `idEvent`='2' WHERE `idEvent`='33';
