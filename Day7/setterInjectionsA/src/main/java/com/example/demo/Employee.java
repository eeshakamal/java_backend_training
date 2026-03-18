package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    private int empid;
    private String name;
    private double salary;

    // Default constructor
    public Employee() {
        System.out.println("Inside default constructor");
    }

    public int getEmpid() {
        return empid;
    }

    @Value("101")
    public void setEmpid(int empid) {
        System.out.println("Inside setEmpid()");
        this.empid = empid;
    }

    public String getName() {
        return name;
    }
    @Value("Ravi")
    public void setName(String name) {
        System.out.println("Inside setName()");
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    @Value("10000")
    public void setSalary(double salary) {
        System.out.println("Inside setSalary()");
        this.salary = salary;
    }
}