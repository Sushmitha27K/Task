package com.example.CustomerAndPlanManagement2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CustomerAndPlanManagement2.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository <CustomerEntity, Long> {
	

}
