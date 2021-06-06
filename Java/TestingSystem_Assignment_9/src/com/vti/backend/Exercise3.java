package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.NgayThangNam;
import com.vti.entity.NgayThangNam.GioPhutGiay;
import com.vti.entity.OuterClass;

public class Exercise3 {
	public void question1() {
		CPU cpu1 = new CPU(10);
		CPU.Processor pro1 = cpu1.new Processor(4, "Intel");
		CPU.Ram ram1 = cpu1.new Ram(16, "Kingston");
		System.out.println("Khởi tạo CPU --> OK");
		System.out.println("In thông tin Processor: ");
		System.out.println("Cache Processor: " + pro1.getCache());
		System.out.println("Clock Speed Ram: " + ram1.getClockSpeed());
	}

	public void question2() {
		Car car = new Car("Mazda", "8WWD");
		Car.Engineer engine = car.new Engineer("Crysler");
		System.out.println("Tạo Car --> OK");
		System.out.println("Thông tin xe: " + car);
		System.out.println("Thông tin động cơ: " + engine);
	}

	public void question3() {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.show();
	}

	public void question4() {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;
		time.xuatThongTin();
	}
}
