package com.vti.frontend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class InputFromConsole {
	public static void main(String[] args) {
	
	}

	private static void question1() {
		System.out.println("Question 1:Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào 3 số nguyên");
		System.out.println("Nhập vào số 1: ");
		int a = scanner.nextInt();
		System.out.println("Nhập vào số 2: ");
		int b = scanner.nextInt();
		System.out.println("Nhập vào số 3: ");
		int c = scanner.nextInt();
		System.out.println("Các số vừa nhập là: " + a + " " + b + " " + c);
	}

	private static void question2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình");
		System.out.println("Nhập vào 2 số thực");
		System.out.println("Nhập vào số 1: ");
		float f1 = scanner.nextFloat();
		System.out.println("Nhập vào số 2: ");
		float f2 = scanner.nextFloat();
		System.out.println("Bạn vừa nhập vào các số: " + f1 + " " + f2);
	}

	private static void question3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Question 3: Viết lệnh cho phép người dùng nhập họ và tên");
		System.out.println("Họ: ");
		String s1 = scanner.next();
		System.out.println("Tên: ");
		String s2 = scanner.next();
		System.out.println("Họ tên:" + s1 + " " + s2);
	}

	private static void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ");
		System.out.println("Nhập vào năm sinh: ");
		int year = scanner.nextInt();
		System.out.println("Nhập vào tháng sinh: ");
		int month = scanner.nextInt();
		System.out.println("Nhập vào ngày sinh: ");
		int day = scanner.nextInt();
		LocalDate birthDay = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là: " + birthDay);
	}

	private static void question5() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập thông tin account:");
		Account acc = new Account();
		System.out.println("Nhập ID: ");
		acc.id = scanner.nextInt();
		System.out.println("Nhập email: ");
		acc.email = scanner.next();
		System.out.println("Nhập userName: ");
		acc.userName = scanner.next();
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Nhập fullName: ");
		acc.fullName = scanner2.nextLine();
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Nhập position (Nhập các số từ 1 đến 4: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posNum = scanner3.nextInt();
		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.Dev;
			acc.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.Test;
			acc.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.Scrum_Master;
			acc.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.position = pos4;
			break;
		}
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("Nhap CreateDate (dd/MM/yyyy): ");
		String dateString = scanner4.nextLine();
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		acc.createDate = date;

		System.out.println("Thông tin Acc vừa nhập:\n ID: " + acc.id + "Email: " + acc.email + " UserName: "
				+ acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name + " CreateDate: "+ acc.createDate);
	}

	private static void question6() {
		System.out.println("Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin Department cần tạo:");
		Department dep = new Department();
		System.out.println("Nhập ID: ");
		dep.id = scanner.nextInt();
		System.out.println("Nhập Name: ");
		dep.name = scanner.next();
		System.out.println("Thông tin Department vừa nhập:\n ID: " + dep.id + " Name: " + dep.name);
	}

	private static void question7() {
		System.out.println("Question 7: Nhập số chẵn từ console");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Hãy nhập vào 1 số chẵn(0: Thoát): ");
			int n = scanner.nextInt();
			if (n == 0) {
				return;
			} else if (n % 2 == 0) {
				System.out.println("Bạn vừa nhập vào:" + n);
			} else {
				System.out.println("Nhập sai, đây không phải là số chẵn");
			}
		}
	}

	private static void question8() {
		System.out.println("Question 8: Viết chương trình thực hiện theo flow");
		Scanner scanner = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account,	2. Tạo Department 0. Exit");
			choose = scanner.nextInt();
			if (choose == 1 || choose == 2) {
				switch (choose) {
				case 1:
					question5();
					break;
				case 2:
					question7();
					break;
				}
			} else if (choose == 0) {
				return;
			} else {
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}

	private static void question9() {
		Scanner sc = new Scanner(System.in);
		// Tạo Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing_System";
		group1.createDate = LocalDate.of(2021, 1, 1);
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		group2.createDate = LocalDate.of(2020, 2, 1);
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		group3.createDate = LocalDate.of(2019, 9, 23);
		// Tạo Account
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
		Group[] groupArray = { group1, group2, group3 };
		System.out.println("Bước 1: Danh sách User đang có trên hệ thống: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].userName);
		}
		System.out.println("Bước 2: Nhập vào UserName của account: ");
		String userName = sc.next();
		System.out.println("Bước 3: Danh sách Group đang có trên hệ thống: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(groupArray[i].name);
		}
		System.out.println("Bước 4: Nhập vào tên Group cần thêm: ");
		String groupName = sc.next();
		int indexGroup = -1;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i].name.equals(groupName)) {
				indexGroup = i;
			}
		}
		int indexAccount = -1;
		for (int j = 0; j < accArray.length; j++) {
			if (accArray[j].userName.equals(userName)) {
				indexAccount = j;
			}
		}
		if (indexAccount < 0 || indexGroup < 0) {
			System.out.println("Kiểm tra lại thông tin bạn nhập , không có Account hoặc group này trên hệ thống");
		} else {
			for (int j = 0; j < accArray.length; j++) {
				if (accArray[j].userName.equals(userName)) {
					Group[] groupAdd = { groupArray[indexGroup] };
					accArray[j].groups = groupAdd;
					System.out.println("Bạn vừa Add Group: " + accArray[indexAccount].groups[0].name + " cho Account: "
							+ accArray[indexAccount].userName);
				}
			}
		}
	}

	private static void question10() {
		System.out.println("Question 10: Tiếp tục Question 8 & 9");
		Scanner scanner = new Scanner(System.in);
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3. Add Group vào Account");
			choose = scanner.nextInt();
			if (choose == 1 || choose == 2 || choose == 3) {
				switch (choose) {
				case 1:
					question5();
					break;
				case 2:
					question7();
					break;
				case 3:
					question9();
					break;
				}
				System.out.println("Bạn có muốn tiếp tục không: 1. Có || 0. Exit ");
				choose = scanner.nextInt();
				if (choose == 0) {
					return;
				}
			} else {
				System.out.println("Nhập lại: ");
			}
		}
	}
}