package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	private DepartmentDao depDAQ;

	public Exercise2() throws FileNotFoundException, IOException {
		super();
		depDAQ = new DepartmentDao();
	}

	//Question 1:
	public void question1() throws ClassNotFoundException, SQLException {
		List<Department> listDept = depDAQ.getListDepartment();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDept) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	//Question 2:
	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Tìm thông tin phòng có ID =5");
		Department deptQuestion2 = depDAQ.getDepByID(5);
		if (deptQuestion2 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, deptQuestion2.getId(), deptQuestion2.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}
	
	//Question 3:
	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tìm kiếm phòng theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int id = ScannerUltis.inputIntPositive();
		Department deptQuestion3 = depDAQ.getDepByID(id);
		if (deptQuestion3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, deptQuestion3.getId(), deptQuestion3.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}

	//Question 4:
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra tên phòng đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = depDAQ.isDepartmentNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}

	//Question 5:
	public void question5() throws ClassNotFoundException, SQLException {
		String newNameDep = getNewName();
		if (depDAQ.createDep(newNameDep)) {
			System.out.println("Tạo thành công.");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private String getNewName() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập vào tên phòng cần tạo: ");
			String newName = ScannerUltis.inputString();
			if (depDAQ.isDepartmentNameExists(newName)) {
				System.out.println("Đã có phòng trên hệ thống");
			} else {
				return newName;
			}

		}

	}

	//Question 6:
	public void question6() throws ClassNotFoundException, SQLException {
		question1();
		int updateID = getIdUpdate();
		System.out.println("Nhập vào tên cần Update: ");
		String newName = ScannerUltis.inputString();
		if (depDAQ.updateDepartmentName(updateID, newName)) {
			System.out.println("Update tên phòng thành công: ");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	public  int getIdUpdate() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập ID phòng cần Update/Delete : ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = depDAQ.getDepByID(id);
			if (dep == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	//Question 7:
	public void question7() throws ClassNotFoundException, SQLException {
		question1();
		int updateID = getIdUpdate();
		if (depDAQ.delDepByID(updateID)) {
			System.out.println("Xóa phòng thành công");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	//Question 8:
	
}
