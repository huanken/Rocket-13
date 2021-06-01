package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1 {
	List<Student> students = new ArrayList<Student>();
	
	//Question 1
	public void question1() {
		Student student1 = new Student("Nguyễn Văn A");
		Student student2 = new Student("Nguyễn Văn B");
		Student student3 = new Student("Nguyễn Văn C");
		students.add(student1);
		students.add(student2);
		students.add(student3);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("Chuyển các sinh viên sang đại học công nghệ");
		Student.setCollege("Đại học công nghệ");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	//Question 2
	public void question2() {
		for (Student student : students) {
			System.out.println("Student " + student.getId() + " nộp quỹ lớp 100k!");
			Student.moneyGroup += 100;
		}
		System.out.println("Quỹ lớp hiện tại là: " + Student.moneyGroup);

		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50));
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20));
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
		System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k:");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));
	}

	//Question 3
	public void question3() {
		System.out.println("Nhập vào số int 1:");
		int a = ScannerUltis.inputInt();
		System.out.println("Nhập vào số int 2:");
		int b = ScannerUltis.inputInt();
		System.out.println("Max a và b: " + MyMath.max(a, b));
		System.out.println("Min a và b: " + MyMath.min(a, b));
		System.out.println("Sum a và b: " + MyMath.sum(a, b));
	}

	//Question 5
	public void question5() {
		System.out.println("Số học sinh được sinh ra: " + Student.getCount());
	}

	//Question 6
	public void question6() {
		System.out.println("Tạo 2 Primary Student: ");
		PrimaryStudent pSt1 = new PrimaryStudent();
		PrimaryStudent pSt2 = new PrimaryStudent();
		System.out.println("Tạo 6 Secondary Student: ");
		SecondaryStudent sST1 = new SecondaryStudent();
		SecondaryStudent sST2 = new SecondaryStudent();
		SecondaryStudent sST3 = new SecondaryStudent();
		SecondaryStudent sST4 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên");
		String leftAlignFormat = "| %-18s | %-4d |%n";
		System.out.format("+--------------------+------+%n");
		System.out.format("| Category 	     |  SL  |%n");
		System.out.format("+--------------------+------+%n");
		System.out.format(leftAlignFormat, "Student", Student.getCount());
		System.out.format(leftAlignFormat, "PrimaryStudent", PrimaryStudent.COUNTPrimary);
		System.out.format(leftAlignFormat, "SecondaryStudent", SecondaryStudent.COUNTSecondary);
		System.out.format("+--------------------+------+%n");
	}

	//Question 7
	public void question7() {
		SecondaryStudent sST1 = new SecondaryStudent();
		SecondaryStudent sST2 = new SecondaryStudent();
		SecondaryStudent sST3 = new SecondaryStudent();
		SecondaryStudent sST4 = new SecondaryStudent();
		SecondaryStudent sST5 = new SecondaryStudent();
		SecondaryStudent sST6 = new SecondaryStudent();
		SecondaryStudent sST7 = new SecondaryStudent();
		SecondaryStudent sST8 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên");
		System.out.println("Student" + Student.getCount());
		System.out.println("PrimaryStudent" + PrimaryStudent.COUNTPrimary);
		System.out.println("SecondaryStudent" + SecondaryStudent.COUNTSecondary);
	}

	//Question 8
	public void question8() throws Exception {
		HinhChuNhat[] hcns = new HinhChuNhat[4];
		for (int i = 0; i < 4; i++) {
			System.out.println("Hình " + (i + 1) + ":");
			System.out.println("Canh a: ");
			Float a = ScannerUltis.inputFloat();
			System.out.println("Canh b: ");
			Float b = ScannerUltis.inputFloat();
			HinhChuNhat hcn = new HinhChuNhat(a, b);
			hcns[i] = hcn;
		}
		System.out.println("Tạo hình tròn số 1, nhập vào bán kính ");
		Float r1 = ScannerUltis.inputFloat();
		HinhTron hinhtron1 = new HinhTron(r1, r1);
		System.out.println("Tạo hình tròn số 2, nhập vào bán kính ");
		Float r2 = ScannerUltis.inputFloat();
		HinhTron hinhtron2 = new HinhTron(r2, r2);
	}
	
	
}
