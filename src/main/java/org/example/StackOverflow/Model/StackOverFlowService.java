package org.example.StackOverflow.Model;

import lombok.Getter;

import javax.management.AttributeNotFoundException;
import java.util.*;

import static org.example.StackOverflow.View.NotificationService.*;

@Getter
public class StackOverFlowService {

    private static StackOverFlowService instance;
    private final List<Question> questions;
    private final Map<TopicName, List<Integer>> topicNameListMap;
    private final List<Topic> topicList;

    private StackOverFlowService() {
        questions = new ArrayList<>();
        topicNameListMap = new HashMap<>();
        topicList = new ArrayList<>();
    }

    public static StackOverFlowService getInstance() {
        if(Objects.isNull(instance)) {
            instance = new StackOverFlowService();
        }
        return instance;
    }

    public void postQuestion(Question question) {
        questions.add(question);
        for (Topic topic: topicList) {
            if(question.getTopicNames().contains(topic.getTopicName())) {
                topic.setQuestion(question);
            }
        }
        questionPostedNotification(question);
    }

    public void postAnswer(Question question, Answer answer) {
        for (TopicName topicNames: question.getTopicNames()) {
            List<Integer> userList = topicNameListMap.getOrDefault(topicNames, new ArrayList<>());
            if(userList.contains(question.getUser().getId())) {
                question.setAnswers(answer);
                answerPostedSuccessfully(question, answer);
                return;
            }
        }
        System.out.println("You are are Not subscribed to any of the question topic");
    }

    public void subscribeTopic(TopicName topicName, int userId) {
        if (!topicNameListMap.containsKey(topicName)) {
            topicNameListMap.put(topicName, new ArrayList<>());
        }
        topicNameListMap.get(topicName).add(userId);
        subscriptionNotification(topicName);
    }

    public void unSubscribeTopic(TopicName topicName, int userId) throws AttributeNotFoundException {
        if (topicNameListMap.containsKey(topicName)) {
            if(topicNameListMap.get(topicName).contains(userId)) {
                topicNameListMap.get(topicName).remove(userId);
                unSubscriptionNotification(topicName);
                return;
            }
            notSubscriptionNotification(topicName);
        }
        throw new AttributeNotFoundException("Topic Name provided doesn't exist");
    }



}
