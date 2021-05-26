package com.vti.entity;

public class Document {
	public int id;
	public String publisher;
	public int amount;
	@Override
	public String toString() {
		return " id=" + id + ", publisher=" + publisher + ", amount=" + amount + " ";
	}
	
	
}
