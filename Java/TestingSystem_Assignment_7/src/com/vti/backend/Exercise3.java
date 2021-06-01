package com.vti.backend;

import com.vti.ultis.FileUltis;
import com.vti.ultis.ScannerUltis;

public class Exercise3 {
	// Question 1
	public void question1() throws Exception {
		loadMenuFile();
	}

	private void loadMenuFile() throws Exception {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử	dụng===================");
			System.out.println("=== 1. Check File is exists ");
			System.out.println("=== 2. Check Folder ");
			System.out.println("=== 3. Tạo file mới ");
			System.out.println("=== 4. Tạo mới file từ đường dẫn và tên	file riêng ");
			System.out.println("=== 5. Xóa file	");
			System.out.println("=== 6. Check path is File or Folder ");
			System.out.println("=== 7. Get all file in Folder ");
			System.out.println("=== 8. Copy File ");
			System.out.println("=== 9. Move File ");
			System.out.println("=== 10. Rename File ");
			System.out.println("=== 11. Tạo Folder ");
			System.out.println("=== 12. Download File ");
			System.out.println("=== 15. End Program	");
			System.out.println("=======================================================================	");
			int menuChoose = ScannerUltis.inputIntPositive();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào đường dẫn và file cần kiểm tra: ");
				String path1 = ScannerUltis.inputString();
				if (FileUltis.isFileExists(path1)) {
					System.out.println("Có file trên hệ thống");
				} else {
					System.out.println("Không có file trên hệ thống");
				}
				;
				break;
			case 2:
				System.out.println("Nhập vào Folder cần kiểm tra: ");
				String path2 = ScannerUltis.inputString();
				if (FileUltis.isFolderExists(path2)) {
					System.out.println("Có Folder trên hệ thống");
				} else {
					System.out.println("Không có Folder trên hệ thống");
				}
				break;
			case 3:
				System.out.println("Nhập vào đường dẫn và tên file cần tạo: ");
				String path3 = ScannerUltis.inputString();
				FileUltis.createNewFile(path3);
				break;
			case 4:
				System.out.println("Nhập vào đường dẫn: ");
				String path4 = ScannerUltis.inputString();
				System.out.println("Nhập vào tên file cần tạo: ");
				String fileName4 = ScannerUltis.inputString();
				FileUltis.createNewFile(path4, fileName4);
				break;
			case 5:
				System.out.println("Nhập vào đường dẫn và tên file cần xóa: ");
				String path5 = ScannerUltis.inputString();
				FileUltis.deleteFile(path5);
				break;
			case 6:
				System.out.println("Nhập vào Path cần kiểm tra ");
				String path6 = ScannerUltis.inputString();
				FileUltis.isFolderOrFile(path6);
				break;
			case 7:
				System.out.println("Nhập vào Path cần kiểm tra ");
				String path7 = ScannerUltis.inputString();
				String[] list = FileUltis.getAllFileName(path7);
				for (int i = 0; i < list.length; i++) {
					System.out.println(list[i]);
				}
				break;
			case 8:
				System.out.println("Nhập vào source nguồn: ");
				String source8 = ScannerUltis.inputString();
				System.out.println("Nhập vào Folder đích: ");
				String path8 = ScannerUltis.inputString();
				FileUltis.copyFile(source8, path8);
				break;
			case 9:
				System.out.println("Nhập vào file nguồn: ");
				String source9 = ScannerUltis.inputString();
				System.out.println("Nhập vào folder đích: ");
				String destination9 = ScannerUltis.inputString();
				FileUltis.moveFile(source9, destination9);
				// chưa chạy được chức năng này cần kiểm tra thêm.
				break;
			case 10:
				System.out.println("-- Chú ý nhập vào đầy đủ cả đường dẫn và tên file.");
				System.out.println("Nhập vào file nguồn: ");
				String source10 = ScannerUltis.inputString();
				System.out.println("Nhập vào file đích: ");
				String des10 = ScannerUltis.inputString();
				FileUltis.renameFile(source10, des10);
				break;
			case 11:
				System.out.println("Nhập vào đường dẫn folder cần tạo: ");
				String newPathFolder = ScannerUltis.inputString();
				FileUltis.createNewFolder(newPathFolder);
				break;
			case 12:
				System.out.println("No Data");
				break;
			case 15:
				return;
			default:
				System.out.println("Alarm: Lựa chọn đúng số trên menu");
				break;
			}
		}
	}
}
