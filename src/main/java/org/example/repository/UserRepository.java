package org.example.repository;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createUser(String name, String email, String password) {
            String query = "INSERT INTO users(name, email, password)" + "VALUES (?,?,?);";
            jdbcTemplate.update(query, name, email, password);
    }

    public User validateUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email =? and password = ?;";
        RowMapper<User>rowMapper = new BeanPropertyRowMapper<>(User.class);
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, email, password);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
