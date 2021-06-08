package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.vti.ultis.ScannerUltis;

public class Exercise3 {
	private DepartmentDao depDAQ;

	public Exercise3() throws FileNotFoundException, IOException {
		super();
		depDAQ = new DepartmentDao();
	}

	public void question1() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Exercise2 exercise2 = new Exercise2();
		exercise2.question1(); // in ra bảng Department
		System.out.println("Nhập vào ID Department cần xóa: ");
		int id = exercise2.getIdUpdate(); // kiểm tra ID dept ở question 6 exercise 2
		Boolean check = depDAQ.deleteDepartmentUsingProcedure(id);
		if (check) {
			System.out.println("Xóa thành công");
			exercise2.question1();
		} else {
			System.out.println("Xóa không thành công, kiểm tra lại");
			exercise2.question1();
		}
	}
}
