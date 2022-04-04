package courseManagement.course.service;

import java.util.List;

import courseManagement.course.entity.Course;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(int theId);

    public void save(Course theCourse);

    public void deleteById(int theId);

}
