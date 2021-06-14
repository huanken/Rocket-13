package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.JdbcUltis;

public class CandidateRepository implements ICandidateRepository {
	private JdbcUltis jdbc;

	public CandidateRepository() throws FileNotFoundException, IOException {
		jdbc = new JdbcUltis();
	}

	@Override
	public boolean isCandidateIdExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Candidate WHERE Email = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Candidate WHERE Email = ? AND Pass = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email,Pass, GraduationRank,TypeCandidate) VALUES (?,?,?,?,?,?,'FresherCandidate');";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, firstName);
		preStatement.setNString(2, lastName);
		preStatement.setNString(3, phone);
		preStatement.setNString(4, email);
		preStatement.setNString(5, passWord);
		preStatement.setNString(6, graduationRank.toString());

		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int expInYear, ProSkill proSkill) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email,Pass, ExpInYear, ProSkill,TypeCandidate) VALUES (?,?,?,?,?,?,?,'ExperienceCandidate');";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, firstName);
		preStatement.setNString(2, lastName);
		preStatement.setNString(3, phone);
		preStatement.setNString(4, email);
		preStatement.setNString(5, passWord);
		preStatement.setInt(6, expInYear);
		preStatement.setNString(7, proSkill.toString());
		
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
