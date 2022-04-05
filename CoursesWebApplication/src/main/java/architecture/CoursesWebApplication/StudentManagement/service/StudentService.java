package architecture.CoursesWebApplication.StudentManagement.service;

import architecture.CoursesWebApplication.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
}
