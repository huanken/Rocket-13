package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.StudentEx3;
import com.vti.ultis.ScannerUltis;

public class Exercise3 {

	// Question 1 -> 5
	public void question1() {
		while (true) {
			loadMenuEx3();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Tạo các đối tượng Student: ");
				StudentEx3<Integer> studentInt = new StudentEx3<Integer>(1, "studentInt");
				StudentEx3<Float> studentFloat = new StudentEx3<Float>(2.0f, "studentFloat");
				StudentEx3<Double> studentDouble = new StudentEx3<Double>(3.0, "StudentDouble");
				System.out.println("Danh sách sinh viên đã được	tạo");
				System.out.println(studentInt);
				System.out.println(studentFloat);
				System.out.println(studentDouble);
				break;
			case 2:
				System.out.println("Nhập vào 1 số nguyên: ");
				printByT_Type(ScannerUltis.inputInt());
				System.out.println("Nhập vào 1 số Float: ");
				printByT_Type(ScannerUltis.inputFloat());
				System.out.println("Nhập vào 1 số Double: ");
				printByT_Type(ScannerUltis.inputDouble());
				System.out.println("In đối tượng: ");
				StudentEx3<Integer> studentT = new StudentEx3<Integer>(10, "StudentTGenneric");
				printByT_Type(studentT);
				break;
			case 3:
				Integer[] intArray = { 1, 5, 2, 7, 8 };
				Float[] floatArray = { 1.2f, 5.3f, 2f, 7.8f, 8.2f };
				Double[] doubleArray = { 1.2, 5.3, 2.2, 7.8, 8.2 };
				printByE_Type(intArray);
				printByE_Type(floatArray);
				printByE_Type(doubleArray);
				break;
			case 4:
				System.out.println("Tạo Employee 1 --> OK");
				Integer[] salInt = { 1000, 2000, 3000 };
				Employee<Integer> emInt = new Employee<Integer>("EmployeeInt", salInt);
				System.out.println("Tạo Employee 2 --> OK");
				Float[] salFloat = { 1000f, 2000f, 3000f };
				Employee<Float> emFloat = new Employee<Float>("EmployeeFloat", salFloat);
				System.out.println("Tạo Employee 3 --> OK");
				Double[] salDouble = { 1000.1, 2000.2, 3000.3 };
				Employee<Double> emDouble = new Employee<Double>("EmployeeInt", salDouble);
				System.out.println("Thông tin các Employee vừa tạo là:");
				System.out.println(emInt);
				System.out.println(emFloat);
				System.out.println(emDouble);
				System.out.println("Thông tin tháng lương cuối cùng:");
				System.out.println(emInt.getLastSalary());
				System.out.println(emFloat.getLastSalary());
				System.out.println(emDouble.getLastSalary());
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}

	private void loadMenuEx3() {
		System.out.println("--- Exercise 3. ");
		System.out.println("--- 1. Question1 ");
		System.out.println("--- 2. Question2 ");
		System.out.println("--- 3. Question4 ");
		System.out.println("--- 4. Question5 ");
		System.out.println("--- 5.Exit ");
	}

	private <T> void printByT_Type(T var) {
		System.out.println("In bởi T_Generic: " + var);
	}

	private <E> void printByE_Type(E[] arr) {
		System.out.println("Phần tử trong mảng là: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

	// Question 6
	public void question6() {
		MyMap<Integer, String> Student = new MyMap<Integer, String>(1, "Student");
		System.out.println("Thông tin sinh viên khởi tạo: " + Student);
		while (true) {
			loadMenuquestion6();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Lấy Value trong MyMap: " + Student.getValue());
				break;
			case 2:
				System.out.println("Lấy Key trong MyMap: " + Student.getKey());
				break;
			case 3:
				return;
			default:
				System.out.println("Chọn lại:");
				break;
			}
		}
	}

	private void loadMenuquestion6() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("1.Get Value ");
		System.out.println("2.Get Key ");
		System.out.println("3.Exit ");
		System.out.println("----------------------------------");
		System.out.println();
	}

	// Question 7
	public void question7() {
		while (true) {
			loadMenuquestion7();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Chương trình với key là Email: ");
				Phone<String, String> phone1 = new Phone<String, String>("Email1", "090-001");
				Phone<String, String> phone2 = new Phone<String, String>("Email2", "090-002");
				Phone<String, String> phone3 = new Phone<String, String>("Email3", "090-003");
				Phone<String, String> phone4 = new Phone<String, String>("Email4", "090-004");
				Phone<String, String> phone5 = new Phone<String, String>("Email5", "090-005");
				System.out.println("Thông tin Phone trong hệ thống");
				System.out.println("Key: " + phone1.getKey() + " Value: " + phone1.GetPhoneNumber());
				System.out.println("Key: " + phone2.getKey() + " Value: " + phone2.GetPhoneNumber());
				System.out.println("Key: " + phone3.getKey() + " Value: " + phone3.GetPhoneNumber());
				System.out.println("Key: " + phone4.getKey() + " Value: " + phone4.GetPhoneNumber());
				System.out.println("Key: " + phone5.getKey() + " Value: " + phone5.GetPhoneNumber());
				break;
			case 2:
				System.out.println("Chương trình với key là số thứ tự: ");
				Phone<Integer, String> phone_num1 = new Phone<Integer, String>(1, "090-001");
				Phone<Integer, String> phone_num2 = new Phone<Integer, String>(2, "090-002");
				Phone<Integer, String> phone_num3 = new Phone<Integer, String>(3, "090-003");
				Phone<Integer, String> phone_num4 = new Phone<Integer, String>(4, "090-004");
				Phone<Integer, String> phone_num5 = new Phone<Integer, String>(5, "090-005");
				System.out.println("Thông tin Phone trong hệ thống");
				System.out.println("Key: " + phone_num1.getKey() + " Value: " + phone_num1.GetPhoneNumber());
				System.out.println("Key: " + phone_num2.getKey() + " Value: " + phone_num2.GetPhoneNumber());
				System.out.println("Key: " + phone_num3.getKey() + " Value: " + phone_num3.GetPhoneNumber());
				System.out.println("Key: " + phone_num4.getKey() + " Value: " + phone_num4.GetPhoneNumber());
				System.out.println("Key: " + phone_num5.getKey() + " Value: " + phone_num5.GetPhoneNumber());
				break;
			case 3:
				System.out.println("Chương trình với key là Username:");
				Phone<String, String> phone_name1 = new Phone<String, String>("User_Name_1", "090-001");
				Phone<String, String> phone_name2 = new Phone<String, String>("User_Name_2", "090-002");
				Phone<String, String> phone_name3 = new Phone<String, String>("User_Name_3", "090-003");
				Phone<String, String> phone_name4 = new Phone<String, String>("User_Name_4", "090-004");
				Phone<String, String> phone_name5 = new Phone<String, String>("User_Name_5", "090-005");
				System.out.println("Thông tin Phone trong hệ thống");
				System.out.println("Key: " + phone_name1.getKey() + " Value: " + phone_name1.GetPhoneNumber());
				System.out.println("Key: " + phone_name2.getKey() + " Value: " + phone_name2.GetPhoneNumber());
				System.out.println("Key: " + phone_name3.getKey() + " Value: " + phone_name3.GetPhoneNumber());
				System.out.println("Key: " + phone_name4.getKey() + " Value: " + phone_name4.GetPhoneNumber());
				System.out.println("Key: " + phone_name5.getKey() + " Value: " + phone_name5.GetPhoneNumber());
				break;
			case 4:
				return;
			default:
				System.out.println("Chọn lại: ");
				break;
			}
		}
	}

	private void loadMenuquestion7() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("1.Map Phone với key là Email");
		System.out.println("2.Map Phone với key là STT");
		System.out.println("3.Map Phone với key là Username");
		System.out.println("4.Exit ");
		System.out.println("----------------------------------");
		System.out.println();
	}

	//Question 8
	public void question8() {
		Staff<Integer> staffInt = new Staff<Integer>(1, "StaffInt");
		Staff<Long> staffLong = new Staff<Long>(2000000000L, "staffLong");
		while (true) {
			loadMenuquestion8();
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Thông tin ID: ");
				System.out.println("Nhân viên staffInt: " + staffInt.getID());
				System.out.println("Nhân viên staffLong: " + staffLong.getID());
				break;
			case 2:
				System.out.println("Thông tin Value: ");
				System.out.println("Nhân viên staffInt: " + staffInt.getValue());
				System.out.println("Nhân viên staffLong: " + staffLong.getValue());
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	private void loadMenuquestion8() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("1.Get ID ");
		System.out.println("2.Get Name ");
		System.out.println("3.Exit ");
		System.out.println("----------------------------------");
		System.out.println();
	}
}
