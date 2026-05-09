package com.api.Constants;

public enum Platform {
FrontDesk(2);
	
	int code;
	Platform(int i) {
	this.code=i;
	}
	
	public int getCode() {
		return code;
	}
}
