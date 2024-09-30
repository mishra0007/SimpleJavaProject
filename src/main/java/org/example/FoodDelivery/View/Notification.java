package org.example.FoodDelivery.View;

import org.example.FoodDelivery.Model.ENUM.OrderStage;
import org.example.FoodDelivery.Model.ENUM.PaymentStage;
import org.example.FoodDelivery.Model.OrderDetails;

import java.util.Objects;

public class Notification {

    public void orderPlaced(OrderDetails orderDetails) {
        if(Objects.nonNull(orderDetails)) {
            System.out.printf("Your order was successfully placed: \n  " +
                            "Order for: %s. \n Food Ordered: %s. from Restaurant %s. \n Order Status: %s.\n",
                    orderDetails.getCustomer().getName(), orderDetails.getFood().getFoodName(),
                    orderDetails.getRestaurant().getName(), orderDetails.getOrderStage());
            System.out.printf("Please Pay Amount %f.\n", orderDetails.getFood().getFoodPrice());
        } else {
            System.out.println("OOPS order was failed");
        }
    }

    public void foundDeliveryPartner(OrderDetails orderDetails) {
        if(Objects.nonNull(orderDetails.getDeliveryAgent())) {
            System.out.printf("We have assigned a delivery Partner for you %s",
                    orderDetails.getDeliveryAgent().getName());
            System.out.printf("Order Status %s.", orderDetails.getOrderStage());
        } else {
            System.out.println("Delivery Partner was not found");
        }
    }

    public void paymentSuccessfully(OrderDetails orderDetails) {
        if(Objects.equals(orderDetails.getPayment().getPaymentStage(), PaymentStage.COMPLETED)) {
            System.out.printf("You successfully paid Amount %f.\n", orderDetails.getFood().getFoodPrice());
            System.out.printf("Order Status %s.", orderDetails.getOrderStage());
        } else {
            System.out.println("Payment failed");
        }
    }

    public void foodDelivered(OrderDetails orderDetails) {
        if(Objects.equals(orderDetails.getOrderStage(), OrderStage.COMPLETED)) {
            System.out.println("Enjoy your food.");
            System.out.printf("Order Status %s.", orderDetails.getOrderStage());
        } else {
            System.out.println("Ordered Failed to be delivered");
        }
    }
}
