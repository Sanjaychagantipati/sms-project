package com.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.User;

public interface UserRepository extends JpaRepository<User , Long>{
	Optional<User> findByUsername(String username);
	

}
