package com.bolus.backend.development.ErrorHandling;

import java.util.HashMap;
import java.util.Map;


public class ResponseDetails {
	
	private Map<String,String> responseMap = new HashMap<String,String>();

	public ResponseDetails() {
		super();
	}

	public ResponseDetails(Map<String, String> responseMap) {
		super();
		this.responseMap = responseMap;
	}

	public Map<String, String> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, String> responseMap) {
		this.responseMap = responseMap;
	}

}
