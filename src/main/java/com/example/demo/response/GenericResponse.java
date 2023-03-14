package com.example.demo.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericResponse {
	
	public static ResponseEntity<Object> generateGenericResponse(String message, HttpStatus statusCode, Object objectResponse) {

		Map<String, Object> hashResponse = new HashMap<String, Object>();

		hashResponse.put("message", message);
		hashResponse.put("code", statusCode);
		hashResponse.put("body", objectResponse);

		return new ResponseEntity<Object>(hashResponse, statusCode);
		
	}

}
