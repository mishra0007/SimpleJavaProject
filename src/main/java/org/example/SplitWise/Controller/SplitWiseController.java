package org.example.SplitWise.Controller;

import org.example.SplitWise.Model.*;
import org.example.SplitWise.View.DisplayBalance;

import java.util.*;

public class SplitWiseController {

    User user1 = new User("U1", "U1", "email@gmai.com", 1234, new Wallet("U1"));
    User user2 = new User("U2", "U2", "email@gmai.com", 1234, new Wallet("U2"));
    User user3 = new User("U3", "U3", "email@gmai.com", 1234, new Wallet("U3"));
    User user4 = new User("U4", "U4", "email@gmai.com", 1234, new Wallet("U4"));
    Map<String, User> userMap = new HashMap<>();


    private final DisplayBalance displayBalance;
    private List<User> userListOfBorrower;

    public SplitWiseController() {
        userMap.put(user1.getUserID(), user1);
        userMap.put(user2.getUserID(), user2);
        userMap.put(user3.getUserID(), user3);
        userMap.put(user4.getUserID(), user4);
        displayBalance = new DisplayBalance();
    }

    public void splitWithPercentages(String whoLentMoney, List<String> whoBorrowedMoney, Double amount, List<Integer> percentages) {
        Split<Map<User, Integer>> split = new SplitWithPercentage(userMap.get(whoLentMoney));
        userListOfBorrower = new ArrayList<>();
        for (String borrowerID : whoBorrowedMoney) {
            User borrower = userMap.get(borrowerID);
            if (borrower != null) {
                userListOfBorrower.add(borrower);
            }
        }
        Map<User, Integer> userDetails = new HashMap<>();
        for(int i = 0; i<whoBorrowedMoney.size(); i++) {
            userDetails.put(userListOfBorrower.get(i), percentages.get(i));
        }
        split.splitBalance(userDetails, amount);
    }

    public void splitWithExact(String whoLentMoney, List<String> whoBorrowedMoney, Double amount, List<Double> exactAmount) {
        Split<Map<User, Double>> split = new SplitWithExact(userMap.get(whoLentMoney));
        userListOfBorrower = new ArrayList<>();
        for (String borrowerID : whoBorrowedMoney) {
            User borrower = userMap.get(borrowerID);
            if (borrower != null) {
                userListOfBorrower.add(borrower);
            }
        }
        Map<User, Double> userDetails = new HashMap<>();
        for(int i = 0; i<whoBorrowedMoney.size(); i++) {
            userDetails.put(userListOfBorrower.get(i), exactAmount.get(i));
        }
        split.splitBalance(userDetails, amount);
    }

    public void SplitWithEqual(String whoLentMoney, List<String> whoBorrowedMoney, Double amount) {
        Split<List<User>> split = new SplitWithEqual(userMap.get(whoLentMoney));
        userListOfBorrower = new ArrayList<>();
        for (String borrowerID : whoBorrowedMoney) {
            User borrower = userMap.get(borrowerID);
            if (borrower != null) {
                userListOfBorrower.add(borrower);
            }
        }
        split.splitBalance(userListOfBorrower, amount);
    }

    public void display(String userID) {
        displayBalance.displayBalanceForUser(userMap.get(userID));
    }

    public void displayAll() {
        displayBalance.displayAll(new ArrayList<>(userMap.values())); // Create a new ArrayList from the collection
    }
}
