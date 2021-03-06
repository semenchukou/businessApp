-- MySQL Script generated by MySQL Workbench
-- Mon Mar 23 15:23:40 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

drop schema `ba`;

CREATE SCHEMA IF NOT EXISTS `ba` DEFAULT CHARACTER SET utf8 ;
USE `ba` ;

-- -----------------------------------------------------
-- Table `ba`.`Clubs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ba`.`Clubs` (
  `idClub` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NULL,
  `foundation_year` INT NULL,
  `coach` VARCHAR(45) NULL,
  PRIMARY KEY (`idClub`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  UNIQUE INDEX `Coach_UNIQUE` (`Coach` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ba`.`Players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ba`.`Players` (
  `idPlayers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `transfer_cost` FLOAT NULL,
  `goals` INT NULL,
  `club_id` INT NOT NULL,
  PRIMARY KEY (`idPlayers`, `Club_id`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  INDEX `fk_Players_Clubs_idx` (`Club_id` ASC) VISIBLE,
  CONSTRAINT `fk_Players_Clubs`
    FOREIGN KEY (`Club_id`)
    REFERENCES `ba`.`Clubs` (`idClub`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into clubs(Name, Foundation_year, Coach) values("Real Madrid", 1880, "Zinedin Zidan");
insert into clubs(Name, Foundation_year, Coach) values("Juventus", 1887, "Mauritsio Sarri");

insert into `ba`.players(Name, Birth_date, Transfer_cost, Goals, Club_id) values("Ronaldo", "1990-01-01", 100000.0, 100, 2);
insert into `ba`.players(Name, Birth_date, Transfer_cost, Goals, Club_id) values("Marcelo", "1997-07-05", 99951.7, 10, 1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;