package org.example.CarRentalSystem.Payment;

public class PaymentByCard implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
