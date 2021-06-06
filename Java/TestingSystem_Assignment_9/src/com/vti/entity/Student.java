package com.vti.entity;

public class Student {
	public static int COUNT = 0;
	private int id;
	private String name;

	public Student(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

	@Deprecated
	public int getId() {
		return id;
	}

	public String getIdwithMSV() {
		return "MSV " + id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [ id = " + id + ", name = " + name + "]";
	}
}
