package org.example.controllers;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.models.Car;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all_cars")
    public String showAllCars(Model model){
        List<Car>cars = carService.showAllCars();
        model.addAttribute("cars",cars);
        return "home/all_cars";
    }
    @GetMapping("/add_car")
    public String addCar() {
        return "home/add_car";

    }
    /*@PostMapping("/insert_car")
    public String insertCar(@RequestParam String brand,
                            @RequestParam String model,
                            @RequestParam int year,
                            @RequestParam String color,
                            @RequestParam double price,
                            @RequestParam boolean availability){
       carService.insertCar(brand, model, year, color, price, availability);
       return "redirect:/all_cars"; //home
    }

     */

    @PostMapping("/insert_car")
    public String insertCar(@RequestParam String brand,
                            @RequestParam String model,
                            @RequestParam int year,
                            @RequestParam String color,
                            @RequestParam double price,
                            @RequestParam boolean availability, RedirectAttributes redirectAttributes) {
        carService.insertCar(brand, model, year, color, price, availability);
        redirectAttributes.addFlashAttribute("successMessage", "The car has been added successfully!");
        return "redirect:/car_added_success";
    }

    @PostMapping("/update_car")
    public String updateCar(@RequestParam String brand,
                            @RequestParam String model,
                            @RequestParam int year,
                            @RequestParam String color,
                            @RequestParam double price,
                            @RequestParam boolean availability){
        carService.updateCar(brand, model, year, color, price, availability);
        return "redirect:/update_car"; //home
    }

    @PostMapping("/delete_car")
    public String deleteCar(@RequestParam int id) {
        carService.deleteCar(id);
        return "redirect:/all_cars";
    }

    @GetMapping("/delete_car")
    public String deleteCar(@RequestParam int id, Model model){
        Car car = carService.getCar(id);
        System.out.println(car);
        model.addAttribute("id", car.getCarId());
        model.addAttribute("brand", car.getBrand());
        model.addAttribute("model", car.getModel());
     return "home/delete_car";
    }

    @GetMapping("/car_added_success")
    public String carAdded(Model model){
        model.addAttribute("message", "Car added successfully!");
        return "home/car_added_success";
    }
    @GetMapping("/new_cars")
    public String showNewCars(Model model){
        List<Car>newCars = carService.showAllCars();
        model.addAttribute("newCars", newCars);
        return "new_cars";

    }

}
