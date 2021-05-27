package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;
import com.vti.entity.News;

public class Exercise_1 {
	public static int id = 0;
	ArrayList<News> newsArrayList;
	Scanner scanner;

	public Exercise_1() {
		newsArrayList = new ArrayList<News>();
		scanner = new Scanner(System.in);
	}

	public void question_1() {
		while (true) {
			System.out.println("========================================================================");
			System.out.println("===== 1. Insert news													");
			System.out.println("===== 2. View list news													");
			System.out.println("===== 3. Average rate													");
			System.out.println("===== 0. Exit															");
			System.out.println("========================================================================");
			int choose = 0;
			scanner = new Scanner(System.in);
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				scanner = new Scanner(System.in);
				News news = new News();
				int[] rates = new int[3];
				id++;
				news.setId(id);
				System.out.println("Nhập Title: ");
				news.setTitle(scanner.nextLine());

				System.out.println("Nhập Publish Date: ");
				news.setPublishDate(scanner.nextLine());

				System.out.println("Nhập Author: ");
				news.setAuthor(scanner.nextLine());

				System.out.println("Nhập Content: ");
				news.setContent(scanner.nextLine());

				System.out.println("Nhập 3 đánh giá: ");
				for (int i = 0; i < 3; i++) {
					System.out.println("Đánh giá " + (i + 1) + ": ");
					rates[i] = scanner.nextInt();
				}
				news.setRates(rates);
				newsArrayList.add(news);
				break;
			case 2:
				for (News newss : newsArrayList) {
					newss.Display();
				}
				break;
			case 3:
				for (News newss : newsArrayList) {
					newss.Calculate();
					newss.Display();
				}
				break;
			case 0:
				return;
			default:
				System.out.println("Nhập lại: ");
				break;
			}
		}
	}


}
