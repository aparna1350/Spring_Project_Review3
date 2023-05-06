package com.example.demobook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demobook.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
}

