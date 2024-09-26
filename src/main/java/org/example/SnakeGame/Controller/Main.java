package org.example.SnakeGame.Controller;

import org.example.SnakeGame.Model.Board;
import org.example.SnakeGame.Model.LudoPlayers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        HashMap<Integer, Integer> ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);

        Board board = new Board(snakes, ladders);
        List<LudoPlayers> players = new ArrayList<>();
        players.add(new LudoPlayers("Player 1"));
        players.add(new LudoPlayers("Player 2"));
        GameController gameController = new GameController(board, players);
        gameController.startGame();
    }
}
