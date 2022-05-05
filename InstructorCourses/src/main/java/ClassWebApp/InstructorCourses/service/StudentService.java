package ClassWebApp.InstructorCourses.service;

import java.util.List;
import ClassWebApp.InstructorCourses.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);

	public List<Student> findRegistrationsByCourseId(int theId);
	
	public double mean(List<Student> theStudent);
	public double min(List<Student> theGrades);
	public double max(List<Student> theGrades);
	public double median(List<Student> theGrades);
	public double standardDeviation(List<Student> theGrades);
	public double variance(List<Student> theGrades);
	public double percentiles(List<Student> theGrades);
	public double skewness(List<Student> theGrades);
	public double kurtosis(List<Student> theGrades);

	
	
	

	
}
