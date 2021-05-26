package com.vti.entity;

public class Engineer extends Employee {
	public String specialize;

	public Engineer() {
		super();
	}

	public Engineer(String name, int age, com.vti.entity.Employee.gender gender, String address, String specialize) {
		super(name, age, gender, address);
		this.specialize = specialize;
	}

	@Override
	public String toString() {
		return " Engineer [ "+  super.toString() + ", specialize = " + specialize + " ]";
	}

}
