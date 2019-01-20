package com.ashukhard.model;

public enum AddressType {

	HOME(0), OFFICE(1), EMAIL(2);

	private AddressType(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	public static AddressType getAddressType(int id) {
		for (AddressType addressType : AddressType.values()) {
			if (addressType.getId() == id)
				return addressType;
		}
		return null;
	}

}
