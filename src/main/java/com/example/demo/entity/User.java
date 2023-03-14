package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 5105878029461708346L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long idUser;
	@Column(name = "UUID")
	private UUID uuid;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	@Column(name = "LAST_LOGIN")
	private LocalDateTime lastLogin;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@Column(name = "PHONES")
	private List<Phone> phones = new ArrayList<Phone>();
	
	public User() {
	}

	public User(UUID uuid, boolean isActive, LocalDateTime createdAt, LocalDateTime lastLogin, String name, String email, String password,
			List<Phone> phones) {
		super();
		this.uuid = uuid;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public void addPhone(Phone phone) {
		
		phone.setUser(this);
		phones.add(phone);
		
	}
	
}
