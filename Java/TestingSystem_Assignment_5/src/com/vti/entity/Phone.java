package com.vti.entity;

public abstract class Phone implements VuKhi{
	public void nghe() {
		System.out.println("Nghe");
	}
	
	public void goi() {
		System.out.println("Gọi");
	}
	
	public void guiTinNhan() {
		System.out.println("Gửi tin nhắn");
	}
	
	public void nhanTinNhan() {
		System.out.println("Nhận tin nhắn");
	}

	@Override
	public void tanCong() {
		System.out.println("Tấn công kẻ xấu");
	}
	
	
}
