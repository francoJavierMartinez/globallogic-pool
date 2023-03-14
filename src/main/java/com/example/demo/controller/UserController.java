package com.example.demo.controller;

import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserExtraDataDto;
import com.example.demo.entity.User;
import com.example.demo.exceptions.GenericException;
import com.example.demo.response.GenericResponse;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto){
		
		try {
			    User userInDb = userService.getObjectByEmail(userDto.getEmail());
			    
			    if(userInDb != null)
					throw new Exception("The e-mail ["+userDto.getEmail()+"] already exist, please try again.");
			    
			    User userToCreate = userDto.toUser();
				User newUser = userService.insert(userToCreate);
				UserExtraDataDto newUserDto = new UserExtraDataDto(newUser);
				return GenericResponse.generateGenericResponse("User correctly added.", HttpStatus.OK, newUserDto);
				
		}catch (Exception e) {
				return GenericException.generateGenericErrorResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, Arrays.asList(e));
		}
		
	}
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return GenericException.generateGenericErrorResponse(HttpStatus.BAD_REQUEST, ex);
    }
	
}
