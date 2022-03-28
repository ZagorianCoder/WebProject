package ClassWebApp.InstructorCourses.controller;

import java.util.List;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.service.CourseService;

@Controller
@RequestMapping("/courses")
@SessionAttributes("courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		// get employees from db
		List<Course> theCourses = courseService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		/* Simple test this is how to get the 
		 * name of the person logged in to be used for other purposes 
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		*/
		
		return "courses/list-courses";
	}
}
