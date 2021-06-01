package com.vti.entity;

public class StudentEx2 {
	private static int count = 0;
	//Question 2
	private final int id ;
	private String name;
	public StudentEx2(String name) {
		this.id = ++count;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public static void study() {
		System.out.println("Đang học bài . . .");
	}

	@Override
	public String toString() {
		return "StudentEx2 [id = " + id + ", name = " + name + " ]";
	} 
	
	
}
