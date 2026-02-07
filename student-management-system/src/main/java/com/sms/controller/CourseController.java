package com.sms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sms.entity.Course;
import com.sms.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourse();
	}

}
