package org.example.SnakeGame.Controller;

import org.example.SnakeGame.Model.Board;
import org.example.SnakeGame.Model.Game;
import org.example.SnakeGame.Model.LudoPlayers;
import org.example.SnakeGame.View.GameView;

import java.util.List;

public class GameController {

    private final GameView view;
    private final Game game;

    public GameController(Board board, List<LudoPlayers> players) {
        view = new GameView();
        game = new Game(board, players, view);
    }

    public void startGame() {
        game.play();
    }
}
