package com.vti.entity;

public class Jounal extends Document {
	private int number;
	private String month;

	@Override
	public String toString() {
		return "Jounal [ " + super.toString() + " number = " + getNumber() + ", month = " + getMonth() + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
