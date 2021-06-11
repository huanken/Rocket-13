package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}

	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.getListAccount();
	}

	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.getAccByID(id);
	}

	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return accountService.isAccNameExists(name);
	}

	public boolean createAccount(Account acc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return accountService.createAccount(acc);
	}

	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.delAccByID(ID);
	}

	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateByEmai(id, newEmail);
	}

	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateByEmai(id, newUserName);
	}
	
	public boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateByFullName(id, newFullName);
	}

}
