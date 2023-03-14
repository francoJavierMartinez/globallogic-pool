package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.entity.User;
import com.example.demo.utils.FormatValidatorContraints;

public class UserDto {
	
	private String name;
	@NotEmpty(message = "You should put at least an email.")
	@Pattern(regexp = FormatValidatorContraints.EMAIL_REGEX_FORMAT, message = "Invalid email format, Please review it and try again.")
	private String email;
	@NotEmpty(message = "You should put at least a password.")
	@Pattern(regexp = FormatValidatorContraints.PASSWORD_REGEX_FORMAT, message = "Invalid password format, Please review it and try again.")
	private String password;
	private List<PhoneDto> phonesDto;
	
	public UserDto() {
		
	}
	
	public UserDto(String name, String email, String password, List<PhoneDto> phonesDto) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonesDto = phonesDto;
	}
	
	public UserDto(User user) {
		
		this.name = user.getName();
		this.email = user.getEmail();
		this.phonesDto = user.getPhones().stream().map(phone -> new PhoneDto(phone)).collect(Collectors.toList());
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<PhoneDto> getPhones() {
		return phonesDto;
	}
	
	public void setPhones(List<PhoneDto> phonesDto) {
		this.phonesDto = phonesDto;
	}
	
	public User toUser() throws Exception {
		
		User user = new User();
		user.setName(getName());
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		if(getPhones() != null)
			getPhones().stream().forEach(phoneDto -> user.addPhone(phoneDto.toPhone()));
		
		return user;
		
	}
	
}
