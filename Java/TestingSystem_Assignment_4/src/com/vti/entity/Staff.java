package com.vti.entity;

public class Staff extends Employee {
	public String job;

	public Staff() {
		super();
	}

	public Staff(String name, int age, com.vti.entity.Employee.gender gender, String address, String job) {
		super(name, age, gender, address);
		this.job = job;
	}

	@Override
	public String toString() {
		return " Staff [ " + super.toString() + ", job = " + job + " ]";
	}

}
