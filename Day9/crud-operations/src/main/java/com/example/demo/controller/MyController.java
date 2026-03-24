package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.entity.Employee;
import com.example.demo.repo.MyRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class MyController {
    private final MyRepo repository;

    @Autowired
    public MyController(MyRepo repository) {
        this.repository = repository;
    }
	@GetMapping("/getAllEmployee")
public List<Employee> getAllEmployees() {
	return repository.findAll();
	}
	@GetMapping("/getEmployeeById/{id}")
public Employee	getEmployeeById(@PathVariable int id) {
	Optional<Employee>emp= repository.findById(id);
	return emp.orElse(null);
	}
	//for adding
	@PostMapping("/addEmployee")
public String addEmployee(@RequestBody Employee employee) {
	repository.save(employee);
	return "Employee added successfully";
	}
	//for delete 
	@DeleteMapping("/deleteEmployee/{id}")
public String deleteEmployee(@PathVariable int id) {
	if(repository.existsById(id)) {
		repository.deleteById(id);
		return "Employee deleted successfully";
	}
	return "Employee not found";
	}
	//give code for deleteall
	@DeleteMapping("/deleteAllEmployees")
public String deleteAllEmployees() {
	repository.deleteAll();
	return "All employees deleted successfully";
}
	//GIVE FOR UPDATE code
	@PutMapping("/updateEmployee/{id}")
public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
	Optional<Employee> existingEmployee = repository.findById(id);
	if (existingEmployee.isPresent()) {
		Employee employee = existingEmployee.get();
		employee.setName(updatedEmployee.getName());
		employee.setSalary(updatedEmployee.getSalary());
		repository.save(employee);
		return "Employee updated successfully";
	}
	return "Employee not found";
}
}