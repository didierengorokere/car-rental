package ch.juventus.carrental.renting;

import java.util.Date;

public class RentInfo {
    public final String startDate;
    public final String endDate;
    public final Double totalPrice;

    public RentInfo(String startDate, String endDate, Double totalPrice) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
