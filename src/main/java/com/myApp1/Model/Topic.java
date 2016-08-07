package com.myApp1.Model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Topic")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int topicId;

@NotBlank(message="this feild should not be blanked")
private String topicName;

@NotBlank(message="this feild should not be blanked")
private LocalTime topicDuration;

@ManyToOne
@JoinColumn(name="courseId")
private Course course;

public Topic(int topicId, String topicName, LocalTime topicDuration, Course course) {
	super();
	this.topicId = topicId;
	this.topicName = topicName;
	this.topicDuration = topicDuration;
	this.course = course;
}

public int getTopicId() {
	return topicId;
}

public void setTopicId(int topicId) {
	this.topicId = topicId;
}

public String getTopicName() {
	return topicName;
}

public void setTopicName(String topicName) {
	this.topicName = topicName;
}

public LocalTime getTopicDuration() {
	return topicDuration;
}

public void setTopicDuration(LocalTime topicDuration) {
	this.topicDuration = topicDuration;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + topicId;
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
	Topic other = (Topic) obj;
	if (topicId != other.topicId)
		return false;
	return true;
}

@Override
public String toString() {
	return "Topic [topicId=" + topicId + "]";
}

}
