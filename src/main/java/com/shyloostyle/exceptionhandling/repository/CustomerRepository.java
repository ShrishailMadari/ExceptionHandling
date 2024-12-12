package com.shyloostyle.exceptionhandling.repository;

import com.shyloostyle.exceptionhandling.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
