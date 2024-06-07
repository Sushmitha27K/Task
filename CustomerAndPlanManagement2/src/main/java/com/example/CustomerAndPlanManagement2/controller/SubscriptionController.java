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

import com.example.CustomerAndPlanManagement2.entity.SubscriptionEntity;
import com.example.CustomerAndPlanManagement2.service.SubscriptionService;





@RestController
@RequestMapping("/api/subcriptions")
public class SubscriptionController {

	@Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public SubscriptionEntity createSubscription(@RequestBody SubscriptionEntity subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @GetMapping
    public List<SubscriptionEntity> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
    @GetMapping("/{id}")
    public SubscriptionEntity getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PutMapping("/{id}")
    public SubscriptionEntity updateSubscription(@PathVariable Long id,  @RequestBody SubscriptionEntity subscriptionDetails) {
        return subscriptionService.updateSubscription(id, subscriptionDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }
}
