package com.example.demo.utils;

public class FormatValidatorContraints {
	
	public static final String PASSWORD_REGEX_FORMAT = "^(?=(?:.*\\d){2})(?=(?:.*[A-Z]){1})(?=(?:.*[a-z]){2})\\S{8,12}$";
	public static final String EMAIL_REGEX_FORMAT = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
}
