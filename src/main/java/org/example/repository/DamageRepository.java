package org.example.repository;
import org.example.models.Damage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DamageRepository {
@Autowired
    JdbcTemplate jdbcTemplate;

    public List<Damage> showAllDamages() {
        String query = "SELECT * FROM damages;";
        RowMapper<Damage>rowMapper = new BeanPropertyRowMapper<>(Damage.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<Damage>getDamages(){
    String query ="SELECT * FROM damages;";
    RowMapper<Damage>rowMapper = new BeanPropertyRowMapper<>(Damage.class);
    return jdbcTemplate.query(query, rowMapper);
    }

    public void createDamage(int contractId, String description, double price) {
        String query = "INSERT INTO damages(ContractId, description, price)" + "VALUES (?,?,?);";
        jdbcTemplate.update(query, contractId, description, price);
    }

    public void insertDamage(int contractId, String description, double price){
        String query = "INSERT INTO damages(ContractId, description, price)" + "VALUES(?,?,?);";
        jdbcTemplate.update(query, contractId, description, price);
    }

    public void deleteDamage(int id) {
        String query = "DELETE FROM damages WHERE DamageID = ?;";
         jdbcTemplate.update(query, id);
    }
    public Damage getDamage(int id){
        String query = "SELECT * FROM damages WHERE DamageID = ?;";
        RowMapper<Damage>rowMapper = new BeanPropertyRowMapper<>(Damage.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

}
