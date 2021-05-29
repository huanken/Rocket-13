package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.InvalidAgeInputingException;
import com.vti.ultis.ScannerUtils;

public class Exercise2 {
	static ScannerUtils scannerUtils = new ScannerUtils();
	//Question 1
	public void question1() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.err.println("Cann't divide 0");
		}
	}

	private static float divide(int i, int j) {
		return i / j;
	}
	
	//Question 2
	public void question2() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.err.println("Cann't divide 0");
		} finally {
			System.out.println("Divide completed!");
		}
	}

	//Question 3
	public void question3() {
		int[] numbers = { 1, 2, 3 };
		try {
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Không có phần tử đó!!!");
		}
	}

	//Question 4
	static String[] departments = { "Sale", "Marketing", "Dep3" };
	public void question4() {
		getIndex(0);
		getIndex(1);
		getIndex(5);
		getIndex(2);
	}

	private static void getIndex(int index) {
		try {
			System.out.println(departments[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Cannot find department !");
		}
	}
	
	//Question 5
	public static int inputAge() {
		while (true) {
			System.out.println("Nhập tuổi: ");
			int age = scannerUtils.inputInt("Wrong inputing! Please input an age as int, input again.");

			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

			} else {
				return age;
			}
		}
	}
	public void question5() {
		int age = inputAge();
		System.out.println("Tuổi của bạn: " + age);
	}	
	
	// Question 9
	public void question9() {
		Department department = new Department();
		System.out.println(department);
		
		Position position = new Position();
		System.out.println(position);
	}
	
	// Question 10
	public void question10() throws InvalidAgeInputingException {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		int choose = 1 ;
		do {
			Account acounti = new Account();
			accounts.add(acounti);
			for (Account account : accounts) {
				System.out.println(account);
			}
			System.out.println("Bạn có muốn thêm account không ? 1.Có || Số khác.Không ");
			choose = scanner.nextInt();
		} while (choose == 1);
	}
	
	// Question 11
	public static int inputAge(String errorMessage) throws InvalidAgeInputingException{
		while (true) {
			while (true) {
					Scanner scanner = new Scanner(System.in);
					int age = Integer.parseInt(scanner.nextLine());
					if (age <= 0) {
						throw new InvalidAgeInputingException(errorMessage);
					}
					else {
						return age;
					}
			}
		}
	}
	
	// Question 12
	public static int inputAccountAge(String errorMessage) throws InvalidAgeInputingException {
		while (true) {
			System.out.println("Nhập tuổi: ");
			int age = scannerUtils.inputInt("Wrong inputing! Please input an age as int, input again.");
			if (age <= 18) {
				System.err.println("Your age must be greater than 18");

			} else {
				return age;
			}
			
		}
	}
}
