package com.vti.backend;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_Question6 {
	Map<Integer, String> studentMap = new HashMap<Integer, String>();

	// Question 6: Map
	public void question6() {
		while (true) {
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println("1.Thêm student vào map ");
			System.out.println("2.In ra các key của map ");
			System.out.println("3.In ra các value của map ");
			System.out.println("4.In ra danh sách student sắp xếp theo tên ");
			System.out.println("5.Chuyển map student sang set ");
			System.out.println("---------------------------------------------");
			System.out.println();
			int selection = 0;
			selection = ScannerUltis.inputIntPositive();
			switch (selection) {
			case 1:
				System.out.println("Nhập số sinh viên muốn tạo: ");
				int num1 = ScannerUltis.inputIntPositive();
				for (int i = 0; i < num1; i++) {
					System.out.println("Nhập vào Student " + (i + 1) + ": ");
					System.out.println("Nhập vào tên: ");
					String name = ScannerUltis.inputString();
					studentMap.put(++Student.count, name);
				}
				System.out.println("Danh sách sinh viên trong MAP: ");
				for (Map.Entry<Integer, String> mapStudent : studentMap.entrySet()) {
					System.out.println("ID: " + mapStudent.getKey() + " Name: " + mapStudent.getValue());
				}
				break;
			case 2:
				for (Map.Entry<Integer, String> student : studentMap.entrySet()) {
					System.out.println(student.getKey());
				}
				break;
			case 3:
				for (Map.Entry<Integer, String> student : studentMap.entrySet()) {
					System.out.println(student.getValue());
				}
				break;
			case 4:
				System.out.println("Map chưa sort: ");
				for (Map.Entry<Integer, String> mapStudent : studentMap.entrySet()) {
					System.out.println("ID: " + mapStudent.getKey() + " Name: " + mapStudent.getValue());
				}
				System.out.println("Map đã sort theo name: ");
				// Create a list from elements of HashMap
				List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(
						studentMap.entrySet());

				// Sort the list
				Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
					public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
						return (o1.getValue()).compareTo(o2.getValue());
					}
				});

				// put data from sorted list to hashmap
				HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>();
				for (Map.Entry<Integer, String> aa : list) {
					temp.put(aa.getKey(), aa.getValue());
				}
				for (Map.Entry<Integer, String> mapStudent : temp.entrySet()) {
					System.out.println("ID: " + mapStudent.getKey() + " Name: " + mapStudent.getValue());
				}
				break;
			case 5:
				//Convert Map keys to Set
		        Set<Integer> keySet= new HashSet<Integer>(studentMap.keySet());
		        keySet.forEach(key-> System.out.println(key));

		        //Convert Map values to Set
		        Set<String> valueSet= new HashSet<String>(studentMap.values());
		        valueSet.forEach(value-> System.out.println(value));
		        break;
			}
		}
	}
}
