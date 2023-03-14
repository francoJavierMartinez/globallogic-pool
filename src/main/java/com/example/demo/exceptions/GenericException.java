package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GenericException {
	
	
	public static ResponseEntity<Object> generateGenericErrorResponse(String time, HttpStatus statusCode, List<Exception> exceptionList){
		
		List<Error> errorList = new ArrayList<Error>();
		Map<String, Object> hashResponse = new HashMap<String, Object>();
		
		exceptionList.stream().forEach(error -> {
			
			String errorMsg = ((error.getMessage() != null) && !(error.getMessage().isEmpty()))? error.getMessage() : error.toString();
			Error newError = new Error(LocalDateTime.now(), statusCode.toString(), errorMsg);
			errorList.add(newError);
			
		});
		
		hashResponse.put("error", errorList);
		
		return new ResponseEntity<Object>(hashResponse, statusCode);
	}
	
	public static Map<String, Object> generateGenericErrorResponse(HttpStatus statusCode, MethodArgumentNotValidException exception){
		
		List<Error> errorList = new ArrayList<Error>();
		
		Map<String, Object> hashResponse = new HashMap<String, Object>();
		
		exception.getBindingResult().getAllErrors().stream().forEach(error -> {
			
			Error newError = new Error(LocalDateTime.now(), statusCode.toString(), error.getDefaultMessage());
			errorList.add(newError);
			
		});
		
		hashResponse.put("error", errorList);
				
		return hashResponse;
	}
	
}
