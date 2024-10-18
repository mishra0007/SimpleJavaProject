package org.example.StackOverflow.Model;

import lombok.Getter;

@Getter
public class User {
    private final int id;
    private final String name;
    private final String profession;

    private static int counter = 1;

    public User(String name, String profession) {
        this.name = name;
        this.profession = profession;
        synchronized (User.class) {
            id = counter++;
        }
    }
}
