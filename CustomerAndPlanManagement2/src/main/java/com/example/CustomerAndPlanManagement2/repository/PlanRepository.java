package com.example.CustomerAndPlanManagement2.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.CustomerAndPlanManagement2.entity.PlanEntity;

public interface PlanRepository extends JpaRepository <PlanEntity, Long>{

}
