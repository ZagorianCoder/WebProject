CREATE DATABASE  IF NOT EXISTS `course_manager`;
USE `course_manager`;

DROP TABLE IF EXISTS `course`;


CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` double DEFAULT 0,
  `year` double DEFAULT 0,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
  
  );
