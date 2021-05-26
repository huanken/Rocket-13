package com.vti.entity;

public class Employee {
	public String name;
	public int age;
	public gender gender;

	public enum gender {
		Male, Female, Unknown
	}

	public String address;

	
	public Employee() {
	}

	public Employee(String name, int age, com.vti.entity.Employee.gender gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	@Override
	public String toString() {
		return " name = " + name + ", age = " + age + ", gender = " + gender + ", address = " + address +" ";
	}

}
