package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Method {
	public static void main(String[] args) {
		question1();
		question2();
		question3();
	}

	private static void question1() {
		System.out.println("Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10");
		for (int i = 2; i < 10; i = i + 2) {
			System.out.print(i + " ");
		}
	}

	private static void question2() {
		System.out.println("\nQuestion 2:Tạo method để in thông tin các account");
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "email1@gmail.com";
		acc1.userName = "UserName1";
		acc1.fullName = "Nguyen Van A";
		acc1.createDate = LocalDate.now();
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "email2@gmail.com";
		acc2.userName = "Username2";
		acc2.fullName = "Nguyen Van B";
		acc2.createDate = LocalDate.now();
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "email3@gmail.com";
		acc3.userName = "UserName3";
		acc3.fullName = "Nguyen Thi C";
		acc3.createDate = LocalDate.now();
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			printAccount(account);
		}
	}

	private static void printAccount(Account account) {
		System.out.println("ID: " + account.id + " Email: " + account.email + " Username: " + account.userName
				+ " FullName: " + account.fullName + " CreareDate: " + account.createDate);
	}

	private static void question3() {
		System.out.println("Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}
	}
}
