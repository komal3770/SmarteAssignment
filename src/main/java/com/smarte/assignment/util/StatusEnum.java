package com.smarte.assignment.util;

public enum StatusEnum {
	INACTIVE(false),ACTIVE(true);
	
	private Boolean value = false;
	
	private StatusEnum(Boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return this.value;
	}
}
