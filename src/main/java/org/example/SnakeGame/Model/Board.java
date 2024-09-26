package org.example.SnakeGame.Model;

import java.util.HashMap;
import java.util.Optional;

public class Board {
    private final HashMap<Integer, Integer> snake;
    private final HashMap<Integer, Integer> ladder;

    public Board(HashMap<Integer, Integer> snake, HashMap<Integer, Integer> ladder) {
        this.snake = snake;
        this.ladder = ladder;
    }

    public Optional<Integer> isSnake(int currentPosition) {
        return Optional.ofNullable(snake.get(currentPosition));
    }

    public Optional<Integer> isLadder(int currentPosition) {
        return Optional.ofNullable(ladder.get(currentPosition));
    }

}
