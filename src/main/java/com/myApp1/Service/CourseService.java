package com.myApp1.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myApp1.Exception.CourseNotFound;
import com.myApp1.Model.Course;
import com.myApp1.Repositories.CourseRepository;

public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public Course save(Course course)throws Exception{
		return courseRepository.save(course);
		
		
		}
	public void deletecourse(int courseId) throws Exception{
		Course course=courseRepository.findOne(courseId);
		if(course!=null){
			courseRepository.delete(course);
		}else
			throw new CourseNotFound("delete operation for "+courseId+" is failed");
		
	}
	public void getDetails(int courseId)throws Exception{
		Course course=courseRepository.findOne(courseId);
		if(course!=null){
			 courseRepository.findOne(courseId);	
				
		}else
		{
			throw new CourseNotFound("search operation for "+courseId+" is failed");
		}
	
	
	}
}



