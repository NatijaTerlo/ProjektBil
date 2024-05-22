package org.example.service;
import org.example.models.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired

    private CarRepository carRepository;

    public void addCar(String brand, String model, int year, String color, double price, boolean availability){
        carRepository.addCar(brand, model, year, color, price, availability);
    }

    public List<Car> showAllCars() {
        return carRepository.showAllCars();
    }

    public void insertCar(String brand, String model, int year, String color, double price, boolean availability) {
        carRepository.insertCar(brand, model, year, color, price, availability);
    }

    public void updateCar(String brand, String model, int year, String color, double price, boolean availability) {
        carRepository.updateCar(brand, model, year, color, price, availability);
    }

    public void deleteCar(int id) {
        carRepository.deleteCar(id);
    }

    public Car getCar(int id) {
        return carRepository.getCar(id);
    }

    public List<Car>showNewCars() {
      return carRepository.findNewCars();
    }

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
    public void rentedCar(Car car ){
        car.setRented(true);
    }

}
