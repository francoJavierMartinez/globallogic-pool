package com.example.demo.dto;

import com.example.demo.entity.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneDto {
	
	private Long number;
	@JsonProperty("citycode")
	private int cityCode;
	@JsonProperty("countrycode")
	private String countryCode;
	
	public PhoneDto() {
		
	}
			
	public PhoneDto(Long number, int cityCode, String countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}
	
	public PhoneDto(Phone phone) {
		super();
		this.number = phone.getNumber();
		this.cityCode = phone.getcityCode();
		this.countryCode = phone.getCountryCode();
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public int getcityCode() {
		return cityCode;
	}

	public void setcityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Phone toPhone() {
		
		Phone phone = new Phone();
		phone.setNumber(getNumber());
		phone.setcityCode(getcityCode());
		phone.setCountryCode(getCountryCode());
		
		return phone;
	}
}
