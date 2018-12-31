package com.in28minutes.learning.jpa.jpain10steps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	protected User() {

	}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
}
