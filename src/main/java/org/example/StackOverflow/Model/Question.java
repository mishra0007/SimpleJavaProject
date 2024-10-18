package org.example.StackOverflow.Model;

import lombok.Getter;
import lombok.NonNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
public class Question {
    private final String id;
    private String questionDescription;
    private List<Answer> answers;
    private List<TopicName> topicNames;
    private final User user;
    private final Date timestamp;

    public Question(String questionDescription, User user, List<TopicName> topicNames) {
        if(topicNames.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        this.questionDescription = questionDescription;
        this.topicNames = topicNames;
        this.user = user;
        id = UUID.randomUUID().toString().substring(0, 15);
        answers = new ArrayList<>();
        timestamp = Date.from(Instant.ofEpochMilli(System.currentTimeMillis()));
    }

    public void setAnswers(Answer answer) {
        this.answers.add(answer);
    }

    public void setTopicList(TopicName topic) {
        this.topicNames.add(topic);
    }
}
