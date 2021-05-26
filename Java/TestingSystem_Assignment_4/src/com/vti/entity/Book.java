package com.vti.entity;

public class Book extends Document {
	public String author;
	public int numberOfPages;

	@Override
	public String toString() {
		return "Book [ " + super.toString() + " authorString = " + author + ", numberOfPages = " + numberOfPages + " ]";
	}

}
