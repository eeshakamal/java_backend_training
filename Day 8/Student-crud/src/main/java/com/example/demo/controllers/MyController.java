package com.example.demo.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.Entity.Employee;
@RestController
public class MyController {
	ArrayList<Employee> emp = new ArrayList<Employee>();
	public MyController() {
		emp.add(new Employee(1,"Rohit",23,50000,"Developer"));
		emp.add(new Employee(2,"Suresh",25,60000,"Tester"));
		emp.add(new Employee(3,"Mahesh",22,45000,"Designer"));
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return emp;
	}
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id ) {
		for(Employee e:emp) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;//or returns a custom error message or throw an exception
	}
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		emp.add(e);
		return "Employee added successfully";
	}
     @DeleteMapping("/deleteEmployee/{id}")
     public String deleteEmployeeById(@PathVariable int id) {
 		for(Employee e : emp){
 			if(e.getId() == id){
 				emp.remove(e);
 				return "Employee with id" +id+" deleted successfully";
 			}
 		}
 		return "Employee with id"+ id+" not found";
 	}
     @PutMapping("/updateEmployee/{id}")
     public ResponseEntity<String> updateEmployeeById(@PathVariable int id, @RequestBody Employee updatedEmployee) {
		 for (Employee e : emp) {
			 if (e.getId() == id) {
				 e.setName(updatedEmployee.getName());
				 e.setAge(updatedEmployee.getAge());
				 e.setSalary(updatedEmployee.getSalary());
				 e.setDesig(updatedEmployee.getDesig());
				 return ResponseEntity.ok("Employee with id " + id + " updated successfully");
			 }
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id " + id + " not found");

	 }
 }
