package com.vti.entity;

public class Employee {
	private ProSkill proSkill;
	public enum ProSkill{
		Dev,Test,Java,SQL
	}
	public Employee(ProSkill proSkill) {
		super();
		this.proSkill = proSkill;
	}
	public ProSkill getProSkill() {
		return proSkill;
	}
	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}
	
}	
