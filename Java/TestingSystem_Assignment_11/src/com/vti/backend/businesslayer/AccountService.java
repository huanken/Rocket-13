package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository repository;
	
	public AccountService() throws FileNotFoundException, IOException {
		repository = new AccountRepository();
	}

	@Override
	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return repository.getListAccount();
	}

	@Override
	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return repository.getAccByID(id);
	}

	@Override
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.isAccNameExists(name);
	}

	@Override
	public boolean createAccount(Account acc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.createAccount(acc);
	}

	@Override
	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.delAccByID(ID);
	}

	@Override
	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.updateByEmai(id, newEmail);
	}

	@Override
	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.updateByEmai(id, newUserName);
	}

	@Override
	public boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.updateByFullName(id, newFullName);
	}
	
}
