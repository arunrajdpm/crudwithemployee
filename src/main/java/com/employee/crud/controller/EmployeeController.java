package com.employee.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.crud.model.Employee;
import com.employee.crud.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empSer;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> employeeDetails = empSer.findAllEmp(); 
		return  new ResponseEntity<>(employeeDetails, HttpStatus.OK);
	} 
	
	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmp(@RequestBody() Employee emp ) {
		empSer.createEmployee(emp);
		return  new ResponseEntity<>(emp, HttpStatus.OK);
	} 
	
	@PutMapping("/{id}")
	public  ResponseEntity<Employee>  saveEmp(@RequestBody() Employee emp, @PathVariable("id") Long id ) {
		empSer.updateEmployee(emp, id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmp(@PathVariable("id") Long emp ) {
		empSer.deleteEmployee(emp);
		return new ResponseEntity<>(null, HttpStatus.OK);
	} 
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleContentNotAllowedException(Exception cnae) {            
        return new ResponseEntity<>(cnae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
