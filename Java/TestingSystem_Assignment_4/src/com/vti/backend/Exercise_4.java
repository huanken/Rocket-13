package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Student;

public class Exercise_4 {
	ArrayList<Student> students = new ArrayList<>();
		public void question_1() {
			Student student1 = new Student(1, "Huân Ken", "Thái Bình");
			student1.setScore(3);
			student1.addScore(0);
			Student student2 = new Student(1, "Phạm Hà", "Ninh Bình");
			student2.setScore(5);
			student2.addScore(4);
			Student student3 = new Student(1, "Phạm Hằng", "Ninh Bình");
			student3.setScore(5);
			student3.addScore(1);
			Student student4 = new Student(4, "Nguyễn Văn A", "Hà Nội");
			student4.setScore(4);
			students.add(student1);
			students.add(student2);
			students.add(student3);
			students.add(student4);
			for (Student student : students) {
				System.out.println(student.toString());
			}
		}
		
		
}
