package ch.juventus.carrental.repository;

import ch.juventus.carrental.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepository {



    public List<Car> findAll(String name){
        List<Car> cars = Arrays.asList(
                new Car(
                        1,
                        "Seat",
                        null,
                        null,
                        4,
                        90,
                        true,
                        Arrays.asList("Ferienauto")
                ),
                new Car(
                        1,
                        "BMW",
                        Car.Type.CABRIO,
                        null,
                        4,
                        150,
                        true,
                        Arrays.asList("Sportwagen")
                ),
                new Car(
                        1,
                        "Mercedes",
                        null,
                        null,
                        4,
                        210,
                        true,
                        Arrays.asList("Luxusauto"))
        );

        if (name ==null)
            return cars;

        else{
            name = name.toLowerCase();
            List<Car> filtered = new ArrayList<>();

            for (Car p: cars){
                if (p.getName().contains(name))
                    filtered.add(p);
            }
            return filtered;
        }
    }
}
