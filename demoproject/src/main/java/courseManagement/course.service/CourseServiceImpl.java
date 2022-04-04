package courseManagement.course.service;

import java.util.List;

import courseManagement.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import courseManagement.course.dao.CourseDAO;
import courseManagement.course.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseRepository;

    @Autowired
    public CourseServiceImpl(CourseDAO theCourseRepository) {
        courseRepository = theCourseRepository;
    }

    //define constructor

    public CourseServiceImpl() {
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
            throw new RuntimeException("Did not find employee id - " + theId);
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
