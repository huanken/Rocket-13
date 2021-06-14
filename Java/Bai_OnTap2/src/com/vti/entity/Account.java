package com.vti.entity;

public class Account {
	private int id;
	private String fullName;
	private String email;
	private String passWord;
	private TypeAccount typeAccount;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int projectID;

	public Account() {
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public enum TypeAccount {
		Manager, Employee
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassWord() {
		return passWord;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public Account(int id, String fullName, String email, String passWord, TypeAccount typeAccount, int projectID) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.passWord = passWord;
		this.typeAccount = typeAccount;
		this.projectID = projectID;
	}

}
