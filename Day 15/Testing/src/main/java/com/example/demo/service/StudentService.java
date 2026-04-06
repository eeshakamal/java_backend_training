package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getStudentsByCourse(String course) {
		return studentRepository.findByCourse(course);
	}
	public String getWelcomeMessage() {
		return "Welcome to the Student Management System!";
	}

}
