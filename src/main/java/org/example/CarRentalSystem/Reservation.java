package org.example.CarRentalSystem;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Getter
public class Reservation {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private Date bookingFrom;
    private Date bookingTo;
    private String bookingID;
    private double totalCost;

    public Reservation(Car car, Customer customer, Date bookingFrom, Date bookingTo) {
        this.car = car;
        this.customer = customer;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        bookingDate = Date.from(Instant.ofEpochMilli(System.currentTimeMillis()));
        totalCost = calculatePrice(car);
        bookingID = setBookingID();
    }

    private String setBookingID() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private double calculatePrice(Car car) {
        return ChronoUnit.DAYS.between(bookingFrom.toInstant(), bookingTo.toInstant())*car.getPerDayCharge();
    }


}
