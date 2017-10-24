CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8 ;

DROP TABLE `blog`.`base_info`;
--  创建基本信息表
CREATE TABLE `blog`.`base_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `path` VARCHAR(45) NOT NULL,
  `synopsis` VARCHAR(45) NULL,
  `data` VARCHAR(45) ,
  PRIMARY KEY (`id`));
  
SELECT * from `base_info`;
  
