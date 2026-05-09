package com.api.Constants;

public enum ServiceLocation {

	
	ServiceLocationA(1);
	
	int code;
	ServiceLocation(int i) {
	this.code=i;
	}
	
	public int getCode() {
		return code;
	}
}
