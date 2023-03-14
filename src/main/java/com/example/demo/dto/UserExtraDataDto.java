package com.example.demo.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import com.example.demo.entity.User;


public class UserExtraDataDto extends UserDto{
	
	private UUID uuid;
	private String createdAt;
	private String lastLogin;
	private String token;
	private boolean isActive;
	
	public UserExtraDataDto() {
		
	}
	
	public UserExtraDataDto(String name, String email, String password, List<PhoneDto> phonesDto, UUID uuid,
			String createdAt, String lastLogin, String token, boolean isActive) {
		super(name, email, password, phonesDto);
		this.uuid = uuid;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}
	
	public UserExtraDataDto(User user) {
				
		super(user);
		setUuid(user.getUuid());
		setCreatedAt(user.getCreatedAt().format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss a")));
		setLastLogin("");
		setToken("");
		setActive(user.getIsActive());
		
	}

	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public String getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
