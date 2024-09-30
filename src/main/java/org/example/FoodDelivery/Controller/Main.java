package org.example.FoodDelivery.Controller;

import org.example.FoodDelivery.Model.Customer;

public class Main {
    public static void main(String[] args) {
        FoodDeliveryController foodDeliveryController = new FoodDeliveryController();
        foodDeliveryController.orderFood("restaurant1", "food1", new Customer("Abhishek", 1));
    }
}
