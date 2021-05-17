package com.vti.entity;

import java.time.LocalDate;

public class Exam {
	public int id;
	public String code;
	public String title;
	public CategoryQuestion categoryQuestion;
	public int duration;
	public Account account;
	public LocalDate createDate;
}
