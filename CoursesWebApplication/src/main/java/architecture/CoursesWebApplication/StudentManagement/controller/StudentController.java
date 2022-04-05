package architecture.CoursesWebApplication.StudentManagement.controller;

import architecture.CoursesWebApplication.StudentManagement.entity.Student;
import architecture.CoursesWebApplication.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@RequestMapping("/list")
	public String listCourses(Model theModel) {
		
		// get students from db
		List<Student> theStudents = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		
		
		return "courses/list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "courses/student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {
		
		List<Student> theStudents = (List<Student>) theModel.getAttribute("students");
		theStudents.size();
		
		// get the student from the service
		Student theStudent = studentService.findById(theId);
		
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form
		return "courses/student-form";
	}
	
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent, Model theModel) {
		
		// save the student
		studentService.save(theStudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/templates/courses/students/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		// delete the student
		studentService.deleteById(theId);
		
		// redirect to /students/list
		return "redirect:/templates/courses/students/list";
		
	}
	
	
}
