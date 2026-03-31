package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelEntity.Employee;
import com.example.demo.repository.EmployeeRespository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRespository respository;
	public List<Employee> getAllEmployees(){
		return respository.findAll();
	}
	public Employee addEmployee(Employee employee) {
		return respository.save(employee);
	}
	//updateby id and delete operations
	public Employee updateEmployee(Integer id, Employee employee) {
		Employee existingEmployee = respository.findById(id).orElse(null);
		if(existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setPhone(employee.getPhone());
			existingEmployee.setSalary(employee.getSalary());
			return respository.save(existingEmployee);
		}
		return null;
	}
	public boolean deleteEmployee(Integer id) {
		if(respository.existsById(id)) {
			respository.deleteById(id);
			return true;
		}
		return false;
	}

	

}
