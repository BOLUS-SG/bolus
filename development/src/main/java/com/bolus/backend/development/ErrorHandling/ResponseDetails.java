package com.bolus.backend.development.ErrorHandling;

import java.util.ArrayList;
import java.util.List;


public class ResponseDetails {
	
	private List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();

	public ResponseDetails() {
		super();
	}

	public ResponseDetails(List<ResponseDTO> responseList) {
		super();
		this.responseList = responseList;
	}

	public List<ResponseDTO> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<ResponseDTO> responseList) {
		this.responseList = responseList;
	}	

}
