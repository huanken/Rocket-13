package com.vti.entity;


public class Student {
	private int id;
	private String name;
	private String homeTown;
	private int score;

	public Student(int id, String name, String homeTown) {
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.score = 0;
	}

	public void setScore(int i) {
		this.score = i;
	}

	public void addScore(int addScore) {
		this.score += addScore;
	}

	@Override
	public String toString() {
		String scoreString = "";
		if (this.score >= 8) {
			scoreString = "Giỏi";
		} else if (this.score < 8 && this.score >= 6) {
			scoreString = "Khá";
		} else if (this.score < 6 && this.score >= 4) {
			scoreString = "Trung Bình";
		} else {
			scoreString = "Yếu";
		}
		return "Student [id = " + id + ", name = " + name + ", HomeTown = " + homeTown + ", ability = " + scoreString	+ " ]";
	}

}
