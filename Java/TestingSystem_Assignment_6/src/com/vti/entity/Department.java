package com.vti.entity;

import java.util.Scanner;

import com.vti.ultis.ScannerUtils;

public class Department {
	Scanner scanner;
	ScannerUtils scannerUtils;
	private int id;
	private String name;
	
	public Department() {
		scanner = new Scanner(System.in);
		inputId();
		inputName();	
	}

	private void inputName() {
		System.out.println("Nhập tên Department: ");
		this.name = scannerUtils.inputString("Wrong inputing! Please input a name as String, input again.");

	}

	private void inputId() {
		System.out.println("Nhập ID Department: ");
		this.id = scannerUtils.inputInt("Wrong inputing! Please input an id as int, input again.");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	
	
	
}
