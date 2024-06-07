package com.example.CustomerAndPlanManagement2.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerAndPlanManagement2.entity.SubscriptionEntity;
import com.example.CustomerAndPlanManagement2.repository.SubscriptionRepository;


@Service
public class SubscriptionService {

	 @Autowired
	    private SubscriptionRepository subscriptionRepository;

	    public SubscriptionEntity saveSubscription(SubscriptionEntity subscription) {
	        return subscriptionRepository.save(subscription);
	    }

	    public List<SubscriptionEntity> getAllSubscriptions() {
	        return subscriptionRepository.findAll();
	    }

	    public SubscriptionEntity getSubscriptionById(Long id) {
	        return subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
	    }

	    public SubscriptionEntity updateSubscription(Long id, SubscriptionEntity subscriptionDetails) {
	        SubscriptionEntity subscription = getSubscriptionById(id);
	        subscription.setCustomer(subscriptionDetails.getCustomer());
	        subscription.setPlan(subscriptionDetails.getPlan());
	        subscription.setStartDate(subscriptionDetails.getStartDate());
	        subscription.setEndDate(subscriptionDetails.getEndDate());
	        subscription.setStatus(subscriptionDetails.getStatus());
	        return subscriptionRepository.save(subscription);
	    }

	    public void deleteSubscription(Long id) {
	        subscriptionRepository.deleteById(id);
	    }
}