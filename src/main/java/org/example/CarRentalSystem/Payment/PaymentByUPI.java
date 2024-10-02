package org.example.CarRentalSystem.Payment;

public class PaymentByUPI implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
