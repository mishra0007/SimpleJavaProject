package org.example.SnakeGame.Model;

import org.example.SnakeGame.View.GameView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.example.SnakeGame.GameConstants.LADDER;
import static org.example.SnakeGame.GameConstants.SNAKE;

public class Game {
    private final Board board;
    private Queue<LudoPlayers> ludoPlayers;
    private final GameView view;

    public Game(Board board, List<LudoPlayers> ludoPlayersList, GameView view) {
        this.board = board;
        this.view = view;
        ludoPlayers = new LinkedList<>(ludoPlayersList);
    }

    public void play() {
        view.printStarted();
        while (!ludoPlayers.isEmpty()) {
            LudoPlayers player = ludoPlayers.poll();
            int nextMove = nextPosition(player);
            if(nextMove != -1) {
                player.makeMove(nextMove);
                if (player.getCurrentPosition() == 100) {
                    view.printWinner(player);
                    break;
                }
                view.printCurrentPosition(player);
            }
            ludoPlayers.add(player);
        }
    }

    private int nextPosition(LudoPlayers player) {
        int nextStep = player.rollDice();
        int nextPosition = player.getCurrentPosition() + nextStep;
        if(nextPosition > 100)
            return -1;
        if(board.isLadder(nextPosition).isPresent()) {
            nextPosition = board.isLadder(nextPosition).get();
            view.printCurrentScenario(LADDER, player.getCurrentPosition(), nextPosition);

        } else if (board.isSnake(nextPosition).isPresent()) {
            nextPosition = board.isSnake(nextPosition).get();
            view.printCurrentScenario(SNAKE, player.getCurrentPosition(), nextPosition);
        }
        return nextPosition;
    }

}
