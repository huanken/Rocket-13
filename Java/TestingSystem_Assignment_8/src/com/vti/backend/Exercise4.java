package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.entity.MyNumber;
import com.vti.entity.Salary;

public class Exercise4 {
	public void question1() {
		// Integer
		Salary<Integer> salary = new Salary<Integer>(69000);
		System.out.println(salary);
	}

	public void question2() {
		// Double
		MyNumber<Double> number = new MyNumber<Double>(6900.900);
		System.out.println(number);
		MyNumber<Long> number2 = new MyNumber<Long>(69999999l);
		System.out.println(number2);
	}

	public void question3() {
		MyMath<Integer> mathInt = new MyMath<>();
		MyMath<Float> mathFloat = new MyMath<>();
		// add
		Integer sumInt1 = mathInt.add(1, 10);
		System.out.println(sumInt1);
		
		// max
		Float sumFloat = mathFloat.maximum(1.5f, 10.3f, 10.2f);
		System.out.println(sumFloat);
		
		// subtract
		int subInt1 = mathInt.subtract(10, 1);
		System.out.println(subInt1);
		float subFloat2 = mathFloat.subtract(10f, 5f);
		System.out.println(subFloat2);
	}
}
