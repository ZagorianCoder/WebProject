package architecture.CoursesWebApplication.CoursesManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import architecture.CoursesWebApplication.CoursesManagement.entity.Course;

public interface DAORepository extends JpaRepository<Course,Integer> {
	
	public List<Course> findAll();
	
	public Course findById(int theId);
	
	
}
