package com.vti.entity;

import java.util.Scanner;

import com.vti.backend.Exercise2;
import com.vti.ultis.InvalidAgeInputingException;
import com.vti.ultis.ScannerUtils;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private int age;

	public Account() throws InvalidAgeInputingException {
		input();
	}

	private void input() throws InvalidAgeInputingException {
		System.out.println("Nhập id: ");
		id = ScannerUtils.inputInt("Please input a number as int, please input again.");

		System.out.println("Nhập email: ");
		email = ScannerUtils.inputString("Please input a email, please input again.");

		System.out.println("Nhập username: ");
		username = ScannerUtils.inputString("Please input a String, please input again.");

		System.out.println("Nhập fullname: ");
		fullname = ScannerUtils.inputString("Please input a String, please input again.");

		System.out.println("Nhập tuổi của bạn: ");
		// Question 11
	//	age = Exercise2.inputAge("The age must be greater than 0");
		// Question 12
		age = Exercise2.inputAccountAge();
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullname=" + fullname + ", age="
				+ age + "]";
	}

}