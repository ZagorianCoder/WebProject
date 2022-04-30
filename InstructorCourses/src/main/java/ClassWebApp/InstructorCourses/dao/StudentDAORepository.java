package ClassWebApp.InstructorCourses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ClassWebApp.InstructorCourses.entity.Student;

public interface StudentDAORepository extends JpaRepository<Student,Integer> {
	
	public List<Student> findAll();
	
	public List<Student> findRegistrationsByCourseId(int theId);
	
	public Student findById(int theId);
	
	
}
