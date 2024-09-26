package org.example.SnakeGame.View;

import org.example.SnakeGame.GameConstants;
import org.example.SnakeGame.Model.interfaces.Player;

public class GameView {

    public void printStarted() {
        System.out.println("We have started the game");
    }

    public void printCurrentPosition(Player player) {
        System.out.printf("Player %s reached Position %s \n", player.getName(), player.getCurrentPosition());
    }

    public void printWinner(Player player) {
        System.out.printf("We have a WINNER, Player %s won the current game \n", player.getName());
    }

    public void printCurrentScenario(GameConstants steppedOn, int from, int to) {
        switch (steppedOn) {
            case LADDER:
                System.out.printf("Congrats you got a ladder and reached from %s to %s. \n", from, to);
                break;
            case SNAKE:
                System.out.printf("OOPS you stepped on a snake and reached from %s to %s. \n", from, to);
                break;
            default:
               System.out.println("OOPS you entered beyond your limit");

        }
    }

}
