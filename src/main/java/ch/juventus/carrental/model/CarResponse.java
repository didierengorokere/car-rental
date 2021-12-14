package ch.juventus.carrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarResponse{

    public enum Type{
        CABRIO,
        LIMOUSINE,
        SUV,
        MINIBUS,
        COUPE,
        ESTATE
    }


    public enum GearShift{
        MANUAL,
        AUTOMATIC
    }

    private final long id;
    private final String name;
    private final Type type;
    private final GearShift gearShift;
    private final int seats;
    private final double pricePerDay;
    private final boolean airCondition;
    private List<String> rentInformation;

    public CarResponse(
            @JsonProperty("id") long id,
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "type", required = true) Type type,
            @JsonProperty(value = "gearShift", required = true) GearShift gearShift,
            @JsonProperty(value = "seats", required = true) int seats,
            @JsonProperty(value = "pricePerDay", required = true) double pricePerDay,
            @JsonProperty(value = "airCondition", required = true) boolean airCondition,
            @JsonProperty(value = "rentInformation") List<String> rentInformation) {

        this.id = id;
        this.name = name;
        this.type = type;
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

    public Type getType() {
        return type;
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

    public List<String> getRentInformation() {
        return rentInformation;
    }


}
