package ch.juventus.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.juventus.carrental.service.CarService;

import java.io.IOException;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloworld() {
        String response = carService.getHelloWorldGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/api/v1/car")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    @SuppressWarnings("unused")
    public ResponseEntity<Boolean> addCar(@RequestBody Car car) throws IOException{
        logger.info("Adding new car with name '{}'",car.getName());
        Long newId = carService.addCar(car);
        return new ResponseEntity<>(newId,HttpStatus.OK);
    }

    @PutMapping("/api/v1/car/{id}")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    @SuppressWarnings("unused")
    public ResponseEntity<Boolean> updateCar(@PathVariable Long id, @RequestBody car updatedCar) throws IOException{
        logger.info("Update car with new id '{}'",id);
        boolean didUpdate = carService.updateCar(updatedCar);
        return new ResponseEntity<>(didUpdate, HttpStatus.OK)
    }

    @DeleteMapping("/api/v1/car/{id}")
    @CrossOrigin (origins = FRONTEND_ENDPOINT)
    @SuppressWarnings("unused")
    public ResponseEntity<Boolean> deleteCar(@PathVariable long id) throws IOException{
        logger.info("Delete car with id '{}'", id);
        boolean didDelete = carService.deleteCar(id);
        return new ResponseEntity<>(didDelete, HttpStatus.OK);
    }

    @PutMapping ("/api/v1/car/{id}/rent")
    @CrossOrigin (origins = FRONTEND_ENDPOINT)
    @SuppressWarnings("unused")
    public  ResponseEntity<Long> rentCar(@PathVariable Long id, @RequestBody RentInformation rentInformation) throws IOException{
        logger.info("Renting car with id {} form {} to {}", id rentInformation.getStartDate(), rentInformation.getEndDate());
        carService.rentCar(id,rentInformation);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
