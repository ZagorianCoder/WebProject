package ClassWebApp.InstructorCourses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.entity.Student;
import ClassWebApp.InstructorCourses.dao.StudentDAORepository;
import ClassWebApp.InstructorCourses.service.StudentService;
import ClassWebApp.InstructorCourses.dao.DAORepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDAORepository studentRepository;
	
	@Autowired
	private DAORepository courseRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(StudentDAORepository theStudentRepository,DAORepository theDAORepository) {
		studentRepository = theStudentRepository;
		courseRepository = theDAORepository;
	}
	
	
	
	
	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}
	

	@Override
	@Transactional
	public List<Student> findRegistrationsByCourseId (int courseid) {
		if (!courseRepository.existsById(courseid)) {
		      throw new RuntimeException("Not found Tutorial with id = " + courseid);
		}
		List<Student> theStudent = studentRepository.findRegistrationsByCourseId(courseid);
		return theStudent;
		
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

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
		
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the course
			throw new RuntimeException("Did not find course id - " + theId);
		}
	}
	
	
	
	public StudentDAORepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentDAORepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public DAORepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(DAORepository courseRepository) {
		courseRepository = courseRepository;
	}
	
}
