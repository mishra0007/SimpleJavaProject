package org.example.PubSub;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Subscriber {

    private List<Topic> topicList;
    private String id;

    public Subscriber() {
        topicList = new ArrayList<>();
        id = UUID.randomUUID().toString().substring(0, 16);
    }

    public void displayPublishedMessage(Message message) {
        System.out.printf("Message Published to subscriber id%s: with content %s\n", id, message.getContent());
    }
}
