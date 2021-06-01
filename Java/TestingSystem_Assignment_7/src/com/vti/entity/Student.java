package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Student {
	private int id;
	private String name;
	private static String college = "Đại học bách khoa";
	private static int Count = 0;
	public static int moneyGroup = 0;

	public Student() {
		super();
		this.setId(setCount(getCount() + 1));
		if (Count > 7) {
			System.err.println("Số lượng sinh viên đã vượt quá 7, không	thể tạo thêm sinh viên");
		} else {
			this.id = Count;
			System.out.println("Nhập vào tên sinh viên: ");
			this.name = ScannerUltis.inputString();
		}
	}
	
	public Student(String name) {
		this.setId(setCount(getCount() + 1));
		this.name = name;
	}
	
	//Question 4a
	public static String getCollege() {
		return college;
	}
	
	//Question 4b
	public static void setCollege(String college) {
		Student.college = college;
	}

	public static int getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}

	@Override
	public String toString() {
		return "Student [id = " + getId() + ", name = " + name + ", school = " + college + " ]";
	}

	public static int getCount() {
		return Count;
	}

	public static int setCount(int count) {
		Count = count;
		return count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
