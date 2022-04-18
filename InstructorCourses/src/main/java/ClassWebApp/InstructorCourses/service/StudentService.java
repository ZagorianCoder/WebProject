package ClassWebApp.InstructorCourses.service;

import java.util.List;
import ClassWebApp.InstructorCourses.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
}
