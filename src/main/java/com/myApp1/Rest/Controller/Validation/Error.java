package com.myApp1.Rest.Controller.Validation;

public class Error {
	private String message;
	

	public Error(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
