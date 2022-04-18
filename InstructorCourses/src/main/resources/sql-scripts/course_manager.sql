CREATE DATABASE  IF NOT EXISTS `course_manager`;
USE `course_manager`;

DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `student`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
  
  );

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `yearOfRegistration` int DEFAULT NULL,
  `semester` int DEFAULT 0,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) 
				ON DELETE CASCADE ON UPDATE CASCADE
);