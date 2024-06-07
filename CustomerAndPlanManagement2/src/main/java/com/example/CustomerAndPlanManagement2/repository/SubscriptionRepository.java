package com.example.CustomerAndPlanManagement2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CustomerAndPlanManagement2.entity.SubscriptionEntity;

public interface SubscriptionRepository extends JpaRepository <SubscriptionEntity, Long>{

}
