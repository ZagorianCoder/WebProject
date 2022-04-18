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

import ClassWebApp.InstructorCourses.entity.Student;
import ClassWebApp.InstructorCourses.service.StudentService;

@Controller
@RequestMapping("/students")
@SessionAttributes("students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// add mapping for "/list"

	@GetMapping("/studentList")
	public String listStudents(Model theModel) {
		
		// get courses from db
		List<Student> theStudent = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theStudent);
		
		
		return "courses/list-students";
	}
	
	@GetMapping("/showFormForAddStudents")
	public String showFormForAddStudents(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "courses/student-form";
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
		return "courses/student-form";			
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
