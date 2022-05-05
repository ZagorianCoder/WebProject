package ClassWebApp.InstructorCourses.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ClassWebApp.InstructorCourses.entity.Course;
import ClassWebApp.InstructorCourses.entity.Student;
import ClassWebApp.InstructorCourses.dao.StudentDAORepository;
import ClassWebApp.InstructorCourses.service.StudentService;
import ClassWebApp.InstructorCourses.dao.DAORepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDAORepository studentRepository;
	
	@Autowired
	private DAORepository courseRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(StudentDAORepository theStudentRepository,DAORepository theDAORepository) {
		studentRepository = theStudentRepository;
		courseRepository = theDAORepository;
	}
	
	
	
	
	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}
	

	@Override
	@Transactional
	public List<Student> findRegistrationsByCourseId (int courseid) {
		if (!courseRepository.existsById(courseid)) {
		      throw new RuntimeException("Not found Tutorial with id = " + courseid);
		}
		List<Student> theStudent = studentRepository.findRegistrationsByCourseId(courseid);
		return theStudent;
		
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
		
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
		
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the course
			throw new RuntimeException("Did not find course id - " + theId);
		}
	}
	
	//Below there are the functions for the statistics by apache math 3
	@Override
	@Transactional
	public double mean(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		double mean = stats.getMean();
		return mean;
		
		
	}
	@Override
	@Transactional
	public double min(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		double min = stats.getMin();
		return min;
		
	}
	
	@Override
	@Transactional
	public double max(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double max = stats.getMax();
		return max;
	}

	@Override
	@Transactional
	public double median(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double median = stats.getPercentile(50);
		return median;
	}

	@Override
	@Transactional
	public double standardDeviation(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double sd = stats.getStandardDeviation();
		return sd;
	}

	@Override
	@Transactional
	public double variance(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double var = stats.getVariance();
		return var;
	}

	@Override
	@Transactional
	public double percentiles(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double perc = stats.getPercentile(10);
		return perc;
	}

	@Override
	@Transactional
	public double skewness(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double skew = stats.getSkewness();
		return skew;
	}

	@Override
	@Transactional
	public double kurtosis(List<Student> theStudent) {
		ArrayList<Double> grades = new ArrayList<Double>();
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i = 0; i < theStudent.size(); i++) {
			double grade = theStudent.get(i).getFinalgrade();
			grades.add(grade);
		}
		
		for(double j : grades) {
	        stats.addValue(j);
		}
		
		
		double kurt = stats.getKurtosis();
		return kurt;
	}
	
	
	
	public StudentDAORepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentDAORepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public DAORepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(DAORepository courseRepository) {
		courseRepository = courseRepository;
	}

	
	
}
