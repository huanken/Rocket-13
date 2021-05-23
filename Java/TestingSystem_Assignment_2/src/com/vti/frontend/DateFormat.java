package com.vti.frontend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;

public class DateFormat {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Create Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";
		group1.createDate = LocalDate.of(2020, 05, 22);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "DB Fresher";
		group2.createDate = LocalDate.of(2020, 05, 22);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "C++ Fresher";
		group3.createDate = LocalDate.of(2020, 06, 23);

		// Create Deparment
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "HR";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.PM;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.Dev;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.Scrum_Master;

		// Create Account
		Account account1 = new Account();
		account1.id = 1;
		account1.createDate = LocalDate.of(2020, 03, 17);
		account1.department = department1;
		account1.email = "An@gmail.com";
		account1.fullName = "Nguyen Van An";
		account1.position = position1;
		account1.userName = "an.nguyenvan";

		Account account2 = new Account();
		account2.id = 2;
		account2.createDate = LocalDate.of(2020, 01, 9);
		account2.department = department1;
		account2.email = "Linh@gmail.com";
		account2.fullName = "Nguyen Hoai Linh";
		account2.position = position3;
		account2.userName = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.id = 3;
		account3.createDate = LocalDate.of(2020, 03, 19);
		account3.department = department2;
		account3.email = "ha@gmail.com";
		account3.fullName = "Pham Hai Ha";
		account3.position = position1;
		account3.userName = "Ha.phamhai";

		// Add Group to Account
		Group[] groupOfAccount1 = { group1 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group3 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1 };
		account3.groups = groupOfAccount3;

		// Add Account to Group
		Account[] accountOfGroups1 = { account1, account2, account3 };
		group1.accounts = accountOfGroups1;

		// Create CategoryQuestion
		CategoryQuestion category1 = new CategoryQuestion();
		category1.id = 1;
		category1.name = "JAVA";

		CategoryQuestion category2 = new CategoryQuestion();
		category2.id = 2;
		category2.name = "DB";

		CategoryQuestion category3 = new CategoryQuestion();
		category3.id = 3;
		category3.name = "C++";

		// Create TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.Multiple_Choice;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.Essay;

		// Create Question
		Question question1 = new Question();
		question1.categoryQuestion = category1;
		question1.content = "Dac diem chinh cua Java";
		question1.createDate = LocalDate.of(2020, 1, 7);
		question1.creator = account1;
		question1.id = 1;
		question1.typeQuestion = type1;

		Question question2 = new Question();
		question2.categoryQuestion = category1;
		question2.content = "Cac chuong trinh Java chu yeu";
		question2.createDate = LocalDate.of(2020, 2, 8);
		question2.creator = account1;
		question2.id = 2;
		question2.typeQuestion = type2;

		Question question3 = new Question();
		question3.categoryQuestion = category1;
		question3.content = "Quy tac thiet ke Database";
		question3.createDate = LocalDate.of(2019, 2, 9);
		question3.creator = account2;
		question3.id = 3;
		question3.typeQuestion = type1;

		// Create Exam
		Exam exam1 = new Exam();
		exam1.code = "JV01";
		exam1.createDate = new Date();
		exam1.creator = account1;
		exam1.duration = 60;
		exam1.id = 1;
		exam1.title = "Kien thuc co ban ve Java";

		Exam exam2 = new Exam();
		exam2.code = "DB01";
		exam2.createDate = new Date(100, 10, 30);
		exam2.creator = account2;
		exam2.duration = 120;
		exam2.id = 2;
		exam1.title = "Kien thuc co ban ve Database";

		// Create Answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "JAVA la ngon ngu lap trinh pho bien nhat";
		answer1.isCorrect = true;
		answer1.question = question1;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "JAVA la ngon ngu lap trinh mat phi";
		answer2.isCorrect = false;
		answer2.question = question1;

		// Question 1
		System.out.println(
				"Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese");
		Locale locale = new Locale("vi", "VN");
		java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL, locale);
		String date = dateFormat.format(exam1.createDate);

		System.out.println("\nThong tin Exam 1 la: \n" + "ID: " + exam1.id + " Code: " + exam1.code + " Title: "
				+ exam1.title + " Duration: " + exam1.duration + " CreateDate: " + date);

		// Question 2
		System.out.println(
				"Question 2:In ra thông tin: Exam đã tạo ngày nào theo định dạng: Năm – tháng – ngày – giờ – phút – giây");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			date = simpleDateFormat2.format(exam.createDate);
			System.out.println("ExamID: " + exam.id + " CreateDate : " + date);
		}
		
		// Question 3
		System.out.println("Question 3:Chỉ in ra năm của create date property trong Question 2");
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy");
		for (Exam exam : exams) {
			date = simpleDateFormat3.format(exam.createDate);
			System.out.println("ExamID: " + exam.id + " Year : " + date);
		}
		
		// Question 4
		System.out.println("Question 4:Chỉ in ra tháng và năm của create date property trong Question 2");
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("M/yyyy");
		for (Exam exam : exams) {
			date = simpleDateFormat4.format(exam.createDate);
			System.out.println("ExamID: " + exam.id + " Month/Year : " + date);
		}
		
		//Question 5
		System.out.println("Question 5:Chỉ in ra \"MM-DD\" của create date trong Question 2");
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("M-dd");
		for (Exam exam : exams) {
			date = simpleDateFormat5.format(exam.createDate);
			System.out.println("ExamID: " + exam.id + " Month-Day : " + date);
		}
	
	}
}
