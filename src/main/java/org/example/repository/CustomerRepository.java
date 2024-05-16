package org.example.repository;

import org.example.models.Contract;
import org.example.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> getCustomers(){
        String query = "SELECT * FROM customers;";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(query, rowMapper);
    }
    public void createCustomers(String firstName, String lastName, String email, int phone, String address) {
        String query = "INSERT INTO customers(firstName, lastName, email, phone, Address)" + "VALUES (?,?,?,?,?);";
        jdbcTemplate.update(query,firstName, lastName, email, phone, address);
    }
    public void insertCustomer(String firstName, String lastName, String email, int phone, String address) {
        String query = "INSERT INTO customers(firstName, lastName, email, phone, Address)" + "VALUES (?,?,?,?,?);";
        jdbcTemplate.update(query,firstName, lastName, email, phone, address);
    }
    public void deleteCustomer(int id) {
        String query = "DELETE FROM customers WHERE CustomerID = ?;";
        jdbcTemplate.update(query,id);
    }
    public List<Customer> showAllCustomers() {
        String query = "SELECT * FROM customers;";
        RowMapper<Customer>rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(query, rowMapper);
    }
    public Customer getCustomer(int id) {
        String query = "SELECT * FROM customers WHERE CustomerId = ?;";
        RowMapper<Customer>rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
}
