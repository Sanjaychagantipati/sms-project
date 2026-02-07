package com.sms.service;

import java.util.List;

import com.sms.entity.Course;

public interface CourseService {
	
	Course createCourse(Course course);
	
	List<Course> getAllCourse();

}
