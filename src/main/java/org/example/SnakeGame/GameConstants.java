package org.example.SnakeGame;

public enum GameConstants {
    SNAKE("SNAKE"),
    LADDER("LADDER");

    private final String value;

    // Constructor
    GameConstants(String value) {
        this.value = value;
    }

    // Getter method to access the value
    public String getValue() {
        return value;
    }
}
