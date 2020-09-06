package com.smarte.assignment.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.smarte.assignment.util.RegionEnum;
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	private String name;
	
    @Enumerated(EnumType.STRING)
	private RegionEnum region;
	
	public Department() {
	}
	
	public Department(String name, RegionEnum region) {
		this.name = name;
		this.region = region;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RegionEnum getRegion() {
		return region;
	}
	public void setRegion(RegionEnum region) {
		this.region = region;
	}
	
}
