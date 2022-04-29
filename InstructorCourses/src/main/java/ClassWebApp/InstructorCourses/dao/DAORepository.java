package ClassWebApp.InstructorCourses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.entity.Student;

public interface DAORepository extends JpaRepository<Course,Integer> {
	
	public List<Course> findAll();
	
	public Course findById(int theId);
	
	
	
	
}
