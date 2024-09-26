package org.example.SnakeGame.Model;

import org.example.SnakeGame.Model.interfaces.Player;

import java.util.Random;

public class LudoPlayers implements Player<Integer> {
    private final String name;
    private Integer currentPosition;

    public LudoPlayers(String name) {
        this.name = name;
        currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public void makeMove(Integer nextPosition) {
        currentPosition = nextPosition;
    }

    @Override
    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

}
