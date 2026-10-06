package com.example.smart_support_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smart_support_ai.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
