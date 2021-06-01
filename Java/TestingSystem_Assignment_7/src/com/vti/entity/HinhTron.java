package com.vti.entity;

public class HinhTron extends HinhHoc {

	public HinhTron(Float a, Float b) throws Exception {
		super(a, b);
	}

	@Override
	public Float tinhChuVI(Float a, Float b) {
		return 2 * a * (Config.PI);
	}

	@Override
	public Float tinhDienTich(Float a, Float b) {
		return (float) (Config.PI * (Math.pow(a, 2)));
	}
}
