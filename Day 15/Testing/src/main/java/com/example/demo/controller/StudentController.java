package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	@GetMapping("/course/{course}")
	public List<Student> getStudentsByCourse(@PathVariable String course) {
		return studentService.getStudentsByCourse(course);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adminOnly() {
		return "This endpoint is only accessible to admins.";
	}

}
