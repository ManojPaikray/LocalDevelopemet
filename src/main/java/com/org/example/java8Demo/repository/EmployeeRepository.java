package com.org.example.java8Demo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.org.example.java8Demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, UUID>{

}
