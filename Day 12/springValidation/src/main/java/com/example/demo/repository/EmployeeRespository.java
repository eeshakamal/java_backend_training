package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelEntity.Employee;


public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
