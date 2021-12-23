package ch.juventus.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.juventus.carrental.service.CarService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
// @RequestMapping adds at the beginning of the URL the Standard value "/api/v1/"
@RequestMapping(value = "/api/v1/")
public class CarController{

    // final Logger logger = LoggerFactory.getLogger(CarController.class);

    private Map<Integer, String> cars = new HashMap<Integer, String>();

    private static final String FRONTEND_ENDPOINT = "http://localhost:4200";
    private final CarService carService;
    public CarController(CarService carService) {this.carService = carService;}


    // List of all cars GEMACHT
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    @GetMapping("cars")
    public ResponseEntity<String> allCars() throws IOException {
        String response = carService.getAllCars();
        System.out.println("show all cars");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Add Car
    // GEMACHT
    @PostMapping ("car/")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    public void addCar(@RequestBody String car) throws IOException{
        carService.postCarToDB(car);
        System.out.println("add this car: " + car);
    }

    //Delete Car
    //GEMACHT
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    @DeleteMapping ("car/{id}")
    public void deleteCar(@PathVariable Integer id) throws IOException {
        carService.deleteCar(id);
        System.out.println ("delete car with id: " + id);
    }

/*
    //Edit Car
    //GEMACHT
    @PutMapping ("car/{id}")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    public void editCar(@RequestBody String car, @PathVariable Integer id) throws IOException{
        carService.editCar(car, id);
        System.out.println("edit car with id: " + id + car);
    }



    //Find car by ID
    //GEMACHT
    @GetMapping ("car/{id}")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    public ResponseEntity<String> findCarID(@PathVariable int id) throws IOException{
    String response = carService.getCarById(id);
    System.out.println("show car with id: " + id);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Find cars with filter
    //The list of suitable cars should be sorted in ascending order by price
    //GEMACHT
    @GetMapping ("cars?filter={...}")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    public String filterCars(String filter){

        return "filter Cars = " + filter;
    }




    //Rent a Car
    //GEMACHT
    @PostMapping ("car/{id}/rentings")
    @CrossOrigin(origins = FRONTEND_ENDPOINT)
    public String rentCar(@PathVariable int id) {
        return "rent Car with id = " + id;
    }


    //ab hier alles nur ein Test





 */








}
