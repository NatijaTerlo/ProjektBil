package org.example.repository;
import org.example.models.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createContract(int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
        String query = "INSERT INTO contracts(customerId, carId, startDate, endDate, totalPrice)" + "VALUES (?,?,?,?,?);";
        jdbcTemplate.update(query,customerId,carId, startDate, endDate, totalPrice);
    }
    public Contract updateContract(int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
        String query = "SELECT * FROM contracts WHERE customerId = ? and carId and startDate = ? and endDate = ? and totalPrice = ?;";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return jdbcTemplate.queryForObject(query, rowMapper, customerId, carId, startDate, endDate, totalPrice);
    }
    public void deleteContract(int id){
        String query = "DELETE FROM contracts WHERE ContractID = ?;";
       jdbcTemplate.update(query, id);
    }

    public List<Contract> showAllContracts() {
        String query = "SELECT * FROM contracts;";
        RowMapper<Contract>rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public Contract getContract(int id) {
        String query = "SELECT * FROM contracts WHERE contractID = ?;";
        RowMapper<Contract>rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);

    }

    public void insertContract(int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
        String query = "INSERT INTO contracts(customerId, carId, startDate, endDate, totalPrice)" + "VALUE (?,?,?,?,?);";
        jdbcTemplate.update(query, customerId, carId, startDate, endDate, totalPrice);
    }
}

