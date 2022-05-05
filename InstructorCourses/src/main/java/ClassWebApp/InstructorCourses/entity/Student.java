package ClassWebApp.InstructorCourses.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="student")
public class Student {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="year_of_reg")
		private String yearOfRegistration;
		
		@Column(name="semester")
		private int semester;
		
		@Column(name = "project_grade")
		private double projectgrade;
		
		@Column(name = "exam_grade")
		private double examgrade;
		
		@Column(name = "final_grade")
		private double finalgrade;
		
		@JsonIgnore
		@ManyToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "course_id", referencedColumnName = "id")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private Course course;
		
		public Student() {
			super();
		}
		
		public Student(int id,String name,String yearOfRegistration,int year,int semester,Course course,double projectgrade,double examgrade,double finalgrade) {
			super();
			this.id = id;
			this.name=name;
			this.yearOfRegistration=yearOfRegistration;
			this.semester=semester;
			this.course = course;
			this.projectgrade = projectgrade;
			this.examgrade = examgrade;
			this.finalgrade = finalgrade;
		}

		public double getFinalgrade() {
			return finalgrade;
		}

		public void setFinalgrade(double finalgrade) {
			this.finalgrade = finalgrade;
		}

		public double getProjectgrade() {
			return projectgrade;
		}

		public void setProjectgrade(double projectgrade) {
			this.projectgrade = projectgrade;
		}

		public double getExamgrade() {
			return examgrade;
		}

		public void setExamgrade(double examgrade) {
			this.examgrade = examgrade;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
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

		public String getYearOfRegistration() {
			return yearOfRegistration;
		}

		public void setYearOfRegistration(String yearOfRegistration) {
			this.yearOfRegistration = yearOfRegistration;
		}

		public int getSemester() {
			return semester;
		}

		public void setSemester(int semester) {
			this.semester = semester;
		}
		

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", yearofreg=" + yearOfRegistration +", semester=" + semester +"]";
		}

		

		
		
	}


