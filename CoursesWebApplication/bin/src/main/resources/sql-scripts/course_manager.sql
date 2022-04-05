CREATE DATABASE  IF NOT EXISTS `course_manager`;
USE `course_manager`;

DROP TABLE IF EXISTS `course`;


CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` varchar(45) DEFAULT 0,
  `year` int DEFAULT 0,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
  
  );
