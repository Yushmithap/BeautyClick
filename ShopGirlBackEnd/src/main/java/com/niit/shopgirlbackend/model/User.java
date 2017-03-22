package com.niit.shopgirlbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="USER")   //if the table name and domain object name is same
@Component  //user instance //do not use User u = new User();
public class User {
	
	@Id
	private String id;
	
	@NotEmpty(message="Enter you name")
	private String name;
	
	@NotNull(message = "Enter your email address")
	@Column(unique=true, nullable=false)
	@Email
	private String email;
	
	@NotNull(message = "Enter password")
	@Size(min=8, max=15)
	private String password;
	
	@NotNull
	@Pattern(regexp="(^$|[0-9]{10})")
	@Size(max = 10, message = "Please enter your 10 digit phone number")
	private String mobile;
	
	@NotNull
	private String role;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//what are the properties same as db table fields
	
	
}