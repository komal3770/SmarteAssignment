package com.smarte.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarte.assignment.pojo.EmployeeRequest;
import com.smarte.assignment.pojo.Response;
import com.smarte.assignment.service.EmployeeService;

@RestController
@RequestMapping("/emoloyees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public Response saveEmployee(@RequestBody @Valid EmployeeRequest employee) {
		return employeeService.saveEmployee(employee);
	}
}
