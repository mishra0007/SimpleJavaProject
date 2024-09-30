package org.example.FoodDelivery.Controller;

import org.example.FoodDelivery.Model.*;
import org.example.FoodDelivery.Model.ENUM.OrderStage;
import org.example.FoodDelivery.View.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FoodDeliveryController {

    private List<Restaurant> restaurantList;
    private List<DeliveryAgent> deliveryAgents;
    private OrderDetails currentOrder;
    private Notification notification;

    FoodDeliveryController() {
        Food food1 = new Food("food1", 65.0);
        Food food2 = new Food("food2", 70.0);
        List<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        Menu menu = new Menu(foods);
        Restaurant restaurant = new Restaurant(menu, "restaurant1", 1);
        restaurantList = List.of(restaurant);
        DeliveryAgent deliveryAgent = new DeliveryAgent("Agent1", 1);
        deliveryAgents = List.of(deliveryAgent);
        notification = new Notification();
    }


    public void orderFood(String restaurant, String food, Customer customer) {
       for(Restaurant restaurant1: restaurantList) {
           if(Objects.equals(restaurant1.getName(), restaurant)) {
               List<Food> foodList = restaurant1.getMenu().getFood();
               for(Food food1: foodList) {
                   if(Objects.equals(food1.getFoodName(), food)) {
                       currentOrder = new OrderDetails(food1, customer, restaurant1);
                       currentOrder.setOrderStage(OrderStage.PROCESSING);
                       customer.setCurrentOrder(currentOrder);
                       notification.orderPlaced(currentOrder);
                       shipOrder();
                       payForFood();
                       orderDelivered();
                       return;
                   }
               }
           }
       }
    }

    public void payForFood() {
        Payment payment = new Payment(currentOrder);
        currentOrder.setPayment(payment);
        currentOrder.getPayment().doPayment();
        notification.paymentSuccessfully(currentOrder);
    }

    private void shipOrder() {
        currentOrder.setOrderStage(OrderStage.PROCESSING);
        for (DeliveryAgent agent: deliveryAgents) {
            if(Objects.isNull(agent.getCurrentOrder())) {
                currentOrder.setDeliveryAgent(agent);
                agent.setCurrentOrder(currentOrder);
                currentOrder.setOrderStage(OrderStage.ON_THE_WAY);
                notification.foundDeliveryPartner(currentOrder);
                break;
            }
        }
        // Delivery Partners are busy please wait
    }

    private void orderDelivered() {
        currentOrder.setDeliveredTime(new Date());
        currentOrder.setOrderStage(OrderStage.COMPLETED);
        currentOrder.getCustomer().setOrderHistory(currentOrder);
        currentOrder.getDeliveryAgent().setOrderHistory(currentOrder);
        currentOrder.getRestaurant().setOrderHistory(currentOrder);
        notification.foodDelivered(currentOrder);
    }
}
