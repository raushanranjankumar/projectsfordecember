package org.javaproject.dao;

import org.javaproject.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDAO{
    List<Customer> customers;
    public CustomerImpl(){
        customers = new ArrayList<>();
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customers;
    }

    @Override
    public void addCustomerDetails(Customer customer) {
        this.customers.add(customer);

    }
}
