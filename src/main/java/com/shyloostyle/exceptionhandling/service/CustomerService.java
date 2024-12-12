package com.shyloostyle.exceptionhandling.service;

import com.shyloostyle.exceptionhandling.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
Customer getCustomerById(String id);
List<Customer> getAllCustomer();
Customer createCustomer(Customer customer);
Customer updateCustomer(String id, Customer customer);
}
