package architecture.CoursesWebApplication.StudentManagement.entity;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	
	@Column(name=" year of registration")
	private int  year_of_registration;
	
	@Column(name="semester")
	private int semester;

	public Student() {
	}

	public Student(int id, String name, int year_of_registration, int semester) {
		this.id = id;
		this.name = name;
		this.year_of_registration = year_of_registration;
		this.semester = semester;
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

	public int getYear_of_registration() {
		return year_of_registration;
	}

	public void setYear_of_registration(int year_of_registration) {
		this.year_of_registration = year_of_registration;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", year_of_registration=" + year_of_registration +
				", semester=" + semester +
				'}';
	}
}
