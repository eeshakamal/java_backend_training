package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelEntity.Employee;
import com.example.demo.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee) {
		Employee updated = service.updateEmployee(id, employee);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee with id " + id + " not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		if (service.deleteEmployee(id)) {
			return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee with id " + id + " not found", HttpStatus.NOT_FOUND);
	}
}