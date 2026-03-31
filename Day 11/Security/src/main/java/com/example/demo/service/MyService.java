package com.example.demo.service;

import com.example.demo.modelorEntity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {
    
    @Autowired
    private EmployeeRepository repository;
    
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    
    public Employee getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }
    
    public String addEmployee(Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }
    
    public String updateEmployee(int id, Employee employee) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        repository.save(existingEmployee);
        return "Employee updated successfully with ID: " + id;
    }

    // DELETE BY ID
    public String deleteEmployeeById(int id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Employee not found with id: " + id);
        }
        repository.deleteById(id);
        return "Employee deleted successfully with ID: " + id;
    }

    // DELETE ALL
    public String deleteAllEmployees() {
        repository.deleteAll();
        return "All employees have been deleted successfully";
    }
}
