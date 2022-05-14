package ClassWebApp.InstructorCourses.controller;

import ClassWebApp.InstructorCourses.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties")

@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CourseController courseController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void testCourseControllerIsNotNull() {
        Assertions.assertNotNull(courseController);
    }

    @Test
    void testMockMvcIsNotNull() {
        Assertions.assertNotNull(mockMvc);
    }


    @WithMockUser(value = "admin")
    @Test
    void testListCourseReturnsPage() throws Exception {
        mockMvc.perform(get("/courses/list")).
                andExpect(status().isOk()).
                andExpect(model().attributeExists("courses")).
                andExpect(view().name("courses/list-courses"));

        /*
         * A way to check stuff that are in the model
         * andExpect(MockMvcResultMatchers.model().attribute("msg", "Hi there, Joe."))
         */
    }

    @WithMockUser(value = "admin")
    @Test
    void testSaveCourseReturnsPage() throws Exception {

        Course course = new Course("1", "s", 2022, 1, 60, 60);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("id", Integer.toString(course.getId()));
        multiValueMap.add("name", course.getName());
        multiValueMap.add("syllabus", course.getSyllabus());
        multiValueMap.add("year", course.getYear()+"");
        multiValueMap.add("semester", course.getSemester()+"");
        multiValueMap.add("projectpercentage", course.getProjectpercentage()+"");
        multiValueMap.add("exampercentage", course.getExampercentage()+"");

        mockMvc.perform(
                        post("/employees/save").
                                params(multiValueMap)).
                andExpect(status().isFound()).
                andExpect(view().name("redirect:/employees/list"));
    }


}