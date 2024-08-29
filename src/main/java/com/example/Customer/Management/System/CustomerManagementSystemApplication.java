package com.example.Customer.Management.System;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CustomerManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService customerService = context.getBean(CustomerService.class);

		Customer newCustomer = new Customer();
		newCustomer.setId(1L);
		newCustomer.setName("John Doe");
		newCustomer.setEmail("john.doe@example.com");
		newCustomer.setContactNumber("123-456-7890");

		// Add the customer (this should trigger the NotificationService)
		customerService.addCustomer(newCustomer);

		// Retrieve and display the customer
		Customer retrievedCustomer = customerService.getCustomer(1L);
		System.out.println("Retrieved Customer: " + retrievedCustomer.getName());

		// Update the customer
		retrievedCustomer.setEmail("john.doe_updated@example.com");
		customerService.updateCustomer(retrievedCustomer);
		System.out.println("Updated Customer Email: " + customerService.getCustomer(1L).getEmail());

		// Delete the customer
		customerService.deleteCustomer(1L);
		System.out.println("Customer deleted.");
	}

}

