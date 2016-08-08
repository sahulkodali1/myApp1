package com.myApp1.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myApp1.Exception.CourseNotFound;
import com.myApp1.Model.Course;
import com.myApp1.Model.Topic;
import com.myApp1.Model.User;
import com.myApp1.Repositories.CourseRepository;
import com.myApp1.Repositories.TopicRepository;
import com.myApp1.Repositories.UserRepository;

public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TopicRepository topicRepository;

	public Course save(Course course) throws Exception {
		return courseRepository.save(course);

	}

	public void deletecourse(int courseId) throws Exception {
		Course course = courseRepository.findOne(courseId);
		if (course != null) {
			courseRepository.delete(course);
		} else
			throw new CourseNotFound("delete operation for " + courseId + " is failed");

	}

	public Course getDetails(int courseId) throws Exception {
		Course course = courseRepository.findOne(courseId);
		if (course == null) {

			throw new CourseNotFound("search operation for " + courseId + " is failed");

		} else {
			return courseRepository.getOne(courseId);
		}

	}

	public Course addusertocourse(int courseId, String userName) throws Exception {
		Course course = getDetails(courseId);
		User user = userRepository.findOne(userName);
		course.getUser().add(user);
		return courseRepository.save(course);
	}

	public Course deleteuserfromcourse(int courseId, String userName) throws Exception {
		Course course = getDetails(courseId);
		User user = userRepository.getOne(userName);
		course.getUser().remove(user);
		return courseRepository.save(course);
	}
	public Course addtopictocourse(int courseId,Topic topic)throws Exception{
		Course course=getDetails(courseId);
		course.getTopics().add(topic);
		return courseRepository.save(course);
	}
	public Course removetopicfromcourse(int courseId,Topic topic)throws Exception{
		Course course=getDetails(courseId);
		course.getTopics().remove(topic);
		return courseRepository.save(course);
	}

}
