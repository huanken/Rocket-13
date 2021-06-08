package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class Exercise2_Question8 {

	private AccountDao accDAO;
	private DepartmentDao depDAQ;
	private PositionDao posDAQ;

	public Exercise2_Question8() throws FileNotFoundException, IOException {
		super();
		accDAO = new AccountDao();
		depDAQ = new DepartmentDao();
		posDAQ = new PositionDao();
	}

	public void question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> listAccount = accDAO.getListAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		for (Account acc : listAccount) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
	}

	public void question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm thông tin Account có ID =5");
		Account acc2 = accDAO.getAccByID(5);
		if (acc2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, acc2.getId(), acc2.getEmail(), acc2.getUsername(), acc2.getFullName(),
					acc2.getDepartment(), acc2.getPosition(), acc2.getCreateDate());
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		} else {
			System.out.println("Không có Account trên hệ thống");
		}
	}

	public void question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm thông tin Account theo ID: ");
		System.out.println("Nhập ID Account cần tìm: ");
		int id = ScannerUltis.inputIntPositive();
		Account acc2 = accDAO.getAccByID(id);
		if (acc2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, acc2.getId(), acc2.getEmail(), acc2.getUsername(), acc2.getFullName(),
					acc2.getDepartment(), acc2.getPosition(), acc2.getCreateDate());
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		} else {
			System.out.println("Không có Account trên hệ thống");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Kiểm tra tên account đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = accDAO.isAccNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}

	}

	public void question5() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Account acc = new Account();
		System.out.println("Nhập vào Email: ");
		acc.setEmail(ScannerUltis.inputString());
		System.out.println("Nhập vào UserName: ");
		acc.setUsername(ScannerUltis.inputString());
		System.out.println("Nhập vào FullName: : ");
		acc.setFullName(ScannerUltis.inputString());
		System.out.println("Hãy chọn phòng nhân viên: ");
		int depid = getDep();
		System.out.println("Hãy chọn Position nhân viên: ");
		int posid = getPos();
		if (accDAO.createAccount(acc, depid, posid)) {
			System.out.println("Tạo thành công: ");
			question1();
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}
	}

	private int getPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			PositionDao posDAO = new PositionDao();
			List<Position> listpos = posDAO.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Position theo ID:");
			int choosePos = ScannerUltis.inputIntPositive();
			;
			if (posDAO.getPosByID(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có Position này, hãy chọn lại: ");
			}
		}
	}

	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDao depDAO = new DepartmentDao();
			List<Department> listDep = depDAO.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn phòng theo ID:");
			int chooseDep = ScannerUltis.inputIntPositive();
			;
			if (depDAO.getDepByID(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại: ");
			}
		}
	}

	private int getMenuQues6() {
		while (true) {
			System.out.println("Bạn muốn update trường nào??");
			System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
			int i = ScannerUltis.inputIntPositive();
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
				return i;
			} else {
				System.out.println("Chọn lại: ");
			}
		}
	}

	public void question6() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			switch (getMenuQues6()) {
			case 1:
				int id = getidCase1();
				System.out.println("Nhập vào New Email: ");
				String newEmail = ScannerUltis.inputString();
				if (accDAO.updateByEmai(id, newEmail)) {
					System.out.println("Update thành công.");
					question1();
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 2:
				int id2 = getidCase1();
				System.out.println("Nhập vào New UserName: ");
				String newUserName = ScannerUltis.inputString();
				if (accDAO.updateByUserName(id2, newUserName)) {
					System.out.println("Update thành công.");
					question1();
				} else {
					System.out.println("Update không thành công, kiểm tra lại.");
				}
				break;
			case 3:
				int id3 = getidCase1();
				System.out.println("Nhập vào New FullName: ");
				String newFullName = ScannerUltis.inputString();
				if (accDAO.updateByFullName(id3, newFullName)) {
					System.out.println("Update thành công.");
					question1();
				} else {
					System.out.println("Update không thành công, kiểm tra lại.");
				}
				break;
			case 4:
				int id4 = getidCase1();
				int idDep = getNewIDDep();
				if (accDAO.updateByDepId(id4, idDep)) {
					System.out.println("Update thành công.");
					question1();
				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 5:
				int id5 = getidCase1();
				int idPos = getNewIDPos();
				if (accDAO.updateByPosId(id5, idPos)) {
					System.out.println("Update thành công.");
					question1();
				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 6:
				return;
			}
		}
	}

	private int getNewIDDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			Exercise2 exercise2 = new Exercise2();
			exercise2.question1(); // in ra bảng Department
			System.out.println("Nhập ID Department cần Update/Delete : ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = depDAQ.getDepByID(id);
			if (dep == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	private int getNewIDPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			Exercise1 exercise1 = new Exercise1();
			exercise1.question2(); // in ra bảng Position
			System.out.println("Nhập ID Position cần Update/Delete : ");
			int id = ScannerUltis.inputIntPositive();
			Position pos = posDAQ.getPosByID(id);
			if (pos == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	private int getidCase1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			System.out.println("Nhập ID Account cần Update/Delete : ");
			int id = ScannerUltis.inputIntPositive();
			Account acc = accDAO.getAccByID(id);
			if (acc == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

}
