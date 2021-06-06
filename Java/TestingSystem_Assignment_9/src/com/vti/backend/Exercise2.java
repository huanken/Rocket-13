package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2 {
	public void question1() {
		@SuppressWarnings("deprecation")
		Date date1 = new Date(2020 - 1900, 05 - 1, 18);
		System.out.println(date1);
	}

	@SuppressWarnings("deprecation")
	public void question2() {
		System.out.println("Tạo sinh viên với phương thức getID ban đầu:");
		Student stOld = new Student("StudentOld");
		System.out.println("Sinh viên tạo là ID: " + stOld.getId() + " Name: " + stOld.getName());
		System.out.println("Sử dụng phương thức getID bản mới cập nhật getIdWithMSV(): ");
		System.out.println("Sinh viên tạo là ID: " + stOld.getIdwithMSV() + " Name: " + stOld.getName());
	}
}