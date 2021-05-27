package com.vti.entity;

public class News implements INews {
	private int id;
	private String title;
	private String PublishDate;
	private String author;
	private String content;
	private float averageRate;
	private int[] rates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public void setRates(int[] rates) {
		this.rates = rates;
	}

	@Override
	public void Display() {
		System.out.println("News [id = " + id + ", title = " + title + ", PublishDate = " + PublishDate + ", author = "
				+ author + ", content = " + content + ", averageRate = " + averageRate + " ]");
	}

	@Override
	public float Calculate() {
		averageRate = (float) ((rates[0] + rates[1] + rates[2]) / 3);
		return averageRate;
	}

}
