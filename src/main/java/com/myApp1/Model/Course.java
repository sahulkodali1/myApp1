package com.myApp1.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@NotBlank(message = "coursename shouldnt be blank")
	private String courseName;

	@NotBlank(message = "authorname shouldnt be blank")
	private String aUthor;

	@NotBlank(message = "descriotion shouldnt be blank")
	private String dEscription;

	@Enumerated(EnumType.STRING)
	private Skilllevel skillLevel;

	public Course(int courseId, String courseName, String aUthor, String dEscription, Skilllevel skillLevel) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.aUthor = aUthor;
		this.dEscription = dEscription;
		this.skillLevel = skillLevel;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getaUthor() {
		return aUthor;
	}

	public void setaUthor(String aUthor) {
		this.aUthor = aUthor;
	}

	public String getdEscription() {
		return dEscription;
	}

	public void setdEscription(String dEscription) {
		this.dEscription = dEscription;
	}

	public Skilllevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Skilllevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + "]";
	}
	
}
