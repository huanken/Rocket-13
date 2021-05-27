package com.vti.entity;

public class Document {
	private int id;
	private String publisher;
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return " id = " + getId() + ", publisher = " + publisher + ", amount = " + amount + " ";
	}

}
