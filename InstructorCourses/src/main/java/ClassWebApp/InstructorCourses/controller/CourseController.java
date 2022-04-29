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
import ClassWebApp.InstructorCourses.entity.Student;
import ClassWebApp.InstructorCourses.service.StudentService;

@Controller
@RequestMapping("/courses")
@SessionAttributes("courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	private StudentService studentService;
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		// get courses from db
		List<Course> theCourses = courseService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		
		return "list-courses";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course theCourse = new Course();
		
		theModel.addAttribute("course", theCourse);
		
		return "course-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,
									Model theModel) {
		
		List<Course> theCourses = (List<Course>) theModel.getAttribute("courses");
		theCourses.size();
		
		// get the course from the service
		Course theCourse = courseService.findById(theId);
		
		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);
		
		// send over to our form
		return "course-form";			
	}
	
	
	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse, Model theModel) {
		
		// save the course
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the course
		courseService.deleteById(theId);
		
		// redirect to /courses/list
		return "redirect:/courses/list";
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// add mapping for "/list"

		@RequestMapping("/studentList")
		public String listStudents(@RequestParam("courseId") int theId,
				Model theModel) {
			
			Course theCourse = courseService.findById(theId);
			
			
			// get courses from db
			List<Student> theStudentRgst = studentService.findRegistrationsByCourseId(theId);
			
			// add to the spring model
			theModel.addAttribute("student", theStudentRgst);
			theModel.addAttribute("courses", theCourse);
			
			return "list-students";
		}
		
		

		@GetMapping("/showFormForAddStudents")
		public String showFormForAddStudents(Model theModel) {
			
			// create model attribute to bind form data
			Student theStudent = new Student();
			
			theModel.addAttribute("student", theStudent);
			
			return "student-form";
		}

		@GetMapping("/showFormForUpdateStudents")
		public String showFormForUpdateStudents(@RequestParam("studentId") int theId,
										Model theModel) {
			
			List<Student> theStudents = (List<Student>) theModel.getAttribute("student");
			theStudents.size();
			
			// get the course from the service
			Student theStudent = studentService.findById(theId);
			
			// set course as a model attribute to pre-populate the form
			theModel.addAttribute("student", theStudent);
			
			// send over to our form
			return "student-form";			
		}
		
		
		@PostMapping("/saveStudent")
		public String saveStudent(@ModelAttribute("student") Student theStudent, Model theModel) {
			
			// save the course
			studentService.save(theStudent);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/students/studentList";
		}
		
		
		@GetMapping("/deleteStudent")
		public String deleteStudent(@RequestParam("studentId") int theId) {
			
			// delete the course
			studentService.deleteById(theId);
			
			// redirect to /courses/list
			return "redirect:/students/studentList";
			
		}
		
		
	}

	
	

