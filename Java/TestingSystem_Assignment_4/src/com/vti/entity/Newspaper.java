package com.vti.entity;


public class Newspaper extends Document {
	private String publishDay;

	@Override
	public String toString() {
		return "Newspaper [ " + super.toString() + " publishDay = " + getPublishDay() + "]";
	}

	public String getPublishDay() {
		return publishDay;
	}

	public void setPublishDay(String publishDay) {
		this.publishDay = publishDay;
	}

}