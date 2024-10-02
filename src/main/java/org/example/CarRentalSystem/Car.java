package org.example.CarRentalSystem;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class Car {
    private final String carModel;
    private final String numberPlate;
    @Setter
    private double perDayCharge;
    private List<Reservation> bookingHistory;

    public Car(String carModel, String carLicense, double perDayCharge) {
        this.carModel = carModel;
        this.numberPlate = carLicense;
        this.perDayCharge = perDayCharge;
        bookingHistory = new ArrayList<>();
    }

    public void setBookingHistory(Reservation reservation) {
        bookingHistory.add(reservation);
    }
}
