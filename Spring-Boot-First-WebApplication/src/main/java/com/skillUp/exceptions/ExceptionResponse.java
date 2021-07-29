package com.skillUp.exceptions;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;
	public ExceptionResponse(Date date, String message, String details) {
		super();
		this.timeStamp = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return timeStamp;
	}
	public void setDate(Date date) {
		this.timeStamp = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
