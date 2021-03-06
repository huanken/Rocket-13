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
		Ki???m tra account th??? 2
		N???u kh??ng c?? ph??ng ban (t???c l?? department == null) th?? s??? in ra text
		"Nh??n vi??n n??y ch??a c?? ph??ng ban"
		N???u kh??ng th?? s??? in ra text "Ph??ng ban c???a nh??n vi??n n??y l?? ???" */
		System.out.println("Question 1: ");
		if (acc2.department == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? ph??ng ban");
		} else
			System.out.println("Ph??ng ban c???a nh??n vi??n n??y l??: "+ acc2.department.name);
		
		/* Question 2:
		Ki???m tra account th??? 2
		N???u kh??ng c?? group th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? group"
		N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra text "Group c???a nh??n vi??n
		n??y l?? Java Fresher, C# Fresher"
		N???u c?? m???t trong 3 Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i
		quan tr???ng, tham gia nhi???u group"
		N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l??
		ng?????i h??ng chuy???n, tham gia t???t c??? c??c group */
		System.out.println("Question 2: ");
		if (acc2.groups == null || acc2.groups.length == 0) {
			System.out.println("Nh??n vi??n n??y ch??a c?? group");

		} else if (acc2.groups.length == 1) {
			System.out.println("Group c???a nh??n vi??n n??y l??"
					+ acc2.groups[0]);

		} else if (acc2.groups.length == 2) {
			System.out.println("Group c???a nh??n vi??n n??y l??"
					+ acc2.groups[0] + ", " + acc2.groups[1]);

		} else if (acc2.groups.length == 3) {
			System.out
					.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");

		} else
			System.out
					.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
		
		/*Question 3:
		S??? d???ng to??n t??? ternary ????? l??m Question 1 */ 
		System.out.println("Question 3: ");
		System.out.println(acc2.department == null ? "Nh??n vi??n n??y ch??a c?? ph??ng ban": "Ph??ng ban c???a nh??n vi??n n??y l????:" + acc2.department.name);
		
		/* Question 4:
		S??? d???ng to??n t??? ternary ????? l??m y??u c???u sau:
		Ki???m tra Position c???a account th??? 1
		N???u Position = Dev th?? in ra text "????y l?? Developer"
		N???u kh??ng ph???i th?? in ra text "Ng?????i n??y kh??ng ph???i l?? Developer" */
		System.out.println("Question 4: ");
		System.out.println(acc1.position.name == PositionName.Dev ? "????y l?? Developer": "Ng?????i n??y kh??ng ph???i l?? Developer");
		
		/* SWITCH CASE
		Question 5:
		L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format sau:
		N???u s??? l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n"
		N???u s??? l?????ng account = 2 th?? in ra "Nh??m c?? hai th??nh vi??n"
		N???u s??? l?????ng account = 3 th?? in ra "Nh??m c?? ba th??nh vi??n"
		C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n" */
		System.out.println("Question 5: ");
		int x = groupAcc1.length;
		switch (x) {
		case 1:
			System.out.println("Nh??m c?? m???t th??nh vi??n");
			break;
		case 2:
			System.out.println("Nh??m c?? hai th??nh vi??n");
			break;
		case 3:
			System.out.println("Nh??m c?? ba th??nh vi??n");
		default:
			System.out.println("Nh??m c?? nhi???u th??nh vi??n");
		}
		
		/* Question 6: S??? d???ng switch case ????? l??m l???i Question 2 */
		System.out.println("Question 6: ");
		int y = acc2.groups.length;
		switch (y) {
		case 0:
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
			break;
		case 1:
			System.out.println("Group c???a nh??n vi??n n??y l??" + acc2.groups[0]);
			break;
		case 2:
			System.out.println("Group c???a nh??n vi??n n??y l??" + acc2.groups[0] + ", " + acc2.groups[1]);
			break;
		case 3:
			System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
			break;
		default:
			System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
		}
		
		/* Question 7: S??? d???ng switch case ????? l??m l???i Question 4 */
		System.out.println("Question 7: ");
		PositionName z = acc1.position.name;
		switch (z) {
		case Dev:
			System.out.println("????y l?? Developer");
			break;
		default:
			System.out.println("Ng?????i n??y kh??ng ph???i l?? Developer");
		}
		
		/* FOREACH
		Question 8: In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a h??? */
		System.out.println("Question 8: ");
		Account[] accounts = { acc1, acc2 };
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullName);
			System.out.println("Name Department: " + account.department.name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 9: In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name */
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
		In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
		h??? theo ?????nh d???ng nh?? sau:
		Th??ng tin account th??? 1 l??:
		Email: NguyenVanA@gmail.com
		Full name: Nguy???n V??n A
		Ph??ng ban: Sale
		Th??ng tin account th??? 2 l??:
		Email: NguyenVanB@gmail.com
		Full name: Nguy???n V??n B
		Ph??ng ban: Marketting */
		System.out.println("Question 10: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " l????:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 11:
		In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
		Th??ng tin department th??? 1 l??:
		Id: 1
		Name: Sale
		Th??ng tin department th??? 2 l??:
		Id: 2
		Name: Marketing */
		System.out.println("Question 11: ");
		System.out.println("---------------------Thong tin Department--------------------------");
		for (int i = 0; i < departments.length; i++) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " l????:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 12: Ch??? in ra th??ng tin 2 department ?????u ti??n theo ?????nh d???ng nh?? Question 10 */
		System.out.println("Question 12: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < 2; i++) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " l????:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 13: In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2 */
		System.out.println("Question 13: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			if (i != 1) {
				System.out.println("Th??ng tin account th??? " + (i + 1)+ " l????:");
				System.out.println("ID: " + accounts[i].id);
				System.out.println("Name: " + accounts[i].fullName);
				System.out.println("Email: " + accounts[i].email);
			}
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* Question 14: In ra th??ng tin t???t c??? c??c account c?? id < 4 */
		System.out.println("Question 14: ");
		System.out.println("---------------------Thong tin Account-----------------------------");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Th??ng tin account th??? " + (i + 1) + " l????:");
				System.out.println("ID: " + accounts[i].id);
				System.out.println("User: " + accounts[i].userName);
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Fullname: " + accounts[i].fullName);
				System.out.println("Department: " + accounts[i].department.name);
			}
		}
		System.out.println("-------------------------------------------------------------------");
		
		/*Question 15: In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20 */
		System.out.println("Question 15: ");
		for (int i = 2; i <= 20; i = i + 2) {
			System.out.println(i);
		}
		/* WHILE
		Question 16:
		L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng WHILE k???t h???p v???i l???nh break, continue */
		System.out.println("Question 16/10: ");
		int i = 0;
		System.out.println("---------------------Thong tin Account-----------------------------");
		while (i < accounts.length) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " l????:");
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
			System.out.println("Th??ng tin department th??? " + (i + 1) + " l????:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}
		System.out.println("-------------------------------------------------------------------");
		
		/* DO-WHILE
		Question 17:
		L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng DO-WHILE k???t h???p v???i
		l???nh break, continue */
		System.out.println("Question 17/10: ");
		i = 0;
		System.out.println("---------------------Thong tin Account-----------------------------");
		do  {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " l????:");
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
			System.out.println("Th??ng tin department th??? " + (i + 1) + " l????:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		} while (i < departments.length);
		System.out.println("-------------------------------------------------------------------");
	}	
	
}















