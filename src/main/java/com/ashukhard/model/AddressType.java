package com.ashukhard.model;

public enum AddressType {

	HOME(1), OFFICE(2), EMAIL(3);

	private AddressType(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}
}
