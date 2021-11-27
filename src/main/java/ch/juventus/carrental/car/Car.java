package ch.juventus.carrental.car;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Car {

    private final long id;
    private final String name;
    private final  CarType carType;
    private final GearShift gearShift;
    private final int seats;
    private final  double pricePerDay;
    private final boolean airCondition;
    private final List<RentInformation> rentInformation;

    public Car(@JsonProperty("id") long id,
               @JsonProperty(value = "name", required = true) String name,
               @JsonProperty(value = "type", required = true) CarType carType,
               @JsonProperty(value = "gearShift", required = true) GearShift gearShift,
               @JsonProperty(value = "seats", required = true) int seats,
               @JsonProperty(value = "pricePerDay", required = true) double pricePerDay,
               @JsonProperty(value = "airCondition", required = true) boolean airCondition,
               @JsonProperty(value = "rentInformation") List<RentInformation> rentInformation ,{

        this.id = id;
        this.name = name;
        this.carType = carType;
        this.gearShift = gearShift;
        this.seats = seats;
        this.pricePerDay = pricePerDay;
        this.airCondition = airCondition;
        this.rentInformation = rentInformation;


    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CarType getCarType() {
        return carType;
    }

    public GearShift getGearShift() {
        return gearShift;
    }

    public int getSeats() {
        return seats;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public List<RentInformation> getRentInformation() {
        return rentInformation;
    }
}
