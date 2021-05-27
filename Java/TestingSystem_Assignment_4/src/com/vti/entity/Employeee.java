package com.vti.entity;

public class Employeee extends User {
	
	public Employeee(String name, double salaryRatio) {
		super(name, salaryRatio);
	}


	@Override
	public double calculatePay() {
		return getSalaryRatio() * 420;
	}

}
