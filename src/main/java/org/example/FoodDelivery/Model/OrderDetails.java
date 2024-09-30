package org.example.FoodDelivery.Model;

import lombok.Getter;
import lombok.Setter;
import org.example.FoodDelivery.Model.ENUM.OrderStage;

import java.time.Instant;
import java.util.Date;

@Getter
public class OrderDetails {
    private Food food;
    @Setter
    private DeliveryAgent deliveryAgent;
    private Customer customer;
    private Restaurant restaurant;
    private Date orderTime;
    @Setter
    private Date deliveredTime;
    @Setter
    private OrderStage orderStage;
    @Setter
    private Payment payment;


    public OrderDetails(Food food, Customer customer, Restaurant restaurant) {
        this.food = food;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderStage = OrderStage.PROCESSING;
        orderTime = Date.from(Instant.ofEpochMilli(System.currentTimeMillis()));
    }


}
