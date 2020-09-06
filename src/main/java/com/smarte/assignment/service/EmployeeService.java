package com.smarte.assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarte.assignment.beans.Address;
import com.smarte.assignment.beans.Department;
import com.smarte.assignment.beans.Employee;
import com.smarte.assignment.config.ApplicationProperties;
import com.smarte.assignment.pojo.EmployeeRequest;
import com.smarte.assignment.pojo.Response;
import com.smarte.assignment.repository.EmployeeRepository;
import com.smarte.assignment.util.StatusEnum;

/**
 * Employee related transactions with business logic
 */
@Service
public class EmployeeService {
	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	/**
	 * Save employee.
	 *
	 * @param employeeRequest the employee request
	 */
	public Response saveEmployee(EmployeeRequest employeeRequest) {
		if(employeeRequest == null) 
			return new Response("Request data is not valid", false);
		
		try {
			Optional<Employee> empObj = employeeRepository.findByUserName(employeeRequest.getUsername());
			if(empObj.isPresent())
				return new Response("Username exist", false);
			
			Employee employee = new Employee();
			employee.setUserName(employeeRequest.getUsername());
			employee.setPassword(employeeRequest.getPassword());
			employee.setAge(employeeRequest.getAge());
			employee.setJoiningDate(employeeRequest.getJoiningDate());
			employee.setStatus(StatusEnum.ACTIVE);
			employee.setCtc(employeeRequest.getCtc());
			employee.setAddress(new Address(employeeRequest.getCity(), employeeRequest.getPincode(), employeeRequest.getState(), employeeRequest.getCountry()));
			
			Department dept = new Department();
			dept.setDeptId(employeeRequest.getDeptId());
			employee.setDepartment(dept);
			
			employeeRepository.save(employee);
			return new Response("Employee saved successfully", true);
		}
		catch (Exception e) {
			logger.error("Exception in saveEmployee : "+e.getMessage());
			return new Response("Failed to save employee", false);
		}
	}
	
	/**
	 * Save all employees.
	 *
	 * @param employees the employees
	 */
	public void saveAllEmployees(List<EmployeeRequest> employees) {
		if(employees == null) 
			return;
		
		List<Employee> employeeBeans = employees.stream().map(emp -> {
			Optional<Employee> empObj = employeeRepository.findByUserName(emp.getUsername());
			if(!empObj.isPresent()) {
				Address address = new Address(emp.getCity(), emp.getPincode(), emp.getState(), emp.getCountry());
				Department dept = new Department();
				dept.setDeptId(emp.getDeptId());
				Employee employee = new Employee(emp.getUsername(), emp.getPassword(), emp.getAge(), emp.getCtc(), emp.getJoiningDate(), StatusEnum.getByValue(emp.getStatus()), dept, address);
				return employeeRepository.save(employee);
			}
			return null;
		}).filter(emp -> emp!=null).collect(Collectors.toList());
		employeeRepository.saveAll(employeeBeans);
		logger.info("Saved all employees");
	}
	
	public List<Employee> findAll(){
		return (List<Employee>) employeeRepository.findAll();
	}
}
