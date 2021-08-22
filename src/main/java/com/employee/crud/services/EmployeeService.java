package com.employee.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crud.model.Employee;
import com.employee.crud.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRep;
	
	public List<Employee> findAllEmp () {
		return empRep.findAll();
	}

	public void createEmployee(Employee emp) {
		
		empRep.save(emp);
		
	}

	public void deleteEmployee(Long empid) {
		
		empRep.deleteById(empid);
		
	}

	public void updateEmployee(Employee emp, Long id) {
		
		Optional<Employee> ExistingEmp = empRep.findById(id);
		
		if(ExistingEmp.isPresent()) {
			Employee emps = ExistingEmp.get();
			emps.setFirstName(emp.getFirstName());
			emps.setLastName(emp.getLastName());
			emps.setDeptName(emp.getDeptName());
			empRep.save(emps);
		}
		
		
	}
}
