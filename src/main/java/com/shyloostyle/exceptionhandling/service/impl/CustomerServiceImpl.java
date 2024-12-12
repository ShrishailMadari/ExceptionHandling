package com.shyloostyle.exceptionhandling.service.impl;

import com.shyloostyle.exceptionhandling.exception.CustomerNotFoundException;
import com.shyloostyle.exceptionhandling.exception.InputEmptyException;
import com.shyloostyle.exceptionhandling.exception.ResourceNotFoundException;
import com.shyloostyle.exceptionhandling.model.Customer;
import com.shyloostyle.exceptionhandling.repository.CustomerRepository;
import com.shyloostyle.exceptionhandling.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.source.internal.hbm.AttributesHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> allCustomer = customerRepository.findAll();
        if (allCustomer.isEmpty())
            throw new CustomerNotFoundException("Customers Not Found: ");
        return allCustomer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if (customer.getId().isEmpty() || customer.getEmail() == null) {
            throw new InputEmptyException("input is empty");
        }
        Customer saved = customerRepository.save(customer);
        log.info("data saved in database");
        return saved;
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        // Find the customer by ID first
        Customer customerById = getCustomerById(id);

        // Update the fields using the builder pattern, conditionally updating only provided fields
        Customer updatedCustomer = customerById.toBuilder()
                .firstName(customer.getFirstName() != null ? customer.getFirstName() : customerById.getFirstName())
                .lastName(customer.getLastName() != null ? customer.getLastName() : customerById.getLastName())
                .email(customer.getEmail() != null ? customer.getEmail() : customerById.getEmail())
                .password(customer.getPassword() != null ? customer.getPassword() : customerById.getPassword())
                .address(customer.getAddress() != null ? customer.getAddress() : customerById.getAddress())
                .phoneNumber(customer.getPhoneNumber() != null ? customer.getPhoneNumber() : customerById.getPhoneNumber())
                .build();

        // Save and return the updated customer
        return customerRepository.save(updatedCustomer);
    }
}

