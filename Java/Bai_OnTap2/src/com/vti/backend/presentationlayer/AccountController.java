package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.Manager;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}

	
	public List<Manager> getListManager()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.getListManager();
	}

	
	public boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.loginAccount(email, password);
	}

	public List<Account> getAccountByProjectID(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.getAccountByProjectID(id);
	}
	
}
