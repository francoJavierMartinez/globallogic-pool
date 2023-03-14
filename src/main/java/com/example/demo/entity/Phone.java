package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONES")
public class Phone implements Serializable{
	
	private static final long serialVersionUID = -2989349838132146761L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NUMBER")
	private Long idNumber;
	@Column(name = "NUMBER")
	private Long number;
	@Column(name = "CITY_CODE")
	private int cityCode;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;
	
	
	public Phone() {
	}
	
	public Phone(Long number, int cityCode, String countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
}
