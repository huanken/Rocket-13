package com.vti.backend;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_Question3 {
	Set<Student> studentSet = new HashSet<Student>();

	// Question 3: Set
	public void question3() {
		while (true) {
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println("1.Thêm student vào set ");
			System.out.println("2.In ra số phần tử của set ");
			System.out.println("3.Tìm kiếm student theo id ");
			System.out.println("4.Xóa student bằng id ");
			System.out.println("--------------------------------------------------------");
			System.out.println();
			int selection = 0;
			selection = ScannerUltis.inputIntPositive();
			switch (selection) {
			case 1:
				System.out.println("Nhập số sinh viên muốn tạo: ");
				int num2 = ScannerUltis.inputIntPositive();
				for (int i = 0; i < num2; i++) {
					Student stSet = new Student("Student Ques3 " + (i + 1));
					studentSet.add(stSet);
				}
				System.out.println("Tạo thành công " + studentSet.size() + " sinh viên.");
				Iterator<Student> iteratorSet = studentSet.iterator();
				for (int i = 0; i < studentSet.size(); i++) {
					System.out.println(iteratorSet.next());
				}
				break;
			case 2:
				System.out.println("Tổng số phần tử trong Set: " + studentSet.size());
				break;
			case 3:
				System.out.println("Nhập vào ID cần tìm kiếm: ");
				int id6 = ScannerUltis.inputIntPositive();
				Iterator<Student> i6 = studentSet.iterator();
				for (int i = 0; i < studentSet.size(); i++) {
					Student stFind = i6.next();
					if (stFind.getId() == id6) {
						System.out.println(stFind);
					}
				}
				break;
			case 4:
				System.out.println("Nhập vào ID của sinh viên cần xóa khỏi danh sách: ");
				int id4 = ScannerUltis.inputIntPositive();
				Iterator<Student> iterator = studentSet.iterator();
				while (iterator.hasNext()) {
					Student st = (Student) iterator.next();
					if (st.getId() == id4) {
						iterator.remove();
					}
				}
				System.out.println("Set sau khi xóa: ");
				printSet();
			}
		}
	}

	private void printSet() {
		for (Student student : studentSet) {
			System.out.println(student);
		}
	}
}
