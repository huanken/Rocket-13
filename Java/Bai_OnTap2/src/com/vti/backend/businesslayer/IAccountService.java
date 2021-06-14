package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Manager;

public interface IAccountService {
	public List<Manager> getListManager()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	public boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException;

	public List<Account> getAccountByProjectID(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
