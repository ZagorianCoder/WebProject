package architecture.CoursesWebApplication.CoursesManagement.service;

import java.util.List;

import architecture.CoursesWebApplication.CoursesManagement.entity.Course;

public interface CourseService {
	
	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course theEmployee);
	
	public void deleteById(int theId);
}
