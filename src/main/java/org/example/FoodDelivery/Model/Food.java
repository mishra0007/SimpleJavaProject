package org.example.FoodDelivery.Model;

import lombok.Getter;

@Getter
public class Food {
    private String foodName;
    private int foodRating;
    private Double foodPrice;

    public Food(String foodName, Double foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }


    public void setFoodRating(int rating) {
        this.foodRating = rating;
    }

}
