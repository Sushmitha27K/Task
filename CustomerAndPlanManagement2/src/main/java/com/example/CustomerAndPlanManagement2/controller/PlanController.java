package com.example.CustomerAndPlanManagement2.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerAndPlanManagement2.entity.PlanEntity;
import com.example.CustomerAndPlanManagement2.service.PlanService;

@RestController
@RequestMapping("/api/plan")

public class PlanController {

	@Autowired
    private PlanService planService;

    @PostMapping
    public PlanEntity createPlan(@RequestBody PlanEntity plan) {
        return planService.savePlan(plan);
    }

    @GetMapping
    public List<PlanEntity> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public PlanEntity getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PutMapping("/{id}")
    public PlanEntity updatePlan(@PathVariable Long id, @RequestBody PlanEntity planDetails) {
        return planService.updatePlan(id, planDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return ResponseEntity.ok().build();
    }
}
