package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Course;

public interface CourseRepository extends JpaRepository<Course , Long>{

}
