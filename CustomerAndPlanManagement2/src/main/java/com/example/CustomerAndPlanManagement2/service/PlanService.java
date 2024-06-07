package com.example.CustomerAndPlanManagement2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerAndPlanManagement2.entity.PlanEntity;
import com.example.CustomerAndPlanManagement2.repository.PlanRepository;


@Service
public class PlanService {

	@Autowired
    private PlanRepository planRepository;

    public PlanEntity savePlan(PlanEntity plan) {
        return planRepository.save(plan);
    }

    public List<PlanEntity> getAllPlans() {
        return planRepository.findAll();
    }

    public PlanEntity getPlanById(Long id) {
        return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    public PlanEntity updatePlan(Long id, PlanEntity planDetails) {
        PlanEntity plan = getPlanById(id);
        plan.setName(planDetails.getName());
        plan.setDescription(planDetails.getDescription());
        plan.setPrice(planDetails.getPrice());
        plan.setDataLimit(planDetails.getDataLimit());
        plan.setCallMinutes(planDetails.getCallMinutes());
        plan.setSmsLimit(planDetails.getSmsLimit());
        return planRepository.save(plan);
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
