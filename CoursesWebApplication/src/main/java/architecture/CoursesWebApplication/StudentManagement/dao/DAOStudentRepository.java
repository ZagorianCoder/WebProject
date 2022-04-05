package architecture.CoursesWebApplication.StudentManagement.dao;

import architecture.CoursesWebApplication.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DAOStudentRepository extends JpaRepository<Student,Integer> {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	
}
