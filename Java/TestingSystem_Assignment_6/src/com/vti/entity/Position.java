package com.vti.entity;

import java.util.Scanner;

import com.vti.ultis.ScannerUtils;

public class Position {
	Scanner scanner;
	ScannerUtils scannerUtils;
	private int id;
	private PositionName name;

	public enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	public Position() {
			scanner = new Scanner(System.in);
			inputId();
			inputName();	
		}

	private void inputName() {
		System.out.println("Chọn Position (1.Dev 2.Test 3.Scrum_Master 4.PM): ");
		int seletion = scannerUtils.inputInt("Wrong inputing! Please input a seletion as int, input again.");
		switch (seletion) {
		case 1:
			this.name = PositionName.Dev;
			break;
		case 2:
			this.name = PositionName.Test;
			break;
		case 3:
			this.name = PositionName.Scrum_Master;
			break;
		case 4:
			this.name = PositionName.PM;
			break;
		default:
			System.out.println("Nhập sai!!");
			inputName();
			break;
		}
	}

	private void inputId() {
		System.out.println("Nhập ID Position: ");
		this.id = scannerUtils.inputInt("Wrong inputing! Please input an id as int, input again.");
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	
	
}
