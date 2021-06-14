package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Account.TypeAccount;
import com.vti.entity.Manager;
import com.vti.ultis.JdbcUltis;

public class AccountRepository implements IAccountRepository {

	private JdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new JdbcUltis();
	}

	@Override
	public List<Manager> getListManager()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT ID,FullName,Email,Password,ExpInYear,ProjectID FROM account WHERE TypeAccount = 'Manager' ORDER BY ID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Manager> listManager = new ArrayList<Manager>();
		while (resultSet.next()) {
			Manager acc = new Manager();
			acc.setId(resultSet.getInt(1));
			acc.setFullName(resultSet.getString(2));
			acc.setEmail(resultSet.getString(3));
			acc.setPassWord(resultSet.getString(4));
			acc.setExpInYear(resultSet.getInt(5));
			acc.setProjectID(resultSet.getInt(6));
			listManager.add(acc);
		}
		return listManager;
	}

	@Override
	public boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE Email = ? AND Password = ?";
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
	public List<Account> getAccountByProjectID(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "SELECT a.ID,a.FullName,a.Email,a.Password,a.TypeAccount,a.ProjectID FROM account a INNER JOIN project p ON a.ProjectID = p.ID WHERE p.ID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		List<Account> listAccount = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setFullName(resultSet.getString(2));
			acc.setEmail(resultSet.getString(3));
			acc.setPassWord(resultSet.getString(4));
			String typeAccount = resultSet.getString(5);
			acc.setTypeAccount(TypeAccount.valueOf(typeAccount));
			acc.setProjectID(resultSet.getInt(6));
			listAccount.add(acc);
		}
		return listAccount;
	}

}
