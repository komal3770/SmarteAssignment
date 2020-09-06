package com.smarte.assignment.pojo;

public class Response {
	private String message;
	private boolean isSuccess;
	
	public Response(String message, boolean status) {
		super();
		this.message = message;
		this.isSuccess = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return isSuccess;
	}
	public void setStatus(boolean status) {
		this.isSuccess = status;
	}
	
	
}
