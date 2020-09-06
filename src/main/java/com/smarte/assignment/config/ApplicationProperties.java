package com.smarte.assignment.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.smarte.assignment.pojo.DepartmentRequest;
import com.smarte.assignment.pojo.EmployeeRequest;

/**
 * Copying from application.yaml file to insert data of employees and department on startup of application
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
	
	List<DepartmentRequest> departments;
	
	List<EmployeeRequest> employees;
	
	public List<DepartmentRequest> getDepartments() {
		return departments;
	}

	void setDepartments(List<DepartmentRequest> departments) {
		this.departments = departments;
	}

	public List<EmployeeRequest> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeRequest> employees) {
		this.employees = employees;
	}
	
}
