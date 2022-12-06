package com.sporty_shoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;

	// generated constructor using fields
	public Admin(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	// default constructor
	public Admin() {
		super();
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	// toString method
	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
