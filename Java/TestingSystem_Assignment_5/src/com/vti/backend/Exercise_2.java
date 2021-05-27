package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhVuong;
import com.vti.entity.MyMath;
import com.vti.entity.Smart;
import com.vti.entity.Student;
import com.vti.entity.Studentt;
import com.vti.entity.Traditional;

public class Exercise_2 {
	private Student[] students;

	public Exercise_2() {
		students = new Student[10];
	}

	public void question_1() {
		students[0] = new Student(1, "Nguyễn Văn A", 1);
		students[1] = new Student(2, "Nguyễn Văn B", 1);
		students[2] = new Student(3, "Nguyễn Văn C", 1);
		students[3] = new Student(4, "Nguyễn Văn E", 2);
		students[4] = new Student(5, "Nguyễn Sinh Huân", 2);
		students[5] = new Student(6, "Nguyễn Thị Hà", 2);
		students[6] = new Student(7, "Phạm Thu Hà", 2);
		students[7] = new Student(8, "Nguyễn Văn G", 3);
		students[8] = new Student(9, "Nguyễn Thị D", 3);
		students[9] = new Student(10, "Nguyễn Trần Văn A", 3);
		rollUp();
		doLearning();
		doCleaning();
	}

	public void rollUp() {
		for (Student student : students) {
			student.rollUp();
		}
	}

	public void doLearning() {
		for (Student student : students) {
			if (student.getGroup() == 1) {
				student.doLearn();
			}
		}
	}

	public void doCleaning() {
		for (Student student : students) {
			if (student.getGroup() == 2) {
				student.doClean();
			}
		}
	}

	public void question_2() {
		Studentt studentt = new Studentt();
		studentt.inputInfo();
		studentt.showInfo();
		studentt.scholarShip();
	}

	public void question_3() {
		HinhChuNhat hinhChuNhat = new HinhChuNhat();
		HinhVuong hinhVuong = new HinhVuong();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập chiều dài hcn: "); float a =  scanner.nextFloat() ;
		System.out.println("Nhập chiều rộng hcn: "); float b =  scanner.nextFloat() ;
		System.out.println("Chu vi hình chữ nhật : " + hinhChuNhat.tinhChuVi(a, b));
		System.out.println("Diện tích hình chữ nhật : " + hinhChuNhat.tinhDienTich(a, b));
		System.out.println("Nhập cạnh hình vuông: "); float c = scanner.nextFloat();
		System.out.println("Chu vi hình vuông: " + hinhVuong.tinhChuVi(c));
		System.out.println("Diện tích hình vuông:" + hinhVuong.tinhDienTich(c));
	}
	
	public void question_4() {
		MyMath math = new MyMath();
		System.out.println(math.sum(1, 2));
		System.out.println(math.sum(2.5f, 3.0f));
	
	}

	public void question_5() {
		Smart smart = new Smart();
		Traditional traditional = new Traditional();
		smart.goi();
		smart.chupHinh();
		smart.goiDien3G();
		traditional.nghe();
		traditional.ngheRadio();
	}
}
