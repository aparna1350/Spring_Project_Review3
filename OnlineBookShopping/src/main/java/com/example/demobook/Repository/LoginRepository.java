package com.example.demobook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demobook.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{
	Login findByUsername(String username);
}
