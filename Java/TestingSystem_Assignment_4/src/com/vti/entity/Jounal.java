package com.vti.entity;

public class Jounal extends Document {
	public int number;
	public String month;

	@Override
	public String toString() {
		return "Jounal [ " + super.toString() + " number = " + number + ", month = " + month + "]";
	}

}
