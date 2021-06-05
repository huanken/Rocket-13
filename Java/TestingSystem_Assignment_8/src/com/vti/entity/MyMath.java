package com.vti.entity;

public class MyMath<N extends Number> {

	@SuppressWarnings({ "unchecked", "removal" })
	// Hàm tính tổng 2 số
	public <T extends Number> T add(T x, T y) {

		if (x == null || y == null) {
			return null;
		}

		if (x instanceof Double) {
			return (T) new Double(x.doubleValue() + y.doubleValue());
		} else if (x instanceof Integer) {
			return (T) new Integer(x.intValue() + y.intValue());
		} else {
			throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
		}
	}

	// Hàm tìm max
	public <T extends Comparable<T>> T maximum(T x, T y, T z) {
		// assume x is initially the largest
		T max = x;
		// y is the largest so far
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z; // z is the largest
		}
		return max;
	}

	// Hàm tính hiệu 2 số
	@SuppressWarnings({ "removal", "unchecked" })
	public <T extends Number> T subtract(T x, T y) {
		if (x == null || y == null) {
			return null;
		}
		if (x instanceof Double) {
			return (T) new Double(x.doubleValue() - y.doubleValue());
		} else if (x instanceof Integer) {
			return (T) new Integer(x.intValue() - y.intValue());
		} else if (x instanceof Float) {
			return (T) new Float(x.floatValue() - y.floatValue()); 
		} else {
			throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
		}
	}
}
