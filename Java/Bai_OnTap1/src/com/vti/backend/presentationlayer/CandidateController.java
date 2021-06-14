package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.CandidateService;
import com.vti.backend.businesslayer.ICandidateService;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateController {
	private ICandidateService candidateService;

	public CandidateController() throws FileNotFoundException, IOException {
		candidateService = new CandidateService();
	}

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String password, int expInYear, ProSkill ProSkill) throws SQLException, ClassNotFoundException {

		return candidateService.createExperienceCandidate(firstName, lastName, phone, email, password, expInYear,
				ProSkill);
	}

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String password, GraduationRank graduationRank) throws SQLException, ClassNotFoundException {

		return candidateService.createFresherCandidate(firstName, lastName, phone, email, password, graduationRank);
	}

	public boolean isCandidateIdExits(String email) throws SQLException, ClassNotFoundException {

		return candidateService.isCandidateIdExists(email);

	}

	public Boolean loginCandidate(String email, String password) throws SQLException, ClassNotFoundException {

		return candidateService.loginCandidate(email, password);
	}

}
