package com.vti.entity;

import java.util.Arrays;

public class Employee<T> {
	public static int COUNT = 0;
	private int id;
	private String name;
	private T[] salaries;

	public Employee(String name, T[] salaries) {
		super();
		this.id = ++COUNT;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + Arrays.toString(salaries) + "]";
	}

	public String getLastSalary() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + salaries[salaries.length - 1] + "]";
	}
}
