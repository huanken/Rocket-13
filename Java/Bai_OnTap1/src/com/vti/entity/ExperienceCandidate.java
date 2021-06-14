package com.vti.entity;

public class ExperienceCandidate extends Candidate{
	private int expInYear;
	private ProSkill proSkill;
	public enum ProSkill{
		DEV,TEST,JAVA,SQL
	}
	
	public ExperienceCandidate(String firstName, String lastName, String phone, String email, String passWord,
			Category category, int expInYear, ProSkill proSkill) {
		super(firstName, lastName, phone, email, passWord, category);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}
	
}
