package com.vti.frontend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SystemOutPrintf {
	public static void main(String[] args) {
		System.out.println("Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó;");
		int n = 5;
		System.out.printf("So nguyen n la: %d%n", n);

		System.out.println("Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in\r\n" + 
				"ra số nguyên đó thành định dạng như sau: 100,000,000 ");
		int n1 = 100000000;
		System.out.printf("So nguyen n1 la: %,d%n",n1);
		
		System.out.println("Question 3:Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf \r\n" + 
				"để in ra số thực đó chỉ bao gồm 4 số đằng sau");
		float n2 = 5.567098f;
		System.out.printf("So thuc n2 la: %.4f%n",n2);
		
		System.out.println("Question 4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:\r\n" + 
				"Họ và tên: \"Nguyễn Văn A\" thì sẽ in ra trên console như sau:\r\n" + 
				"Tên tôi là \"Nguyễn Văn A\" và tôi đang độc thân.");
		String name3 = "John Nguyen";
		System.out.printf("Tên tôi là %s và tôi đang độc thân. %n",name3);
		
		
		System.out.println("Question 5:Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s");
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.printf("Thoi gian hien tai la: %s%n", date);

		
		
		
	}
}
