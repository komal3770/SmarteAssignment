package com.smarte.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarte.assignment.pojo.DepartmentRequest;
import com.smarte.assignment.pojo.Response;
import com.smarte.assignment.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public Response saveDepartment(@RequestBody @Valid DepartmentRequest departmentRequest) {
		return departmentService.saveDepartment(departmentRequest);
	}
	
}
