package com.vti.entity;

public class HinhChuNhat extends HinhHoc {

	public HinhChuNhat(Float a, Float b) throws Exception {
		super(a, b);
	}

	@Override
	public Float tinhChuVI(Float a, Float b) {
		return 2 * (a + b);
	}

	@Override
	public Float tinhDienTich(Float a, Float b) {
		return (a * b);
	}
}
