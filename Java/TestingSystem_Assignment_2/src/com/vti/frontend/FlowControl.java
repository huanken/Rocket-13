package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class FlowControl {
	public static void main(String[] args) {
//Question 2
// Tao Department		
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Sale";
		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Marketing";
		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Bao ve";
// Tao Position	
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.Scrum_Master;
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Test;
// Tao Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Group Sale";
		group1.createDate = LocalDate.now();
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Group Development";
		group2.createDate = LocalDate.now();
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Group PM";
		group3.createDate = LocalDate.now();

// Tao Account	
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.userName = "User 1";
		acc1.fullName = "Nguyen Van A";
		acc1.email = "email1@gmail.com";
		acc1.createDate = LocalDate.of(2021, 05, 17);
		acc1.department = dep1;
		acc1.position = pos2;
		Group[] groupAcc1 = { group1, group2 };
		acc1.groups = groupAcc1;
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.userName = "User 2";
		acc2.fullName = "Nguyen Van B";
		acc2.email = "email2@gmail.com";
		acc2.createDate = LocalDate.of(2021, 05, 17);
		acc2.department = dep2;
		acc2.position = pos3;
		Group[] groupAcc2 = { group3, group2 };
		acc2.groups = groupAcc2;
// In thong tin Account		
/*		System.out.println("In thong tin Account: ");
		System.out.println("Thong tin Account 1:");
		System.out.println("ID: " + acc1.id);
		System.out.println("Email: " + acc1.email);
		System.out.println("Department: " + acc1.department.name);
		System.out.println("Group: " + acc1.groups[0].name + " AND " + acc1.groups[1].name); */
/* IF
		Question 1:
		Kiểm tra account thứ 2
		Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
		"Nhân viên này chưa có phòng ban"
		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …" */
		System.out.println("Question 1: ");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else
			System.out.println("Phòng ban của nhân viên này là: "+ acc2.department.name);
		
		/* Question 2:
		Kiểm tra account thứ 2
		Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
		Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
		này là Java Fresher, C# Fresher"
		Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
		quan trọng, tham gia nhiều group"
		Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
		người hóng chuyện, tham gia tất cả các group */
		System.out.println("Question 2: ");
		if (acc2.groups == null || acc2.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");

		} else if (acc2.groups.length == 1) {
			System.out.println("Group của nhân viên này là"
					+ acc2.groups[0]);

		} else if (acc2.groups.length == 2) {
			System.out.println("Group của nhân viên này là"
					+ acc2.groups[0] + ", " + acc2.groups[1]);

		} else if (acc2.groups.length == 3) {
			System.out
					.println("Nhân viên này là người quan trọng, tham gia nhiều group");

		} else
			System.out
					.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		
		/*Question 3:
		Sử dụng toán tử ternary để làm Question 1 */ 
		System.out.println("Question 3: ");
		System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban": "Phòng ban của nhân viên này là :" + acc2.department.name);
		
		/* Question 4:
		Sử dụng toán tử ternary để làm yêu cầu sau:
		Kiểm tra Position của account thứ 1
		Nếu Position = Dev thì in ra text "Đây là Developer"
		Nếu không phải thì in ra text "Người này không phải là Developer" */
		System.out.println("Question 4: ");
		System.out.println(acc1.position.name == PositionName.Dev ? "Đây là Developer": "Người này không phải là Developer");
		
		/* SWITCH CASE
		Question 5:
		Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
		Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
		Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
		Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
		Còn lại in ra "Nhóm có nhiều thành viên" */
		System.out.println("Question 5: ");
		int x = groupAcc1.length;
		switch (x) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
		
		/* Question 6: Sử dụng switch case để làm lại Question 2 */
		System.out.println("Question 6: ");
		int y = acc2.groups.length;
		switch (y) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.println("Group của nhân viên này là" + acc2.groups[0]);
			break;
		case 2:
			System.out.println("Group của nhân viên này là" + acc2.groups[0] + ", " + acc2.groups[1]);
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		
		/* Question 7: Sử dụng switch case để làm lại Question 4 */
		System.out.println("Question 7: ");
		PositionName z = acc1.position.name;
		switch (z) {
		case Dev:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}
		
		/* FOREACH
		Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ */
		System.out.println("Question 8: ");
		Account[] accounts = { acc1, acc2 };
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullName);
			System.out.println("Name Department: " + account.department.name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 9: In ra thông tin các phòng ban bao gồm: id và name */
		System.out.println("Question 9: ");
		Department[] departments = { dep1, dep2, dep3 };
		System.out.println("---------------------Thong tin Department--------------------------");
		for (Department department : departments) {
			System.out.println("ID Department: " + department.id);
			System.out.println("Name Department: " + department.name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* FOR
		Question 10:
		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
		họ theo định dạng như sau:
		Thông tin account thứ 1 là:
		Email: NguyenVanA@gmail.com
		Full name: Nguyễn Văn A
		Phòng ban: Sale
		Thông tin account thứ 2 là:
		Email: NguyenVanB@gmail.com
		Full name: Nguyễn Văn B
		Phòng ban: Marketting */
		System.out.println("Question 10: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 11:
		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
		Thông tin department thứ 1 là:
		Id: 1
		Name: Sale
		Thông tin department thứ 2 là:
		Id: 2
		Name: Marketing */
		System.out.println("Question 11: ");
		System.out.println("---------------------Thong tin Department--------------------------");
		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10 */
		System.out.println("Question 12: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2 */
		System.out.println("Question 13: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1)+ " là :");
				System.out.println("ID: " + accounts[i].id);
				System.out.println("Name: " + accounts[i].fullName);
				System.out.println("Email: " + accounts[i].email);
			}
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 14: In ra thông tin tất cả các account có id < 4 */
		System.out.println("Question 14: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là :");
				System.out.println("ID: " + accounts[i].id);
				System.out.println("User: " + accounts[i].userName);
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Fullname: " + accounts[i].fullName);
				System.out.println("Department: " + accounts[i].department.name);
			}
		}
		System.out.println("-------------------------------------------------------------------");
		
		/*Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20 */
		System.out.println("Question 15: ");
		for (int i = 2; i <= 20; i = i + 2) {
			System.out.println(i);
		}
		/* WHILE
		Question 16:
		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue */
		System.out.println("Question 16/10: ");
		int i = 0;
		System.out.println("---------------------Thong tin Account-----------------------------");
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("Question 16/13: ");
		i = 0;
		System.out.println("---------------------Thong tin Department--------------------------");
		while (i < departments.length) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* DO-WHILE
		Question 17:
		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
		lệnh break, continue */
		System.out.println("Question 17/10: ");
		i = 0;
		System.out.println("---------------------Thong tin Account-----------------------------");
		do  {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		} while (i < accounts.length);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("Question 17/13: ");
		i = 0;
		System.out.println("---------------------Thong tin Department--------------------------");
		do {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		} while (i < departments.length);
		System.out.println("-------------------------------------------------------------------");
	}	
	
}















