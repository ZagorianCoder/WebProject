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
import org.springframework.beans.factory.annotation.Value;

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
	@Autowired
	private StudentService studentService;
	
	private Course course;
	
	public CourseController() {
		super();
	}
	
	public CourseController(CourseService theCourseService,StudentService theStudentService,Course course) {
		courseService = theCourseService;
		studentService = theStudentService;
		this.course = course;
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
			this.setCourse(theCourse);
			
			
			List<Student> theStudentRgst = studentService.findRegistrationsByCourseId(theId);
			
			
			theModel.addAttribute("studentobj", theStudentRgst);
			theModel.addAttribute("courses2", theCourse);
			
			return "list-students";
		}
		
		

		

		@GetMapping("/showFormForAddStudents")
		public String showFormForAddStudents(Model theModel) {
			
			// create model attribute to bind form data
			Student theStudent = new Student();
			
			theModel.addAttribute("studentobj", theStudent);
			
			return "student-form";
		}

		@GetMapping("/showFormForUpdateStudents")
		public String showFormForUpdateStudents(@RequestParam("studentId") int theId,
										Model theModel) {
			
			;
			
			// get the course from the service
			Student theStudent = studentService.findById(theId);
			
			// set course as a model attribute to pre-populate the form
			theModel.addAttribute("studentobj", theStudent);
			
			// send over to our form
			return "student-form";			
		}
		
		
		@PostMapping("/saveStudent")
		public String saveStudent(@ModelAttribute("studentobj") Student theStudent, Model theModel) {
			
			this.getCourse().addStudent(theStudent);  //from Course entity
			theStudent.setCourse(this.getCourse());	  //giving the course_id so that the student can be displayed at the specific course
			
			// save the course
			studentService.save(theStudent);
			
			// use a redirect to prevent duplicate submissions
			return "Confirmation1";      //       TODO how to go back to students list
		}
		
		
		@GetMapping("/deleteStudent")
		public String deleteStudent(@RequestParam("studentId") int theId) {
			
			// delete the course
			studentService.deleteById(theId);
			
			// redirect to /courses/list
			return "Confirmation";     //       TODO how to go back to students list 
			
		}

		public CourseService getCourseService() {
			return courseService;
		}

		public void setCourseService(CourseService courseService) {
			this.courseService = courseService;
		}

		public StudentService getStudentService() {
			return studentService;
		}

		public void setStudentService(StudentService studentService) {
			this.studentService = studentService;
		}
		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}
		
		
	}

	
	

