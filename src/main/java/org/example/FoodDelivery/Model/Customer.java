package org.example.FoodDelivery.Model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements User {

    private String name;
    private int id;
    private int rating;
    private List<OrderDetails> orderHistory;
    private OrderDetails currentOrderDetails;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.rating = 5;
        orderHistory = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<OrderDetails> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public OrderDetails getCurrentOrder() {
        return currentOrderDetails;
    }

    @Override
    public void setOrderHistory(OrderDetails orderDetails) {
        orderHistory.add(orderDetails);
    }

    @Override
    public void setCurrentOrder(OrderDetails orderDetails) {
        currentOrderDetails = orderDetails;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        this.rating = (this.rating + rating)/2;
    }
}
