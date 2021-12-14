package ch.juventus.carrental.repository;

import ch.juventus.carrental.model.CarResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepository {



    public List<CarResponse> findAll(String name){
        List<CarResponse> cars = Arrays.asList(
                new CarResponse(
                        1,
                        "Seat",
                        null,
                        null,
                        4,
                        90,
                        true,
                        Arrays.asList("Ferienauto")
                ),
                new CarResponse(
                        1,
                        "BMW",
                        CarResponse.Type.CABRIO,
                        null,
                        4,
                        150,
                        true,
                        Arrays.asList("Sportwagen")
                ),
                new CarResponse(
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
            List<CarResponse> filtered = new ArrayList<>();

            for (CarResponse p: cars){
                if (p.getName().contains(name))
                    filtered.add(p);
            }
            return filtered;
        }
    }
}
