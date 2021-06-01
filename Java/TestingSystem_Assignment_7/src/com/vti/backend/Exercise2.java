package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.PrimaryStudentEx2;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.SecondaryStudentEx2;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	// Question 1
	public void question1() {
		System.out.println("Nhập vào 1 số int: ");
		int a = ScannerUltis.inputInt();
		System.out.println("Tổng số đố và PI là: "+ MyMath.sum(a));
	}
	
	//Question 3
	public void question3() {
		PrimaryStudentEx2 priStudent = new PrimaryStudentEx2("Nguyễn Văn A");
		SecondaryStudentEx2 secondStudent = new SecondaryStudentEx2("Nguyễn Văn B");
	//	System.out.println("priStudent: "+ PrimaryStudentEx2.study());
	}
	
}
