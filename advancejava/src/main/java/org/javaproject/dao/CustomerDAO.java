package org.javaproject.dao;

import org.javaproject.models.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomer();
    void addCustomerDetails(Customer customer);
}
