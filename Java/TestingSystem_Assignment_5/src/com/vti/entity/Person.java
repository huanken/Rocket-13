package com.vti.entity;

import java.util.Scanner;

public class Person {
	private String name;
	private Gender gender;
	private String birthDay;
	private String address;

	public Person() {
		super();
	}

	enum Gender {
		Male, Female, Unknown
	}

	public Person(String name, Gender gender, String birthDay, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void inputInfo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tên: ");
		name = scanner.nextLine();
		System.out.println("Chọn giới tính (1.Nam 2.Nữ 3.Khác): ");
		int seletion = scanner.nextInt();
		switch (seletion) {
		case 1:
			gender = Gender.Male;
			break;
		case 2:
			gender = Gender.Female;
			break;
		default:
			gender = Gender.Unknown;
			break;
		}
		scanner = new Scanner(System.in);
		System.out.println("Nhập ngày sinh: ");
		birthDay = scanner.nextLine();
		System.out.println("Nhập địa chỉ: ");
		address = scanner.nextLine();
	}

	public void showInfo() {
		System.out.println("Tên: " + name);
		System.out.println("Giới tính: " + gender);
		System.out.println("Ngày sinh: " + birthDay);
		System.out.println("Địa chỉ: " + address);
	}
}
