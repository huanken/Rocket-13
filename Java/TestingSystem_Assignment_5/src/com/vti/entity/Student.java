package com.vti.entity;

public class Student implements IStudent {
	private int id;
	private String name;
	private int group;

	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public int getGroup() {
		return group;
	}

	@Override
	public void rollUp() {
		System.out.println(name + " điểm danh");
	}

	@Override
	public void doLearn() {
		System.out.println(name + " đang học bài");
	}

	@Override
	public void doClean() {
		System.out.println(name + " đang dọn vệ sinh");
	}

}
