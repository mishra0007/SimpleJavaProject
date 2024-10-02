package org.example.PubSub;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Message {
    private final String id;
    private final String content;

    public Message(String content) {
        id = UUID.randomUUID().toString().substring(0, 16);
        this.content = content + " ID: " + id;
    }
}
