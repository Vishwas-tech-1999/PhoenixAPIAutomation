package com.api.Constants;

public enum Problem {

	
	SMARTPHONE_IS_RUNNING_SLOW(1),
	POOR_BATTERY_LIFE(2),
	SYNC_ISSUE(4),
	MICROSD_CARD_IS_NOT_WORKING_ON_YOUR_PHONE(5);

	
	int code;
	Problem(int i) {
code =i;
}
	
	public int getCode() {
		return code;
	}
	
	
}
