package org.example.StackOverflow.Model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final TopicName topicName;
    private List<Question> questions;

    public Topic(TopicName topicName) {
        this.topicName = topicName;
        questions = new ArrayList<>();
    }

    public TopicName getTopicName() {
        return topicName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestion(Question question) {
        questions.add(question);
    }
}
