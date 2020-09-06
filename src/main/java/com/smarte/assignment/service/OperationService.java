package com.smarte.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarte.assignment.beans.Employee;
import com.smarte.assignment.config.ApplicationProperties;
import com.smarte.assignment.pojo.EmployeeRequest;

@Service
public class OperationService {
	private static Logger logger = LoggerFactory.getLogger(OperationService.class);
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * Inits method : Saves all departments & employees from yaml to db.
	 */
	@PostConstruct
    public void init() {
		logger.error("departments  "+applicationProperties.getDepartments().size());
		departmentService.saveDepartments(applicationProperties.getDepartments());
		employeeService.saveAllEmployees(applicationProperties.getEmployees());
    }
	
	
	/**
	 * Find all employeess by department, age, status and ctc <br/>
	 * 
	 * NOTE : For testing, getting all the employee records from db and other filters are kept in java <br/>
	 * 
	 * a) Given a department find all employees above a given age :: deptName, age <br/>
	 * b) Given a department find all active employees below a given age :: deptName, age, onlyActive <br/>
	 * c) Given a department find all active employees below a given age having CTC greater than 2 lakh : deptName, age, onlyActive, ctc
	 */
	public List<EmployeeRequest> findAllByDepartmentAndAgeAndStatus(String deptName,Integer age, boolean isBelow, boolean onlyActive, Double ctc){
		List<Employee> employees = employeeService.findAll();
		//All the filters
		
		return employees.stream()
				.filter(emp -> emp.getDepartment().getName().equalsIgnoreCase(deptName))
				.filter(emp -> (isBelow && emp.getAge().compareTo(age) < 0) || (!isBelow && emp.getAge().compareTo(age) > 0))
				.filter(emp -> (onlyActive && emp.getStatus().getValue()) || !onlyActive)
				.filter(emp -> ctc==null || (ctc!=null && Double.compare(emp.getCtc(),ctc) > 0))
				.collect(Collectors.toList()).stream()
				.map(emp -> {
					//Convert employee bean to request as per requirement
					EmployeeRequest empReq = new EmployeeRequest();
					empReq.setEmpId(emp.getEmpId());
					empReq.setUsername(emp.getUserName());
					empReq.setDeptId(emp.getDepartment().getDeptId());
					empReq.setJoiningDate(emp.getJoiningDate());
					empReq.setAge(emp.getAge());
					empReq.setCtc(emp.getCtc());
					empReq.setCity(emp.getAddress().getCity());
					empReq.setState(emp.getAddress().getState());
					empReq.setCountry(emp.getAddress().getCountry());
					empReq.setPincode(emp.getAddress().getPincode());
					return empReq;
				}).collect(Collectors.toList());
	}
	
	
}
