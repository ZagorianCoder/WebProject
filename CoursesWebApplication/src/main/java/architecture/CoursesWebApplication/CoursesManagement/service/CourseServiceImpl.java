package architecture.CoursesWebApplication.CoursesManagement.service;

import java.util.List;

import architecture.CoursesWebApplication.CoursesManagement.dao.DAORepository;
import architecture.CoursesWebApplication.CoursesManagement.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {
	
	
	@Autowired
	private DAORepository courseRepository;
	
	public CourseServiceImpl() {
		super();
	}

	@Autowired
	public CourseServiceImpl(DAORepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	
	
	
	
	@Override
	@Transactional
	public List<Course> findAll() {
		
		return courseRepository.findAll();
	}

	@Override
	@Transactional
	public Course findById(int theId) {
		Course result = courseRepository.findById(theId);
		
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find course id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		courseRepository.save(theCourse);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);
		
	}
	
}
