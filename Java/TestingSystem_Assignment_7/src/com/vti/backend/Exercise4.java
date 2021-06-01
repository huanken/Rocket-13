package com.vti.backend;

import com.vti.ultis.IOManager;
import com.vti.ultis.ScannerUltis;

public class Exercise4 {
	public void question_1() throws Exception {
		System.out.println("Chương trình đọc file:");
		System.out.println("Nhập vào file muốn đọc:");
		String path = ScannerUltis.inputString();
		System.out.println(IOManager.readFile(path));
	};

	public void question_2() throws Exception {
		System.out.println("Chương trình ghi file:");
		System.out.println("Nhập vào file muốn ghi:");
		String path = ScannerUltis.inputString();
		System.out.println("Nhập vào nội dung muốn ghi:");
		String content = ScannerUltis.inputString();
		IOManager.writeFile(path, true, content);
	}
	public void question_3() throws Exception {
		System.out.println("Chương trình đọc object:");
		System.out.println("Nhập vào path File:");
		String path = ScannerUltis.inputString();
		System.out.println(IOManager.readObject(path));
	};

	public void question_4() throws Exception {
		System.out.println("Chương trình ghi object:");
		System.out.println("Nhập vào path File:");
		String path = ScannerUltis.inputString();
		System.out.println("Nhập vào nội dung muốn ghi:");
		Object content = ScannerUltis.inputString();
		IOManager.writeObject(content, path);
	}
}
