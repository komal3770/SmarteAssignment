package com.smarte.assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarte.assignment.beans.Department;
import com.smarte.assignment.pojo.DepartmentRequest;
import com.smarte.assignment.pojo.Response;
import com.smarte.assignment.repository.DepartmentRepository;
import com.smarte.assignment.util.RegionEnum;

@Service
public class DepartmentService {
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	/**
	 * Save list of departments.
	 *
	 * @param departments the departments
	 */
	public void saveDepartments(List<DepartmentRequest> departments) {
		if(departments == null)
			return;
		List<Department> departmentBeans = departments.stream().map(dept -> {
			Optional<Department> deptObj = departmentRepository.findByName(dept.getName());
			if(deptObj.isPresent())
				return null;
			return new Department(dept.getName(), RegionEnum.valueOf(dept.getRegion()));
		}).filter(dept -> dept!=null).collect(Collectors.toList());
		
		departmentRepository.saveAll(departmentBeans);
		logger.info("Saved departments");
	}
	
	public Optional<Department> findByName(String name){
		return departmentRepository.findByName(name);
	}
	
	/**
	 * Save department.
	 *
	 * @param departmentReq the department req
	 * @return the response
	 */
	public Response saveDepartment(DepartmentRequest departmentReq) {
		if(departmentReq == null)
			return new Response("Request data is invalid", false);
		try {
			Optional<Department> deptObj = departmentRepository.findByName(departmentReq.getName());
			if(deptObj.isPresent())
				return new Response("Department name already exist", false);
			
			Department department = new Department(departmentReq.getName(), RegionEnum.valueOf(departmentReq.getRegion()));
			departmentRepository.save(department);
			return new Response("Department Saved Successfully", true);
		}
		catch (Exception e) {
			logger.error("Exception in saveDepartment "+e.getMessage());
			return new Response("Failed to save department", false);
		}
	}
}
