package ClassWebApp.InstructorCourses.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="syllabus")
	private String syllabus;
	
	@Column(name="year")
	private int year;
	
	@Column(name="semester")
	private int semester;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy="course")
	private List<Student> students = new ArrayList<Student>();
	
	public Course() {
		super();
		//this.students = new ArrayList<Student>();
	}
	
	public Course(String name,String syllabus,int year,int semester) {
		super();
		this.name=name;
		this.syllabus=syllabus;
		this.year=year;
		this.semester=semester;
		//this.students = new ArrayList<Student>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	//for user story 6 to add students that are enrolled to the course
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
//	public void addStudent(Student student) {
//		students.add(student);
//	}
	/////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", syllabus=" + syllabus + ", year=" + year +", semester=" + semester + "]";
	}
}
