package com.sms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sms.entity.Student;
import com.sms.service.StudentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/students")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id , @Valid @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}
