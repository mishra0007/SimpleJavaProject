package org.example.FoodDelivery.Model;

import java.util.List;

public interface User {
    String getName();
    int getId();
    List<OrderDetails> getOrderHistory();
    OrderDetails getCurrentOrder();
    void setOrderHistory(OrderDetails orderDetails);
    void setCurrentOrder(OrderDetails orderDetails);
    int getRating();
    void setRating(int rating);
}
