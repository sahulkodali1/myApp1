package com.myApp1.Exception;

public class CourseNotFound extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public CourseNotFound(){
		super();
	}

	public CourseNotFound(String message) {
		super(message);
		
	}

}
