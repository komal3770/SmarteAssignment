package com.smarte.assignment.pojo;

import javax.validation.constraints.NotNull;

public class DepartmentRequest {
	@NotNull
	private String name;
	@NotNull
	private String region;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
