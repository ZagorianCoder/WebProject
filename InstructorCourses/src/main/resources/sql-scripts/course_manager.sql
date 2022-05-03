CREATE DATABASE  IF NOT EXISTS `course_manager`;
USE `course_manager`;

DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;


CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  `project_pecentage`  varchar(45) DEFAULT NULL,
  `exam_pecentage`  varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
  
  );

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `year_of_reg` VARCHAR(10) DEFAULT NULL,
  `semester` int DEFAULT 0,
  `project_grade`  varchar(45) DEFAULT NULL,
  `exam_grade`  varchar(45) DEFAULT NULL,
  `final_grade`  varchar(45) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (course_id) REFERENCES course (id)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);