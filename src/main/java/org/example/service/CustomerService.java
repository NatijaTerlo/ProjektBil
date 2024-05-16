package org.example.service;

import org.example.models.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer>showAllCustomers(){
        return customerRepository.showAllCustomers();
    }

    public List<Customer> getCustomers(){
        return customerRepository.getCustomers();
    }
    public void createCustomer(String firstName, String lastName, String email, int phone, String address){
        customerRepository.createCustomers(firstName, lastName, email, phone, address);
    }
    public void insertCustomer(String firstName, String lastName, String email, int phone, String address){
        customerRepository.insertCustomer(firstName, lastName, email, phone, address);
    }
    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);
    }
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

}
