package ClassWebApp.InstructorCourses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ClassWebApp.InstructorCourses.entity.Course;

public interface DAORepository extends JpaRepository<Course,Integer> {
	
	public Course findById(int theId);
}
