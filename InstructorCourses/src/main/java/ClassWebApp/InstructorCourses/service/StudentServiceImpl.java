package ClassWebApp.InstructorCourses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ClassWebApp.InstructorCourses.entity.Student;
import ClassWebApp.InstructorCourses.dao.StudentDAORepository;
import ClassWebApp.InstructorCourses.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDAORepository studentRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(StudentDAORepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	
	
	
	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
		
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
		
	}
	
}
