package org.example.FoodDelivery.Model;

import lombok.Getter;
import org.example.FoodDelivery.Model.ENUM.PaymentStage;

import java.util.Random;

@Getter
public class Payment {
    private OrderDetails orderDetails;
    private int paymentID;
    private PaymentStage paymentStage;

    public Payment(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        paymentID = new Random().nextInt();
        paymentStage = PaymentStage.PENDING;
    }

    public void doPayment() {
        paymentStage = PaymentStage.COMPLETED;
    }
}
