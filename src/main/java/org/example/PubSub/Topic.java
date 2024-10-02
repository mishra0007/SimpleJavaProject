package org.example.PubSub;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Topic {

    private List<Subscriber> subscribers;
    private Publisher publisher;
    private String id;
    private ExecutorService executor;

    public Topic(Publisher publisher) {
        this.publisher = publisher;
        subscribers = new ArrayList<>();
        id = UUID.randomUUID().toString().substring(0, 16);
        publisher.setTopics(this);
        executor = Executors.newFixedThreadPool(23);
    }

    public void addSubscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
       for(Subscriber subscriber1: subscribers) {
           if(Objects.equals(subscriber.getId(), subscriber1.getId())) {
               subscribers.remove(subscriber1);
               return;
           }
       }
    }

    public void publish(Message message) {
        for (Subscriber subscriber: subscribers) {
            CompletableFuture.runAsync(() -> subscriber.displayPublishedMessage(message), executor);
        }
        executor.shutdown();
    }
}
