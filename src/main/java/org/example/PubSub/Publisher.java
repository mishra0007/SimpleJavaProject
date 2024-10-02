package org.example.PubSub;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Publisher {

    private List<Topic> topics;
    private String id;

    public Publisher() {
        topics = new ArrayList<>();
        id = UUID.randomUUID().toString().substring(0, 16);
    }

    public void setTopics(Topic topic) {
        topics.add(topic);
    }

    public void publishMessage(Message message) {
        for (Topic topic: topics) {
            topic.publish(message);
        }
    }
}
