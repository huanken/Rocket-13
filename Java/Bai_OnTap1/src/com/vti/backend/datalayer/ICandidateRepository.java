package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.Candidate.Category;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public interface ICandidateRepository {
	boolean isCandidateIdExists(String email) throws ClassNotFoundException, SQLException;
	
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email, String passWord, GraduationRank graduationRank) throws SQLException, ClassNotFoundException;
	
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email, String passWord, int expInYear, ProSkill proSkill) throws SQLException, ClassNotFoundException;
}
