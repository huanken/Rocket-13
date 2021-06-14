package com.vti.entity;

public class FresherCandidate extends Candidate {
	private GraduationRank graduationRank;

	public enum GraduationRank {
		EXCELLENCE, GOOD, FAIR, POOR
	}

	public FresherCandidate(String firstName, String lastName, String phone, String email, String passWord,
			Category category, GraduationRank graduationRank) {
		super(firstName, lastName, phone, email, passWord, category);
		this.graduationRank = graduationRank;
	}

}
