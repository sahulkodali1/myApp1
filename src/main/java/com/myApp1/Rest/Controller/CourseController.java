package com.myApp1.Rest.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myApp1.Model.Course;
import com.myApp1.Service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {
@Autowired
private CourseService courseService;
/**
 * @param course
 * @return
 * @throws Exception
 * this  is used to register the courses into repository
 */
@RequestMapping(value="/registercourse",method=RequestMethod.POST)
	public ResponseEntity<Course>registercourse(@Valid @RequestBody Course course) throws Exception{
	return new ResponseEntity<Course>(courseService.save(course),HttpStatus.CREATED);
}
/**
 * @param courseId
 * @return
 * @throws Exception
 * this is used to delete course by taking courseid
 */
@RequestMapping(value="/deletecourse",method=RequestMethod.DELETE)
public ResponseEntity<HttpStatus>delete(@PathVariable int courseId)throws Exception{
	courseService.deletecourse(courseId);
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
}
/**
 * @param courseId
 * @return
 * @throws Exception
 * used to get all the details about the course
 */
@RequestMapping(value="/getcourse",method=RequestMethod.GET)
public ResponseEntity<HttpStatus>getdetais(@PathVariable int courseId)throws Exception{
	courseService.getDetails(courseId);
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
}
/**
 * @param course
 * @return
 * @throws Exception
 * used to update the course details
 */
@RequestMapping(value="/updatecourse",method=RequestMethod.PUT)
public ResponseEntity<Course>updatecourse(@Valid @RequestBody Course course)throws Exception{
	return new ResponseEntity<Course>(courseService.save(course),HttpStatus.OK);
}
}