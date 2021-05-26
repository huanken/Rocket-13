package com.vti.entity;


public class Newspaper extends Document {
	public String publishDay;

	@Override
	public String toString() {
		return "Newspaper [ " + super.toString() + " publishDay = " + publishDay + "]";
	}

}