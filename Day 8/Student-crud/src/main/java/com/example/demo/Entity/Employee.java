package com.example.demo.Entity;

public class Employee {
	private int id;
	private String name;
	private int age;
	private int salary;
	private String desig;
	
	public Employee(int id, String name, int age, int salary, String desig) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.desig = desig;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
}
