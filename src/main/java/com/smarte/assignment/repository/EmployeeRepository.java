package com.smarte.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smarte.assignment.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
