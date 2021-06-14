package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Manager;

public class AccountService implements IAccountService{
	private IAccountRepository accountRepository;

	public AccountService() throws FileNotFoundException, IOException {
		accountRepository = new AccountRepository();
	}

	@Override
	public List<Manager> getListManager()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getListManager();
	}

	@Override
	public boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.loginAccount(email, password);
	}

	@Override
	public List<Account> getAccountByProjectID(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByProjectID(id);
	}
	
}
