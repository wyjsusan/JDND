-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema c3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema c3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `c3` DEFAULT CHARACTER SET utf8 ;
USE `c3` ;

-- -----------------------------------------------------
-- Table `c3`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c3`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `description` VARCHAR(1024) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `c3`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c3`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(3072) NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_product_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `c3`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `c3`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c3`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1024) NOT NULL,
  `review_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_review1_idx` (`review_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `c3`.`review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
