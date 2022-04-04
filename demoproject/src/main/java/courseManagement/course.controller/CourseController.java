package courseManagement.course.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import courseManagement.course.entity.Course;
import courseManagement.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService cs;

    //define constructor


    public CourseController(CourseService cs) {
        this.cs = cs;
    }

    // add mapping for "/list"

    @RequestMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Course> theCourses = cs.findAll();

        // add to the spring model
        theModel.addAttribute("courses", theCourses);

        return "courses/list-courses";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Course theCourse = new Course();

        theModel.addAttribute("courses", theCourse);

        return "courses/courses-form";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") int theId,
                                    Model theModel) {

        //List<Course> theCourses = (List<Course>) theModel.getAttribute("courses");
        //theCourses.size();

        // get the employee from the service
        Course theCourse = cs.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("course", theCourse);

        // send over to our form
        return "courses/courses-form";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute("course") Course theCourse) {

        // save the employee
        cs.save(theCourse);

        // use a redirect to prevent duplicate submissions
        return "redirect:/courses/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("courseId") int theId) {

        // delete the employee
        cs.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/courses/list";

    }

}
