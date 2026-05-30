package com.api.Constants;

public enum Model {

	NEXUS_2_BLUE(1), GALAXY(3);

	int code;
	Model(int i) {
	this.code=i;
	}
	
	public int getCode() {
		return code;
	}
}
