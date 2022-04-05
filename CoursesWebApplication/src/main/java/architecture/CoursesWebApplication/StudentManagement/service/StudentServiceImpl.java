package architecture.CoursesWebApplication.StudentManagement.service;

import architecture.CoursesWebApplication.StudentManagement.dao.DAOStudentRepository;
import architecture.CoursesWebApplication.StudentManagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private DAOStudentRepository studentRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(DAOStudentRepository theStudentRepository) {
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
			// we didn't find the student
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
