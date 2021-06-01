package com.vti.entity;

import java.io.Serializable;

import com.vti.ultis.ScannerUltis;

public class StudentEx5 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private static int count = 0;
	
	public StudentEx5() {
		this.id = ++count;
		inputName();
	}

	private void inputName() {
		System.out.println("Nhập vào tên sinh viên: ");
		this.name = ScannerUltis.inputString();
	}

	@Override
	public String toString() {
		return "Student [id = " + id + ", name = " + name + " ]";
	}

	
	
}
