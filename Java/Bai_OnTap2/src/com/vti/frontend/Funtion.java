package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Manager;
import com.vti.ultis.ScannerUltis;

public class Funtion {
	private AccountController accountController;

	public Funtion() throws FileNotFoundException, IOException {
		accountController = new AccountController();
	}

	public void Menu() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			while (true) {
				String leftAlignFormat = "| %-72s |%n";
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format("|                        Choose please                                     |%n");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, "1. Login");
				System.out.format(leftAlignFormat, "2. Search Account By ProjectID");
				System.out.format(leftAlignFormat, "3. Get List Manager");
				System.out.format(leftAlignFormat, "0.Exit");
				System.out.format("+--------------------------------------------------------------------------+%n");
				switch (ScannerUltis.inputIntPositive()) {
				case 1:
					getLogin();
					break;
				case 2:
					getAccountByProjectID();
					break;
				case 3:
					getListManager();
					break;
				case 0:
					return;
				default:
					System.out.println("Nhập lại:");
					break;
				}
			}
		}
	}

	private void getListManager() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountControler = new AccountController();
		List<Manager> listAcc1 = accountControler.getListManager();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s |%n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | FullName        | Password              | ExpInYear      | ProjectID        |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
		for (Manager acc : listAcc1) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getFullName(), acc.getPassWord(), acc.getExpInYear(), acc.getProjectID());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
	}

	private void getAccountByProjectID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tìm kiếm Account theo ProjectID: ");
		System.out.println("Nhập vào ProjectID: ");
		int idFind = ScannerUltis.inputIntPositive();
		AccountController accountControler = new AccountController();
		List<Account> listAcc2 = accountControler.getAccountByProjectID(idFind);
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s |%n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | FullName        | Password              |  ProjectID     | TypeAccount      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
		for (Account acc : listAcc2) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getFullName(),acc.getPassWord(),acc.getProjectID(),acc.getTypeAccount());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
	}

	private void getLogin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập tài khoản Email: ");
			String email = ScannerUltis.inputEmail();
			System.out.println("Nhập mật khẩu Password: ");
			String pass = ScannerUltis.inputPassword();
			boolean isSuccess = accountController.loginAccount(email, pass);
			if (isSuccess) {
				System.out.println("Đăng nhập thành công");
				System.out.println("Welcome");
				return;
			} else {
				System.err.println("Đăng nhập không thành công. Kiểm tra lại tài khoản và mật khẩu");
				return;
			}
		}
	}
}
