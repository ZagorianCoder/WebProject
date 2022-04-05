package architecture.CoursesWebApplication.CoursesManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	public Course() {
		super();
	}
	
	public Course(String name,String syllabus,int year,int semester) {
		super();
		this.name=name;
		this.syllabus=syllabus;
		this.year=year;
		this.semester=semester;
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
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", syllabus=" + syllabus + ", year=" + year +", semester=" + semester +"]";
	}
}
