package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.Document;

import com.vti.entity.Worker;
import com.vti.entity.Book;
import com.vti.entity.Employee;
import com.vti.entity.Employee.gender;
import com.vti.entity.Engineer;
import com.vti.entity.Jounal;
import com.vti.entity.Newspaper;
import com.vti.entity.Staff;

public class Exercise_5 {
	ArrayList<Employee> employees = new ArrayList<>();
	ArrayList<com.vti.entity.Document> documents = new ArrayList<>();
	Scanner scanner;

	// Quản lí cán bộ
	public void question_2() {
		while (true) {
			System.out.println("========================================================================");
			System.out.println("===== 1. Thêm mới cán bộ												");
			System.out.println("===== 2. Tìm kiếm theo họ tên											");
			System.out.println("===== 3. Hiển thị thông tin về danh sách các cán bộ						");
			System.out.println("===== 4. Nhập vào tên của cán bộ và delete cán bộ đó					");
			System.out.println("===== 0. Thoát khỏi chương trình										");
			System.out.println("========================================================================");
			int choose = 0;
			scanner = new Scanner(System.in);
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				addEmployee();
				break;
			case 2:
				searchEmployee();
				break;
			case 3:
				showEmpployee();
				break;
			case 4:
				deleteEmployee();
				break;
			case 0:
				return;
			default:
				System.out.println("Nhập lại: ");
				break;
			}
		}
	}

	private void addEmployee() {
		int choose = 0;
		System.out.println("1. Thêm công nhân");
		System.out.println("2. Thêm kỹ sư");
		System.out.println("3. Thêm nhân viên");
		scanner = new Scanner(System.in);
		choose = scanner.nextInt();
		switch (choose) {
		case 1:
			Worker worker = new Worker();
			System.out.println("Nhập họ tên: ");
			scanner = new Scanner(System.in);
			worker.name = scanner.nextLine();
			System.out.println("Nhập tuổi:   ");
			scanner = new Scanner(System.in);
			worker.age = scanner.nextInt();
			System.out.println("Chọn giới tính (1.Male 2.Female Số khác.Unknown): ");
			int seletion = scanner.nextInt();
			if (seletion == 1) {
				worker.gender = gender.Male;
			} else if (seletion == 2) {
				worker.gender = gender.Female;
			} else {
				worker.gender = gender.Unknown;
			}
			System.out.println("Nhập bậc của công nhân : ");
			worker.rank = scanner.nextInt();
			employees.add(worker);
			break;
		case 2:
			Engineer engineer = new Engineer();
			System.out.println("Nhập họ tên: ");
			scanner = new Scanner(System.in);
			engineer.name = scanner.nextLine();
			System.out.println("Nhập tuổi:   ");
			scanner = new Scanner(System.in);
			engineer.age = scanner.nextInt();
			System.out.println("Chọn giới tính (1.Male 2.Female Số khác.Unknown): ");
			seletion = scanner.nextInt();
			if (seletion == 1) {
				engineer.gender = gender.Male;
			} else if (seletion == 2) {
				engineer.gender = gender.Female;
			} else {
				engineer.gender = gender.Unknown;
			}
			scanner = new Scanner(System.in);
			System.out.println("Nhập ngành đào tạo của kỹ sư: ");
			engineer.specialize = scanner.nextLine();
			employees.add(engineer);
			break;
		case 3:
			Staff staff = new Staff();
			System.out.println("Nhập họ tên: ");
			scanner = new Scanner(System.in);
			staff.name = scanner.nextLine();
			System.out.println("Nhập tuổi:   ");
			scanner = new Scanner(System.in);
			staff.age = scanner.nextInt();
			System.out.println("Chọn giới tính (1.Male 2.Female Số khác.Unknown): ");
			seletion = scanner.nextInt();
			if (seletion == 1) {
				staff.gender = gender.Male;
			} else if (seletion == 2) {
				staff.gender = gender.Female;
			} else {
				staff.gender = gender.Unknown;
			}
			scanner = new Scanner(System.in);
			System.out.println("Nhập công việc của nhân viên: ");
			staff.job = scanner.nextLine();
			employees.add(staff);
			break;
		default:
			System.out.println("Nhập lại: ");
			break;
		}
	}

	private void searchEmployee() {
		System.out.println("Nhập họ tên cần tìm kiếm: ");
		scanner = new Scanner(System.in);
		String nameSearch = scanner.nextLine();
		for (Employee employee : employees) {
			if (employee.name.equals(nameSearch)) {
				System.out.println(employee.toString());
				return;
			}
		}
		System.out.println("Không tìm thấy cán bộ này");
	}

	private void showEmpployee() {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private void deleteEmployee() {
		System.out.println("Nhập vào tên cán bộ cần xóa: ");
		scanner = new Scanner(System.in);
		String nameDelete = scanner.nextLine();
		for (Employee employee : employees) {
			if (employee.name.equals(nameDelete)) {
				employees.remove(employee);
				return;
			}
		}
		System.out.println("Không tìm thấy cán bộ này");
	}

	// Quản lí tài liệu
	public void question_4() {
		while (true) {
			System.out.println("========================================================================");
			System.out.println("===== 1. Thêm mới tài liêu: Sách, tạp chí, báo							");
			System.out.println("===== 2. Xoá tài liệu theo mã tài liệu									");
			System.out.println("===== 3. Hiện thị thông tin về tài liệu									");
			System.out.println("===== 4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo				");
			System.out.println("===== 0. Thoát khỏi chương trình										");
			System.out.println("========================================================================");
			int choose = 0;
			scanner = new Scanner(System.in);
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				addDocument();
				break;
			case 2:
				deleteDocument();
				break;
			case 3:
				showDocument();
				break;
			case 4:
				searchDocument();
				break;
			case 0:
				return;
			default:
				System.out.println("Nhập sai ");
				break;
			}
		}
	}

	private void addDocument() {
		int choose = 0;
		System.out.println("1. Thêm sách");
		System.out.println("2. Thêm tạp chí");
		System.out.println("3. Thêm báo");
		scanner = new Scanner(System.in);
		choose = scanner.nextInt();
		switch (choose) {
		case 1:
			Book book = new Book();
			System.out.println("Nhập mã tài liệu: ");
			scanner = new Scanner(System.in);
			book.id = scanner.nextInt();
			System.out.println("Nhập nhà xuất bản: ");
			scanner = new Scanner(System.in);
			book.publisher = scanner.nextLine();
			System.out.println("Nhập số bản phát hành: ");
			scanner = new Scanner(System.in);
			book.amount = scanner.nextInt();
			System.out.println("Nhập tên tác giả: ");
			scanner = new Scanner(System.in);
			book.author = scanner.nextLine();
			System.out.println("Nhập số trang: ");
			scanner = new Scanner(System.in);
			book.numberOfPages = scanner.nextInt();
			documents.add(book);
			break;
		case 2:
			Jounal jounal = new Jounal();
			System.out.println("Nhập mã tài liệu: ");
			scanner = new Scanner(System.in);
			jounal.id = scanner.nextInt();
			System.out.println("Nhập nhà xuất bản: ");
			scanner = new Scanner(System.in);
			jounal.publisher = scanner.nextLine();
			System.out.println("Nhập số bản phát hành: ");
			scanner = new Scanner(System.in);
			jounal.amount = scanner.nextInt();
			System.out.println("Nhập số phát hành: ");
			jounal.number = scanner.nextInt();
			System.out.println("Nhập tháng phát hành: ");
			scanner = new Scanner(System.in);
			jounal.month = scanner.nextLine();
			documents.add(jounal);
			break;
		case 3:
			Newspaper newspaper = new Newspaper();
			System.out.println("Nhập mã tài liệu: ");
			scanner = new Scanner(System.in);
			newspaper.id = scanner.nextInt();
			System.out.println("Nhập nhà xuất bản: ");
			scanner = new Scanner(System.in);
			newspaper.publisher = scanner.nextLine();
			System.out.println("Nhập số bản phát hành: ");
			scanner = new Scanner(System.in);
			newspaper.amount = scanner.nextInt();
			System.out.println("Nhập tháng phát hành: ");
			scanner = new Scanner(System.in);
			newspaper.publishDay = scanner.nextLine();
			documents.add(newspaper);
			break;
		default:
			System.out.println("Nhập sai ");
			break;
		}
	}

	private void deleteDocument() {
		System.out.println("Nhập vào mã tài liệu cần xóa: ");
		scanner = new Scanner(System.in);
		int idDelete = scanner.nextInt();
		for (com.vti.entity.Document document : documents) {
			if (document.id == idDelete) {
				documents.remove(document);
				return;
			}
		}
		System.out.println("Không tìm thấy tài liệu này");
	}

	private void showDocument() {
		for (com.vti.entity.Document document : documents) {
			System.out.println(document.toString());
		}
	}

	private void searchDocument() {
		int choose = 0;
		System.out.println("1. Tìm sách");
		System.out.println("2. Tìm tạp chí");
		System.out.println("3. Tìm báo");
		scanner = new Scanner(System.in);
		choose = scanner.nextInt();
		switch (choose) {
		case 1:
			for (com.vti.entity.Document document : documents) {
				if (document instanceof Book) {
					System.out.println(document.toString());
				}
			}
			break;
		case 2:
			for (com.vti.entity.Document document : documents) {
				if (document instanceof Jounal) {
					System.out.println(document.toString());
				}
			}
			break;
		case 3:
			for (com.vti.entity.Document document : documents) {
				if (document instanceof Newspaper) {
					System.out.println(document.toString());
				}
			}
			break;
		default:
			System.out.println("Nhập sai ");
			break;
		}
	}
	
	public void question_3() {
		
	}
}
