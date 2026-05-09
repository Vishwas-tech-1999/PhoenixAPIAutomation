package com.api.Constants;

public enum Oem {
	
	Google(1),Apple(2);

	
	int code;
	Oem(int i) {
		code=i;
	}
	
	public int getCode() {
		return code;
	}

}
