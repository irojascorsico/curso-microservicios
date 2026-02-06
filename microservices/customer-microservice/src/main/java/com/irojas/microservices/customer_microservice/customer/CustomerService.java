package com.irojas.microservices.customer_microservice.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.irojas.microservices.customer_microservice.exceptions.CustomerNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String saveCustomer(CustomerRequest request) {
       var customer = repository.save(mapper.toCustomer(request));  
       return customer.getId();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return repository
            .findById(customerId)
            .map(mapper::toCustomerResponse)
            .orElse(null);
    }

    public List<CustomerResponse> getCustomers() {
        return repository
            .findAll().stream()
            .map(mapper::toCustomerResponse)
            .toList();
    }

    public void deleteCustomerById(String customerId) {
        repository
            .findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(
                String.format("Customer with id %s not found", customerId)));
        repository.deleteById(customerId);
    }

}
