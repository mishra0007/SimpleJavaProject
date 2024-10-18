package org.example.StackOverflow.Model;

import lombok.Getter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
public class Answer {

    private final String id;
    private String answerDescription;
    private final User user;
    private final Date timestamp;

    public Answer(String answerDescription, User user) {
        this.answerDescription = answerDescription;
        this.user = user;
        id = UUID.randomUUID().toString().substring(0,15);
        timestamp = Date.from(Instant.ofEpochMilli(System.currentTimeMillis()));
    }
}
