package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Employeee;
import com.vti.entity.Manager;
import com.vti.entity.VietnamesePhone;
import com.vti.entity.Waiter;

public class Exercise_6 {
	Scanner scanner;

	public Exercise_6() {
		scanner = new Scanner(System.in);
	}

	public void question_1() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("=== 1. InsertContact.	===");
			System.out.println("=== 2. RemoveContact.	===");
			System.out.println("=== 3. UpdateContact.  ===");
			System.out.println("=== 4. SearchContact.  ===");
			System.out.println("=== 5. ShowContact. ===");
			System.out.println("=== 6. Thoát khỏi chương trình. ===");
			System.out.println("======================================================================");
			int menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào tên Contact: ");
				String name = scanner.next();
				System.out.println("Nhập vào tên số Phone: ");
				String phone = scanner.next();
				vnPhone.insertContact(name, phone);
				break;
			case 2:
				System.out.println("Nhập vào tên Contact cần remove:");
				String removeName = scanner.next();
				vnPhone.removeContact(removeName);
				break;
			case 3:
				System.out.println("Nhập tên cần Update: ");
				String name1 = scanner.next();
				System.out.println("Nhập số Phone mới: ");
				String newPhone = scanner.next();
				vnPhone.updateContact(name1, newPhone);
				System.out.println("Kết quả: ");
				vnPhone.searchContact(name1);
				break;
			case 4:
				System.out.println("Nhập vào tên Contact cần tìm kiếm: ");
				String searchName = scanner.next();
				vnPhone.searchContact(searchName);
				break;
			case 5:
				vnPhone.printContact();
				break;
			case 6:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	public void question_2() {
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn	muốn sử dụng==================");
			System.out.println("=== 1. Thêm Employee.	===");
			System.out.println("=== 2. Thêm Manager.	===");
			System.out.println("=== 3. Thêm Waiter .	===");
			System.out.println("=== 4. Thoát khỏi chương trình. ===");
			System.out.println("======================================================================");
			int menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào tên Employee: ");
				String emName = scanner.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double emSalaryRatio = scanner.nextDouble();
				Employeee employeee = new Employeee(emName, emSalaryRatio);
				employeee.displayInfor();
				break;
			case 2:
				System.out.println("Nhập vào tên Manager: ");
				String managerName = scanner.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double managerSalaryRatio = scanner.nextDouble();
				Manager manager = new Manager(managerName, managerSalaryRatio);
				manager.displayInfor();
				break;
			case 3:
				System.out.println("Nhập vào tên Waiter: ");
				String waiterName = scanner.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double waiterSalaryRatio = scanner.nextDouble();
				Waiter waiter = new Waiter(waiterName, waiterSalaryRatio);
				waiter.displayInfor();
				break;
			case 4:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

}
