package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private Department department;
	private Position position;
	private LocalDate createDate;

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartment() {
		return department.getName();
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position.getName();
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setID(int iD) {
		id = iD;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Account [ID=" + id + ", email=" + email + ", Username=" + username + ", FullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", CreateDate=" + createDate + "]";
	}

}
