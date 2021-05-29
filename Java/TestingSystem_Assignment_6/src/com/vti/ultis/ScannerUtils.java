package com.vti.ultis;

import java.util.Scanner;

public class ScannerUtils {
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
	
				Scanner scanner = new Scanner(System.in);
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				return Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static String inputString(String errorMessage) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			if (!inputString.isEmpty()) {
				return inputString;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	

	

}
