package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException;
	
	public boolean createAccount(Account acc) throws SQLException, ClassNotFoundException;
	
	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException;
	
	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException;
	
	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException;
	
	public boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException;
	
	
}
