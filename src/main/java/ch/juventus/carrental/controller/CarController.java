package ch.juventus.carrental.controller;
import ch.juventus.carrental.model.CarResponse;
import ch.juventus.carrental.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CarController {

    final Logger logger = LoggerFactory.getLogger(CarController.class);

    @GetMapping ("/api/v1/cars")
    public String car(){
        // logger.info("Adding new car with name '{}'", CarResponse.getName());
        return "brum";
    }

    @GetMapping ("/api/v1/car/{id}")
    public String carID(){
        return "carID";
    }

    @PostMapping ("/api/v1/car")
    public String addCar(){
        return "add Car";
    }

    @PutMapping (" /api/v1/car/{id}")
    public  String editCar(){
        return  "Editor Car";
    }

    @DeleteMapping ("/api/v1/car/{id}")
    public String deleteCar(){
        return "Car deleted";
    }

    CarRepository carRepository= new CarRepository();

    @GetMapping("/cars")
    public List<CarResponse> getAllCars(
            @RequestParam(required = false) String name
    ){
        return carRepository.findAll(name);

    }




}
