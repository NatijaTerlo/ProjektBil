package org.example.repository;
import org.example.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Car> showAllCars() {
        String query = "SELECT * FROM cars";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void insertCar(String brand, String model, int year, String color, double price, boolean availability) {
            String query = "INSERT INTO cars(brand, model, year, color, price, availability)" + "VALUES (?,?,?,?,?,?);";
            jdbcTemplate.update(query,brand, model, year, color, price, availability);
        }

    public List<Car> updateCar(String brand, String model, int year, String color, double price, boolean availability) {
        String query = "SELECT * FROM cars WHERE brand = ? and model = ? and year = ? and color = ? and price = ? and availability = ?;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(query, rowMapper, brand, model, year, color, price, availability);
    }

    public void deleteCar(int id) {
        String query = "DELETE FROM cars WHERE CarId = ?;";
        jdbcTemplate.update(query,id);
    }

    public void addCar(String brand, String model, int year, String color, double price, boolean availability) {
            String query = "INSERT INTO cars (brand, model, year,color, price, availability)" +
                    "VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(query,brand, model, year, color, price, availability);

    }

    public Car getCar(int id) {
        String query = "SELECT * FROM cars WHERE CarId= ?;";
        RowMapper<Car>rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public List<Car> findNewCars() {
        String query = "SELECT * FROM cars";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void deleteById(int id) {
        String query = "DELETE FROM cars WHERE CarId = ?;";
        jdbcTemplate.update(query,id);
    }

    public Car findById(int id) {
      String query = "SELECT * FROM cars WHERE CarId = ?";
      RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
      return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

}

