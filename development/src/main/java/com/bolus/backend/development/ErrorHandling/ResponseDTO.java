package com.bolus.backend.development.ErrorHandling;

public class ResponseDTO {
	
	private String code;
	private String message;
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
