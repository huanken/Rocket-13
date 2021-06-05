package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.StudentEx2;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	public void question1() {
		List<StudentEx2> listStudentEx2 = new ArrayList<StudentEx2>();
		while (true) {
			loadMenuEx2Que1();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Nhập vào số sinh viên: ");
				int num2 = ScannerUltis.inputIntPositive();
				for (int i = 0; i < num2; i++) {
					System.out.println("Nhập sinh viên " + (1) + ": ");
					System.out.println("Nhập vào tên: ");
					String nameStudent = ScannerUltis.inputString();
					System.out.println("Nhập vào năm sinh");
					LocalDate birthStudent = ScannerUltis.inputLocalDate();
					System.out.println("Nhập vào điểm: ");
					int scoreStudent = ScannerUltis.inputIntPositive();
					StudentEx2 stex2 = new StudentEx2(nameStudent, birthStudent, scoreStudent);
					listStudentEx2.add(stex2);
				}
				System.out.println("Danh sách sinh viên vừa nhập: ");
				for (StudentEx2 studentEx2 : listStudentEx2) {
					System.out.println(studentEx2);
				}
				break;
			case 2:
				Collections.sort(listStudentEx2);
				System.out.println("Danh sách sinh viên sau khi sắp xếp theo tên: ");
				for (StudentEx2 studentEx2 : listStudentEx2) {
					System.out.println(studentEx2);
				}
				break;
			case 3:
				Collections.sort(listStudentEx2);
				System.out.println("Danh sách sinh viên sau khi sắp xếp theo tên, điểm, ngày sinh: ");
				for (StudentEx2 studentEx2 : listStudentEx2) {
					System.out.println(studentEx2);
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Nhập lại: ");
				break;
			}
		}
	}

	private void loadMenuEx2Que1() {
		System.out.println("--- Question 6 7: ");
		System.out.println("--- 1. Tạo danh sách sinh viên ");
		System.out.println("--- 2. Sắp xếp danh sách theo name ");
		System.out.println("--- 3. Sắp xếp theo name, ngày sinh, điểm ");
		System.out.println("--- 4.Exit ");
	}
}