package com.example.Customer.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    private final NotificationService notificationService;


    @Autowired
    public CustomerServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public CustomerServiceImpl() {
        this.notificationService = new NotificationServiceImpl();
    }


    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        notificationService.sendNotification("New customer added: " + customer.getName());
    }

    @Override
    public Customer getCustomer(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        int index = customers.indexOf(getCustomer(customer.getId()));
        if (index != -1) {
            customers.set(index, customer);
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomer(id);
        if (customer != null) {
            customers.remove(customer);
            notificationService.sendNotification("Customer deleted: " + customer.getName());
        }
    }
    public List<Customer> getAllCustomers() {
        return customers;
    }

}

