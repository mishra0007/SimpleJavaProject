package org.example.FoodDelivery.Model;

import lombok.Getter;

import java.util.List;

@Getter
public class Menu {
    private List<Food> food;

    public Menu(List<Food> food) {
        this.food = food;
    }
}
