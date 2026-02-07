package com.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.entity.Course;
import com.sms.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

}
