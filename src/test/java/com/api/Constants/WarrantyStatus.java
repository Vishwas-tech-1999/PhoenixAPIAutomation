package com.api.Constants;

public enum WarrantyStatus {

	INWARRNTY(1),
	OUTWARRANTY(2);

	
	int code;
	WarrantyStatus(int i) {
		code=i;
	}
	
	public int getCode()
{
		return code;
		}
}
