package org.example.CarRentalSystem;

import lombok.Getter;

@Getter
public class Address {
    private final String city;
    private final int pincode;
    private final String address;

    public Address(String city, int pincode, String address) {
        this.city = city;
        this.pincode = pincode;
        this.address = address;
    }
}
