package com.example.CustomerAndPlanManagement2.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class SubscriptionEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    @Column(nullable = false)
    private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public PlanEntity getPlan() {
		return plan;
	}

	public void setPlan(PlanEntity plan) {
		this.plan = plan;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", customer=" + customer + ", plan=" + plan + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + "]";
	}

	public SubscriptionEntity(Long id, CustomerEntity customer, PlanEntity plan, Date startDate, Date endDate, String status) {
		super();
		this.id = id;
		this.customer = customer;
		this.plan = plan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
    public SubscriptionEntity() {
    	
    }

	
 }