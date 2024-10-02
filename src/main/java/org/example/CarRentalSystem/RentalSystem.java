package org.example.CarRentalSystem;

import org.example.CarRentalSystem.Payment.PaymentByCard;
import org.example.CarRentalSystem.Payment.PaymentProcessor;

import java.util.*;

public class RentalSystem {
    private static RentalSystem instance;
    private Map<String, Car> carMap;
    private static Map<String, Reservation> reservationMap;
    private PaymentProcessor paymentProcessor;

    private RentalSystem() {
        carMap = new HashMap<>();
        reservationMap = new HashMap<>();
        paymentProcessor = new PaymentByCard();
    }

    public static synchronized RentalSystem getInstance() {
        if(Objects.isNull(instance)) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public static synchronized Reservation makeReservation(Car car, Customer customer, Date bookingFrom, Date bookingTo) {
        if(isCarAvailable(car, bookingFrom, bookingTo)) {
            Reservation reservation = new Reservation(car, customer, bookingFrom, bookingTo);
            reservationMap.put(reservation.getBookingID(), reservation);
            car.setBookingHistory(reservation);
            return reservation;
        }
        return null;
    }

    public static synchronized void cancelReservation(Reservation reservation) {
        reservationMap.remove(reservation.getBookingID());
        for(Reservation reservation1: reservation.getCar().getBookingHistory()) {
            if(reservation1.getBookingID().equalsIgnoreCase(reservation.getBookingID())) {
                reservation.getCar().getBookingHistory().remove(reservation1);
                break;
            }
        }
    }

    public List<Car> searchCar(String carModel) {
        List<Car> carList = new ArrayList<>();
        for(Map.Entry<String, Car> carEntry: carMap.entrySet()) {
            if(carEntry.getKey().equalsIgnoreCase(carModel)) {
                carList.add(carEntry.getValue());
            }
        }
        return carList;
    }

    public boolean makePayment(double amount) {
        return  paymentProcessor.processPayment(amount);
    }

    public void setCarMap(Car car) {
        carMap.put(car.getCarModel(), car);
    }

    private static boolean isCarAvailable(Car car, Date bookingFrom, Date bookingTo) {

        for (Reservation reservation : car.getBookingHistory()) {
            if(bookingFrom.before(reservation.getBookingTo()) && bookingTo.after(reservation.getBookingFrom()))
                return false;
        }
        return true;
    }
}
