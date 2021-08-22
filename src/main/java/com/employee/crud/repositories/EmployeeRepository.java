package com.employee.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
