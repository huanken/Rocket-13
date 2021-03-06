package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.ultis.ScannerUltis;

public class Demo1 {
	private static AccountController accountController;

	public static void main(String[] args) throws Exception {

		accountController = new AccountController();
		// Question 2:
		int choose;
		do {
			menuAccount();

			choose = ScannerUltis.inputInt();
			switch (choose) {
			case 1:
				// get list data
				System.out.println("======List account=====");
				getListAccount();
				break;

			case 2:
				// get user by �d
				System.out.println("=======Get account by id======");
				getAccountByID();
				break;

			case 3:
				// create user
				System.out.println("=========Create account=========");
				createAccount();
				break;

			case 4:
				// update user
				System.out.println("=========Update account=========");
				updateAccount();
				break;

			case 5:
				// delete user
				System.out.println("=========Delete account=========");
				deleteAccount();
				break;

			case 6:
				break;

			default:
				System.out.println("input wrong ! please input again.");
				break;
			}
		} while (choose != 0);
	}

	private static void menuAccount() {
		System.out.println("============MENU===========");
		System.out.println("=|1. Get list account    |=");
		System.out.println("=|2. Get account by id   |=");
		System.out.println("=|3. Create account      |=");
		System.out.println("=|4. Update account      |=");
		System.out.println("=|5. Delete account      |=");
		System.out.println("=|0. Exit                |=");
		System.out.println("===========================");
		System.out.println("You choose:                ");
	}

	private static void getListAccount() throws IOException, SQLException, ClassNotFoundException {

		List<Account> accounts = accountController.getListAccount();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	private static void getAccountByID() throws Exception {

		System.out.println("Input id: ");
		int id = ScannerUltis.inputInt();

		Account account = accountController.getAccByID(id);
		System.out.println(account);
	}

	private static void createAccount() throws Exception {

		System.out.println("Input email: ");
		String email = ScannerUltis.inputString();

		System.out.println("Input username: ");
		String username = ScannerUltis.inputString();

		System.out.println("Input full name: ");
		String fullName = ScannerUltis.inputString();

		Account account = new Account(email, username, fullName);

		accountController.createAccount(account);
	}

	private static void updateAccount() throws Exception {
		System.out.println("Input id: ");
		int id = ScannerUltis.inputInt();

		System.out.println("Input full name: ");
		String fullName = ScannerUltis.inputString();

		accountController.updateByFullName(id, fullName);
	}

	private static void deleteAccount() throws Exception {
		System.out.println("Input id: ");
		int id = ScannerUltis.inputInt();

		accountController.delAccByID(id);
	}
}
