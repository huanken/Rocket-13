package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.ScannerUltis;

public class Funtion {
	private CandidateController candidateControler;

	public Funtion() throws FileNotFoundException, IOException {
		candidateControler = new CandidateController();
	}

	public void Menu() throws ClassNotFoundException, SQLException {
		while (true) {
			while (true) {
				String leftAlignFormat = "| %-72s |%n";
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format("|                        Choose please                                     |%n");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, "1. Login");
				System.out.format(leftAlignFormat, "2. Register");
				System.out.format(leftAlignFormat, "3. Exit");
				System.out.format("+--------------------------------------------------------------------------+%n");
				switch (ScannerUltis.inputIntPositive()) {
				case 1:
					getLogin();
					break;
				case 2:
					getRegister();
					break;
				case 3:
					return;
				default:
					System.out.println("Nhập lại:");
					break;
				}
			}
		}
	}

	public void getRegister() throws ClassNotFoundException, SQLException {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Đăng ký ExperienceCandidate");
			System.out.format(leftAlignFormat, "2. Đăng ký FresherCandidate");
			System.out.format(leftAlignFormat, "0. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Nhập vào FirstName: ");
				String firstName = ScannerUltis.inputString();
				System.out.println("Nhập vào LastName: ");
				String lastName = ScannerUltis.inputString();
				System.out.println("Nhập vào Phone: : ");
				String phone = ScannerUltis.inputPhoneNumber();
				System.out.println("Nhập vào Email: ");
				String email = ScannerUltis.inputEmail();
				if (candidateControler.isCandidateIdExits(email)) {
					System.out.println("Đã tồn tại Account này trên hệ thống");
					break;
				}
				System.out.println("Nhập vào Password: ");
				String password = ScannerUltis.inputPassword();
				System.out.println("Nhập vào expInYear: : ");
				int expInYear = ScannerUltis.inputIntPositive();
				System.out.println("Nhập vào ProSkill: : ");
				ProSkill proSkill = getproSkill();
				Boolean flag = candidateControler.createExperienceCandidate(firstName, lastName, phone, email, password,
						expInYear, proSkill);
				if (flag) {
					System.out.println(
							"Tạo thành công, tài khoản của bạn là: Email: " + email + " Password: " + password);
					return;
				} else {
					System.out.println("Tạo không thành công, hãy kiểm tra lại");
					break;
				}

			case 2:
				System.out.println("Nhập vào FirstName: ");
				String firstName1 = ScannerUltis.inputString();
				System.out.println("Nhập vào LastName: ");
				String lastName1 = ScannerUltis.inputString();
				System.out.println("Nhập vào Phone: : ");
				String phone1 = ScannerUltis.inputPhoneNumber();
				System.out.println("Nhập vào Email: ");
				String email1 = ScannerUltis.inputEmail();
				if (candidateControler.isCandidateIdExits(email1)) {
					System.out.println("Đã tồn tại Account này trên hệ thống");
					break;
				}
				System.out.println("Nhập vào Password: ");
				String password1 = ScannerUltis.inputPassword();
				System.out.println("Nhập vào GraduationRank: : ");
				GraduationRank graduationRank = getGraduationRank();
				Boolean flag1 = candidateControler.createFresherCandidate(firstName1, lastName1, phone1, email1,
						password1, graduationRank);
				if (flag1) {
					System.out.println(
							"Tạo thành công, tài khoản của bạn là: Email: " + email1 + " Password: " + password1);
					System.out.println("Hãy đổi mật khẩu trong lần đăng nhập đầu tiên!!");
					return;
				} else {
					System.out.println("Tạo không thành công, hãy kiểm tra lại");
					break;
				}
			case 0:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	private GraduationRank getGraduationRank() {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. EXCELLENCE");
			System.out.format(leftAlignFormat, "2. GOOD");
			System.out.format(leftAlignFormat, "3. FAIR");
			System.out.format(leftAlignFormat, "4. POOR");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return GraduationRank.EXCELLENCE;
			case 2:
				return GraduationRank.GOOD;
			case 3:
				return GraduationRank.FAIR;
			case 4:
				return GraduationRank.POOR;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	private ProSkill getproSkill() {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. DEV");
			System.out.format(leftAlignFormat, "2. TEST");
			System.out.format(leftAlignFormat, "3. JAVA");
			System.out.format(leftAlignFormat, "4. SQL");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return ProSkill.DEV;
			case 2:
				return ProSkill.TEST;
			case 3:
				return ProSkill.JAVA;
			case 4:
				return ProSkill.SQL;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	public void getLogin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập tài khoản Email: ");
			String email = ScannerUltis.inputEmail();
			System.out.println("Nhập mật khẩu Password: ");
			String pass = ScannerUltis.inputPassword();
			boolean isSuccess =	candidateControler.loginCandidate(email, pass);
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