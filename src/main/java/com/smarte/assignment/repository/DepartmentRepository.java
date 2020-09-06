package com.smarte.assignment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smarte.assignment.beans.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
	Optional<Department> findByName(String name);
	
}
