package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment , Long>{
	List<Enrollment> findByStudentId(Long studentId);

}
