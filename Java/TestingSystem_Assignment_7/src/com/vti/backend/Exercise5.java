package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.StudentEx5;
import com.vti.ultis.IOManager;

public class Exercise5 {
	private List<StudentEx5> students;
	private String pathFile;

	public Exercise5() {
		students = new ArrayList<>();
		pathFile = "C:\\Users\\LaptopK1\\Desktop\\Test\\StudentInformation.txt";
	}
	
	//Question 1
	public void question1() throws Exception {
		for (int i = 0; i < 3; i++) {
			students.add(new StudentEx5());
		}
		writeStudents();
		readStudents();
		
	}
	public void writeStudents() throws Exception {
		IOManager.writeObject(students, pathFile);
	}

	@SuppressWarnings("unchecked")
	public void readStudents() throws Exception {
		students = (List<StudentEx5>) IOManager.readObject(pathFile);
		for (StudentEx5 student : students) {
			System.out.println(student);
		}
	}
	
	//Question 2
	public void question2() {
		
	}
}