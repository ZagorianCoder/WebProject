package ClassWebApp.InstructorCourses.dao;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.dao.DAORepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
class DAORepositoryTest {

    @Autowired
    DAORepository courseDAO;

    @Test
    void testCourseDAOJpaImplIsNotNull() {
        Assertions.assertNotNull(courseDAO);
    }

    @Test
    void testFindByIdReturnsCourse(){
        Course storedCourse = courseDAO.findById(1);
        Assertions.assertNotNull(storedCourse);
        Assertions.assertEquals("1", storedCourse.getName());
    }

}