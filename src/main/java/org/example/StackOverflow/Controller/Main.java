package org.example.StackOverflow.Controller;

import org.example.StackOverflow.Model.*;

import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        StackOverFlowService stackOverFlowService = StackOverFlowService.getInstance();
        AccountService accountService = AccountService.getInstance();
        accountService.createAccount("Abhishek Mishra", "Software Developer");
        User user = accountService.signIn(1);
        stackOverFlowService.subscribeTopic(TopicName.JAVA, user.getId());
        Question question = new Question("This is a Question", user, Collections.singletonList(TopicName.JAVA));
        stackOverFlowService.postQuestion(question);
        Answer answer = new Answer("This is an Answer", user);
        stackOverFlowService.postAnswer(question, answer);
    }
}
