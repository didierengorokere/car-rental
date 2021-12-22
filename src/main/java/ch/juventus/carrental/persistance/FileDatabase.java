package ch.juventus.carrental.persistance;

import ch.juventus.carrental.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class FileDatabase implements Database {

    private String databasePath = "src/main/java/juventus/carrental/persistance/cars.json";

    @Override
    public String loadHelloWorldGreeting() {
        return "hello world";
    }

    //Database
    public String dbAsString() throws IOException{
        File file = new File(databasePath);
        String dbAsString = new String(Files.readAllBytes(Paths.get(file.toURI())));
        return dbAsString;
    }

    public List<Car> dbAsObject() throws IOException {
        String dbAsString = dbAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = objectMapper.readValue(dbAsString, new TypeReference<List<Car>>() {
        });
        return cars;
    }

    // Cars
    public Car showCarByID(Integer id) throws IOException {
        List<Car> cars = dbAsObject();

        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }

    public List<Car> deleteCarByID(Integer id) throws IOException {
        List<Car> cars = dbAsObject();
        for (Car car: cars){
            if (car.getId() == id){
                cars.remove(car);
                break;
            }
        }
        saveArrayAsDB(cars);
        return cars;
    }

    public String objectToJsonString(Car carObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carInString = objectMapper.writeValueAsString(carObject);
        return carInString;
    }

    public Car jsonStringToObjact(String carString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(carString, Car.class);
        return car;
    }

    public Integer idHeandler() throws IOException {
        List<Car> cars = dbAsObject();
        Set<Integer> ids = new TreeSet<Integer>();

        for (Car car: cars){
            ids.add((int) car.getId());
        }
        int i = ((TreeSet<Integer>) ids).last()+1;
        System.out.println("next id"+i);
        return i;
    }


    public void saveArrayAsDB(List<Car> cars) throws IOException {
        FileWriter file = new FileWriter(databasePath);
        try {
            file.write("[\n");
            for (Car car : cars) {

                file.write(" {\n");
                file.write("  \"id\": " + car.getId() + ",\n");
                file.write("  \"name\": \"" + car.getName() + "\",\n");
                file.write("  \"type\": \"" + car.getType() + "\",\n");
                file.write("  \"gearShift\": \"" + car.getGearShift() + "\",\n");
                file.write("  \"seats\": " + car.getSeats() + ",");
                file.write("  \"pricePerDay\": " + car.getPricePerDay() + ",\n");
                file.write("  \"airCondition\": " + car.isAirCondition() + ",\n");
                file.write("  \"rentInformation\": " + car.getRentInformation() + "\n");
                if (car == cars.get(cars.size() - 1)) {
                    file.write(" }\n");
                } else {
                    file.write(" },\n");
                }
            }
            file.write("]\n");
        } catch (IOException e) {

        } finally {
            file.flush();
            file.close();
        }
    }

}
