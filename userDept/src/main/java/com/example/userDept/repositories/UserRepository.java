package com.example.userDept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userDept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}

