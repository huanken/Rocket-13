package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		System.out.println("Question 1: In ngẫu nhiên ra 1 số nguyên");
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " + n);

		System.out.println("Question 2: In ngẫu nhiên ra 1 số thực");
		float n1 = random.nextFloat();
		System.out.println("Số thực ngẫu nhiên: " + n1);

		System.out.println(
				"Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn");
		String[] nameArr = { "John", "David", "Peter", "Aoyama", "Linda" };
		int i = random.nextInt(nameArr.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: " + nameArr[i]);

		System.out.println("Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995");
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngay ngau nhien cua ban la: " + randomDay);

		System.out.println("Question 5:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây");
		int nowDay = (int) LocalDate.now().toEpochDay();
		long ramdomInt1 = nowDay - random.nextInt(365);
		LocalDate randomDay1 = LocalDate.ofEpochDay(ramdomInt1);
		System.out.println("Ngay ngau nhien cua ban la: " + randomDay1);

		System.out.println("Question 6:Lấy ngẫu nhiên 1 ngày trong quá khứ");
		int nowDay1 = (int) LocalDate.now().toEpochDay();
		long ramdomInt2 = random.nextInt(nowDay1);
		LocalDate randomDay2 = LocalDate.ofEpochDay(ramdomInt2);
		System.out.println("Ngay ngau nhien cua ban la: " + randomDay2);

		System.out.println("Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số");
		int n2 = random.nextInt(900) + 100;
		System.out.println("So ngau nhien co 3 chu so: " + n2);
		
		
	}
}
