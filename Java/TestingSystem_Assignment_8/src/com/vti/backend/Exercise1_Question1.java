package com.vti.backend;

import java.util.List;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise1_Question1 {
	List<Student> listStudent;

	//Question 1: List
	public Exercise1_Question1() {
		listStudent = new ArrayList<Student>();
		System.out.println("Nhập số sinh viên muốn thêm: ");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num - 3; i++) {
			Student st = new Student("Student " + (i + 1));
			listStudent.add(st);
		}
		Student st1 = new Student("Student Name");
		Student st2 = new Student("Student Name");
		Student st3 = new Student("Student Name");
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);
	}

	public void question1() {
		while (true) {
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println("1.Thêm student");
			System.out.println("2.Số phần tử list student");
			System.out.println("3.Lấy ra phần tử thứ 4 của list students");
			System.out.println("4.In ra phần tử đầu và cuối của list students");
			System.out.println("5.Thêm 1 phần tử vào vị trí đầu của students");
			System.out.println("6.Thêm 1 phần tử vào vị trí cuối của students");
			System.out.println("7.Đảo ngược vị trí của students");
			System.out.println("8.Tìm kiếm student theo id");
			System.out.println("9.Tìm kiếm student theo name");
			System.out.println("10.In ra các student có trùng tên");
			System.out.println("11.Xóa name của student có id = 2");
			System.out.println("12.Delete student có id = 5");
			System.out.println("13.Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies");
			System.out.println("0.Exit");
			System.out.println("----------------------------------------");
			System.out.println();
			int selection = 0;
			selection = ScannerUltis.inputIntPositive();
			switch (selection) {
			case 1:
				System.out.println("Nhập thông tin Student thứ " + (Student.count + 1) + " :");
				System.out.println("Nhập tên Student: ");
				String name = ScannerUltis.inputString();
				Student studentx = new Student(name);
				listStudent.add(studentx);
				break;
			case 2:
				System.out.println("Tổng số phần tử của list students : " + listStudent.size());
				break;
			case 3:
				try {
					System.out.println("Phần tử thứ 4 của list students : " + listStudent.get(3));
				} catch (IndexOutOfBoundsException e) {
					System.err.println("Không có phần tử đó");
				}
				break;
			case 4:
				System.out.println("Phần tử đầu tiên : " + listStudent.get(0));
				System.out.println("Phần tử cuối cùng : " + listStudent.get(listStudent.size() - 1));
				break;
			case 5:
				System.out.println("Nhập thông tin Student vào đầu danh sách:");
				System.out.println("Nhập tên Student: ");
				String name2 = ScannerUltis.inputString();
				Student studenty = new Student(name2);
				listStudent.add(0, studenty);
				break;
			case 6:
				System.out.println("Nhập thông tin Student vào cuối danh sách:");
				System.out.println("Nhập tên Student: ");
				String name3 = ScannerUltis.inputString();
				Student studentz = new Student(name3);
				listStudent.add(studentz);
				break;
			case 7:
				System.out.println("Danh sách sau khi đảo ngược: ");
				Collections.reverse(listStudent);
				for (Student student4 : listStudent) {
					System.out.println(student4);
				}
				break;
			case 8:
				int count = 0;
				System.out.println("Nhập id cần tìm kiếm: ");
				int id = ScannerUltis.inputInt();
				for (Student student4 : listStudent) {
					if (id == student4.getId()) {
						System.out.println(student4);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("Không có student nào có id này");
				}
				break;
			case 9:
				int countName = 0;
				System.out.println("Nhập name cần tìm kiếm: ");
				String nameString = ScannerUltis.inputString();
				for (Student student4 : listStudent) {
					if (student4.getName().equals(nameString)) {
						System.out.println(student4);
						countName++;
					}
				}
				if (countName == 0) {
					System.out.println("Không có student nào có name này");
				}
				break;
			case 10:
				System.out.println("Các sinh viên trùng tên: ");
				for (int i = 0; i < listStudent.size(); i++) {
					for (int j = i + 1; j < listStudent.size(); j++) {
						if (listStudent.get(i).getName().equals(listStudent.get(j).getName())) {
							System.out.println(listStudent.get(i).toString());
						}
					}
				}
				break;
			case 11:
				System.out.println("Nhập vào ID cần xóa tên:");
				int id10 = ScannerUltis.inputIntPositive();
				for (Student student4 : listStudent) {
					if (student4.getId() == id10) {
						student4.setName(null);
					}
				}
				printStudent();
				break;
			case 12:
				System.out.println("Nhập vào ID của student cần	xóa:");
				int id11 = ScannerUltis.inputIntPositive();
				Iterator<Student> iterator = listStudent.iterator();
				while (iterator.hasNext()) {
					Student student4 = (Student) iterator.next();
					if (student4.getId() == id11) {
						iterator.remove();
					}
				}
				printStudent();
				break;
			case 13:
				System.out.println("Tạo mới ArrayCopy:");
				List<Student> arrayCopy = new ArrayList<Student>();
				arrayCopy.addAll(listStudent);
				System.out.println("In phần tử trong ArrayCopy: ");
				for (Student student : arrayCopy) {
					System.out.println(student);
				}
				break;
			case 0:
				return;
			default:
				System.out.println("Nhập lại");
				break;
			}
		}
	}

	private void printStudent() {
		for (Student student : listStudent) {
			System.out.println(student);
		}
	}
}
