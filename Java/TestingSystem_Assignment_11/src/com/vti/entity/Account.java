package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private LocalDate createDate;

	public Account(String email, String username, String fullName) {
		super();
		this.email = email;
		this.username = username;
		this.fullName = fullName;
	}

	public Account() {
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public String getUsername() {
		return username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [ID=" + id + ", email=" + email + ", Username=" + username + ", FullName=" + fullName
				+ ", CreateDate=" + createDate + "]";
	}

}
