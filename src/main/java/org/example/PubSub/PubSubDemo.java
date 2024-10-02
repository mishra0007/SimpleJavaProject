package org.example.PubSub;

public class PubSubDemo {
    public static void main(String[] args) {
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();
        Topic topic1 = new Topic(publisher1);
        Topic topic2 = new Topic(publisher1);
        Topic topic3 = new Topic(publisher2);
        Topic topic4 = new Topic(publisher2);

        Subscriber subscriber1 = new Subscriber();
        Subscriber subscriber2 = new Subscriber();

        topic1.addSubscribe(subscriber1);
        topic1.addSubscribe(subscriber2);
        topic3.addSubscribe(subscriber2);
        topic4.addSubscribe(subscriber1);

        publisher1.publishMessage(new Message("Hey this is a message from publisher1 with publisherId"
                + publisher1.getId()));
        publisher2.publishMessage(new Message("Hey this is a message from publisher2 with publisherId"
                + publisher2.getId()));
    }
}
