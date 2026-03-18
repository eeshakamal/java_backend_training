package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    private final Employee emp;
    // Constructor Injection (BEST PRACTICE - no @Autowired needed)
    public EmployeeService(Employee emp) {
        System.out.println("Inside EmployeeService constructor");
        this.emp = emp;
    }

    public void display() {
        System.out.println("Employee id is " + emp.getEmpid());
        System.out.println("Employee name is " + emp.getName());
        System.out.println("Employee salary is " + emp.getSalary());
    }
}