CREATE DATABASE  IF NOT EXISTS `student_manager`;
USE `student_manager`;

DROP TABLE IF EXISTS `student`;


CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `year of registration` int DEFAULT 0,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
  
  );
