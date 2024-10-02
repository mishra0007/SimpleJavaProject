package org.example.CarRentalSystem;

import java.math.RoundingMode;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CarRentalDemo {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();
        Car car1 = new Car("TATA", "1244", 100.0);
        Car car2 = new Car("TESLA", "1245", 800.0);
        rentalSystem.setCarMap(car1);
        rentalSystem.setCarMap(car2);
        Customer customer = new Customer("Abhishek", "123",
                        new Address("Kolkata", 12346, "Behind you"), "LIN123");
        List<Car> carList = rentalSystem.searchCar("TESLA");
        Reservation reservation = RentalSystem.makeReservation(car1, customer,
                new Date(), Date.from((new Date()).toInstant().plus(2, ChronoUnit.DAYS)));
        if(Objects.isNull(reservation)) {
            System.out.println("Reservation failed!");
        } else {
            System.out.printf("Your reservation was successful. Please pay amount %.2f \n",  reservation.getTotalCost());
        }
    }
}
