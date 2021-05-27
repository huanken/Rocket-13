package com.vti.entity;

import java.util.Scanner;

public class Studentt extends Person {
	private int id;
	private float averageScore;
	private String email;
	public Studentt() {
		super();
	}

	public Studentt(String name, Gender gender, String birthDay, String address, int id, float averageScore,
			String email) {
		super(name, gender, birthDay, address);
		this.id = id;
		this.averageScore = averageScore;
		this.email = email;
	}

	@Override
	public void inputInfo() {
		super.inputInfo();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mã sinh viên: ");
		id = scanner.nextInt();
		System.out.println("Nhập điểm trung bình: ");
		averageScore = scanner.nextFloat();
		scanner = new Scanner(System.in);
		System.out.println("Nhập Email: ");
		email = scanner.nextLine();
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Mã sinh viên: " + id);
		System.out.println("Điểm trung bình: " + averageScore);
		System.out.println("Email: " + email);
	}

	public void scholarShip() {
		if (averageScore >= 8.0) {
			System.out.println("Student được học bổng");
		} else {
			System.out.println("Student không được học bổng");
		}
	}
}
