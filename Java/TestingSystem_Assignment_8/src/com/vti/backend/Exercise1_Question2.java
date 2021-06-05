package com.vti.backend;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_Question2 {
	Stack<Student> stackStudent;

	public Exercise1_Question2() {
		stackStudent = new Stack<Student>();
		System.out.println("Nhập số sinh viên muốn tạo: ");
		int num2 = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num2; i++) {
			Student st = new Student("Student Ques2 " + (i + 1));
			stackStudent.push(st);
		}
		System.out.println("Tạo thành công " + num2 + " sinh viên.");
	}

	// Question 2: Stack & Queue
	public void question2() {
		while (true) {
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println("1.Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất dùng Stack");
			System.out.println("2.Thứ tự sinh viên theo thứ tự từ muộn nhất đến sớm nhất dùng Stack");
			System.out.println("3.Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất dùng Queue");
			System.out.println("0.Exit");
			System.out.println("-------------------------------------------------");
			System.out.println();
			int selection = 0;
			selection = ScannerUltis.inputIntPositive();
			switch (selection) {
			case 1:
				System.out.println("Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất dùng Stack: ");
				Iterator<Student> iteratorStudent = stackStudent.iterator();
				while (iteratorStudent.hasNext()) {
					Student st = iteratorStudent.next();
					System.out.println(st);
				}
				break;
			case 2:
				System.out.println("Sinh viên đến muộn nhất: " + stackStudent.peek());
				System.out.println("Thứ tự sinh viên theo thứ tự từ muộn nhất đến sớm nhất dùng Stack: ");
				for (int i = 0; i < stackStudent.size(); i++) {
					System.out.println(stackStudent.pop());
				}
				System.out.println("Số sinh viên còn lại trong Stack: " + stackStudent.size());
				break;
			case 3:
				Queue<Student> studentQueue = new LinkedList<Student>();
				System.out.println("Nhập vào số sinh viên muốn quản lý bằng Queue: ");
				int num4 = ScannerUltis.inputIntPositive();
				for (int i = 0; i < num4; i++) {
					Student st4 = new Student("Student Queue " + (i + 1));
					studentQueue.add(st4);
				}
				System.out.println("Đã thêm " + num4 + " sinh viên vào queue thành công.");
				System.out.println("Danh sách sinh viên vừa thêm: " + studentQueue.toString());
				System.out.println(
						"Danh sách sinh viên theo thứ tự từ sớm	nhất tới muộn nhất dùng Poll để lấy dữ liệu: ");
				for (int i = 0; i < num4; i++) {
					System.out.println(studentQueue.poll());
				}
				System.out.println("Danh sách sinh viên còn lại trong Queue: " + studentQueue);
				break;
			case 0:
				return;

			}
		}
	}
}
