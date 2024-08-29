package com.example.Customer.Management.System;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomer(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}

