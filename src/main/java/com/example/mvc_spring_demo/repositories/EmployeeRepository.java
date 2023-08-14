package com.example.mvc_spring_demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.mvc_spring_demo.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    List<Employee> findByName(String name);
}
