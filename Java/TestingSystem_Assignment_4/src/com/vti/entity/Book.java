package com.vti.entity;

public class Book extends Document {
	private String author;
	private int numberOfPages;

	@Override
	public String toString() {
		return "Book [ " + super.toString() + " authorString = " + getAuthor() + ", numberOfPages = "
				+ getNumberOfPages() + " ]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
