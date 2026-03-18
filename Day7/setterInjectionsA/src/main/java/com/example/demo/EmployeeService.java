package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    private Employee emp;

    // Default constructor
    public EmployeeService() {
        System.out.println("Inside EmployeeService constructor");
    }

    // Setter Injection
    @Autowired
    public void setEmployee(Employee emp) {
        System.out.println("Inside setEmployee()");
        this.emp = emp;
    }

    public void display() {
        System.out.println("Employee id is " + emp.getEmpid());
        System.out.println("Employee name is " + emp.getName());
        System.out.println("Employee salary is " + emp.getSalary());
    }
}