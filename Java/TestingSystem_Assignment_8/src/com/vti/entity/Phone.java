package com.vti.entity;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
	}

	public <T> T GetPhoneNumber() {
		return (T) super.getValue();
	}

	@Override
	public K getKey() {
		return super.getKey();
	}

}
