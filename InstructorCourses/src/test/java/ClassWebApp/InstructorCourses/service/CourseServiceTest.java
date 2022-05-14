package ClassWebApp.InstructorCourses.service;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath: application.properties"
)
//@ContextConfiguration(locations = "/resources/application.properties")
class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Test
    void testCourseDAOJpaImplIsNotNull() {
        Assertions.assertNotNull(courseService);
    }

    @Test
    void testFindByIdReturnsCourse(){
        Course storedCourse = courseService.findById(1);
        Assertions.assertNotNull(storedCourse);
        Assertions.assertEquals("1", storedCourse.getName());
    }

}