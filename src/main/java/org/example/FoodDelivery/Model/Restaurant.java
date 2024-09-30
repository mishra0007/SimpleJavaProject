package org.example.FoodDelivery.Model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements User {

    private Menu menu;
    private String name;
    private int id;
    private int rating = -1;
    private List<OrderDetails> orderHistory;
    private OrderDetails currentOrderDetails;

    public Restaurant(Menu menu, String name, int id) {
        this.menu = menu;
        this.name = name;
        this.id = id;
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
        return getCurrentOrder();
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
        if(rating == -1) return 0;
        return rating;
    }

    @Override
    public void setRating(int rating) {
        if(rating == -1) rating = 0;
        this.rating = (this.rating + rating)/2;
    }

    public Menu getMenu() {
        return  menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
