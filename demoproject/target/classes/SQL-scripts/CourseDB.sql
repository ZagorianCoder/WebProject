CREATE DATABASE  IF NOT EXISTS `CourseDB`;
USE `CourseDB`;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `course_name` varchar(45) DEFAULT NULL,
                            `syllabus` varchar(45) DEFAULT NULL,
                            `year` varchar(45) DEFAULT NULL,
                            `semester` int DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;