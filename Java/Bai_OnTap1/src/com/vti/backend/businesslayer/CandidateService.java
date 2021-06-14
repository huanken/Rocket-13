package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.backend.datalayer.ICandidateRepository;
import com.vti.entity.Candidate.Category;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.JdbcUltis;

public class CandidateService implements ICandidateService{
	private ICandidateRepository candidateRepository;

	public CandidateService() throws FileNotFoundException, IOException {
		candidateRepository = new CandidateRepository();
	}
	@Override
	public boolean isCandidateIdExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.isCandidateIdExists(email);
	}

	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.loginCandidate(email, password);
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createFresherCandidate(firstName, lastName, phone, email, passWord, graduationRank);
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int expInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createExperienceCandidate(firstName, lastName, phone, email, passWord, expInYear, proSkill);
	}

}
