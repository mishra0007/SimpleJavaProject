package org.example.CarRentalSystem;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
public class Customer {
    private final String customerID;
    private final String name;
    @Setter
    private Address address;
    @Setter
    private String drivingLicense;
    @Setter
    private Map<Date, Car> bookingHistory;

    public Customer(String name, String customerID, Address address, String drivingLicense) {
        this.name = name;
        this.customerID = customerID;
        this.address = address;
        this.drivingLicense = drivingLicense;
    }
}
