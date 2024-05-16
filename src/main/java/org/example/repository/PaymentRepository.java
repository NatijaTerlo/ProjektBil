package org.example.repository;

import org.example.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class PaymentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Payment> showAllPayments(){
        String query = "SELECT * FROM payments";
        RowMapper<Payment>rowMapper = new BeanPropertyRowMapper<>(Payment.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<Payment>getPayments(){
        String query = "SELECT * FROM payments;";
        RowMapper<Payment>rowMapper = new BeanPropertyRowMapper<>(Payment.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createPayment(int contractId, double amount, Date paymentDate, String paymentMethod) {
        String query = "INSERT INTO payments(contractId, amount, paymentDate, paymentMethod)" + "VALUES (?,?,?,?)";
        jdbcTemplate.update(query,contractId,amount, paymentDate, paymentMethod);
    }

    public void updatePayment(int contractId, double amount, Date paymentDate, String paymentMethod) {
        String query = "INSERT INTO payments(contractId, amount, paymentDate, paymentMethod)" + "VALUE (?,?,?,?);";
        jdbcTemplate.update(query, contractId, amount, paymentDate, paymentMethod);
    }

    public void deletePayment(int id) {
        String query = "DELETE FROM payments WHERE paymentID = ?;";
        jdbcTemplate.update(query, id);
    }

    public Payment getPayment(int id) {
       String query ="SELECT * FROM payments WHERE PaymentID = ?;";
       RowMapper<Payment>rowMapper = new BeanPropertyRowMapper<>(Payment.class);
       return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void insertPayment(int contractId, double amount, Date paymentDate, String paymentMethod) {
        String query = "INSERT INTO payments(contractId, amount, paymentDate, paymentMethod)" + "VALUE (?,?,?,?);";
        jdbcTemplate.update(query, contractId, amount, paymentDate, paymentMethod);
    }
}
