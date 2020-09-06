package com.smarte.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarte.assignment.pojo.EmployeeRequest;
import com.smarte.assignment.service.OperationService;

@RestController
@RequestMapping("/operations")
public class OperationController {
	
	@Autowired
	OperationService operationService;
	
	@GetMapping("/deptAndAgeAbove")
	public List<EmployeeRequest> getAllEmployeesByAgeAbove(@RequestParam String deptName, @RequestParam Integer age){
		return operationService.findAllByDepartmentAndAgeAndStatus(deptName, age, false, false, null);
	}
	
	@GetMapping("/deptAndAgeBelow")
	public List<EmployeeRequest> getAllEmployeesByDeptAndAgeBelow(@RequestParam String deptName, @RequestParam Integer age){
		return operationService.findAllByDepartmentAndAgeAndStatus(deptName, age, true, true, null);
	}
	
	@GetMapping("/deptAndAgeBelowAndCtc")
	public List<EmployeeRequest> getAllEmployeesByDeptAndAgeBelowAndCTC(@RequestParam String deptName, @RequestParam Integer age, @RequestParam Double ctc){
		return operationService.findAllByDepartmentAndAgeAndStatus(deptName, age, true, true, ctc);
	}
}
