package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Program {
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
		System.out.println("In thong tin Account: ");
		System.out.println("Thong tin Account 1:");
		System.out.println("ID: " + acc1.id);
		System.out.println("Email: " + acc1.email);
		System.out.println("Department: " + acc1.department.name);
		System.out.println("Group: " + acc1.groups[0].name + " AND " + acc1.groups[1].name);
	}
}















