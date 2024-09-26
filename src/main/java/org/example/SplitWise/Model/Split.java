package org.example.SplitWise.Model;


public interface Split<T> {
    void splitBalance(T splitDetailsWithUserID, Double amount);
}
