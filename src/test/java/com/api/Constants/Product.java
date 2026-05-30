package com.api.Constants;

public enum Product {
Nexus_2(3), PIXEL(3);

	int code;
Product(int code) {
this.code=code;
}

public int getCode() {
	return code;
}
}
