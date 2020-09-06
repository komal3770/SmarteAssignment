package com.smarte.assignment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smarte.assignment.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	Optional<Employee> findByUserName(String userName);
}
