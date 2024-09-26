package org.example.SnakeGame.Model.interfaces;

public interface Player<T> {
    String getName();
    Integer getCurrentPosition();
    void makeMove(T roll);
    int rollDice();
}
