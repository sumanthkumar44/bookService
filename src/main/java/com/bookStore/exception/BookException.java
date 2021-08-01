package com.bookStore.exception;

public class BookException extends RuntimeException {
	private Integer errorCode;
	private String description;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BookException(Integer errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}
	
	

}
