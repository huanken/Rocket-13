package com.vti.entity;

public class Worker extends Employee {
	public int rank;

	public Worker() {
		super();
	}

	public Worker(String name, int age, com.vti.entity.Employee.gender gender, String address, int rank) {
		super(name, age, gender, address);
		this.rank = rank;
	}

	@Override
	public String toString() {
		return " Worker [ " + super.toString() + ", rank = " + rank + " ]";
	}

}
