package org.example.StackOverflow.View;

import org.example.StackOverflow.Model.Answer;
import org.example.StackOverflow.Model.Question;
import org.example.StackOverflow.Model.TopicName;
import org.example.StackOverflow.Model.User;

public class NotificationService {

    public static void userIdCreationNotification(User user) {
        System.out.printf("User: %s account is created with UserID %s %n", user.getName(), user.getId());
    }

    public static void userNotFoundAccountNotification(int userId) {
        System.out.printf("Userid: %s doesn't exist. Please create new account. %n", userId);
    }

    public static void questionPostedNotification(Question question) {
        System.out.println("Your Question was posted Successfully: " +  question);
    }

    public static void answerPostedSuccessfully(Question question, Answer answer) {
        System.out.print("Your Answer was posted Successfully: " +  answer);
        System.out.println(" For Question: " + question);
    }


    public static void subscriptionNotification(TopicName topicName) {
        System.out.println("You are subscribed to the topic: " + topicName);
    }

    public static void unSubscriptionNotification(TopicName topicName) {
        System.out.println("You are unSubscribed to the topic: " + topicName);
    }

    public static void notSubscriptionNotification(TopicName topicName) {
        System.out.println("You are not subscribed to the topic: " + topicName);
    }

}
