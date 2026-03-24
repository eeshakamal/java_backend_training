package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.MyService;

@RestController
public class MyController {
    @Autowired
    private MyService service;
    // GET ALL
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }
    // GET BY ID
    @GetMapping("/getAllEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    // ADD
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

	
	  // UPDATE
	 
	  @PutMapping("/updateEmployee/{id}") 
	  public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
	     return service.updateEmployee(id, updatedEmployee); 
	     }
	 
    
	// DELETE
	 
	  @DeleteMapping("/deleteEmployee/{id}") 
	  public String deleteEmployee(@PathVariable int id) { 
		  return service.deleteEmployee(id); 
		  }
	  
    // DELETE ALL
	  @DeleteMapping("/deleteAllEmployee") 
	  public String deleteAllEmployee() {
	  return service.deleteAllEmployees(); }
	}
