package com.vti.entity;

public abstract class HinhHoc {
	private Float a;
	private Float b;
	public static int COUNT = 0;

	public abstract Float tinhChuVI(Float a, Float b);

	public abstract Float tinhDienTich(Float a, Float b);

	public HinhHoc(Float a, Float b) throws Exception {
		super();
		COUNT++;
		if (COUNT <= Config.SO_LUONG_HINH_TOI_DA) {
			this.a = a;
			this.b = b;
		} else {
			throw new HinhHocException();
		}
	}
}