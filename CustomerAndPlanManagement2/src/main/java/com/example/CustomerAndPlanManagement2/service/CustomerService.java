package com.example.CustomerAndPlanManagement2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerAndPlanManagement2.entity.CustomerEntity;
import com.example.CustomerAndPlanManagement2.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

//    public Customer saveCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }

	public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }
    public CustomerEntity getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public CustomerEntity updateCustomer(Long id, CustomerEntity customerDetails) {
        CustomerEntity customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setAddress(customerDetails.getAddress());
        customer.setPlan(customerDetails.getPlan());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
