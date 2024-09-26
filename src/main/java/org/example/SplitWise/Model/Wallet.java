package org.example.SplitWise.Model;

import org.example.SplitWise.Constant.TransactionsEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Wallet {
    private Double balance;
    private final Map<String, Double> balanceDetails;
    private final String user;

    public Wallet(String userID) {
        balance = 0.0;
        balanceDetails = new HashMap<>();
        user = userID;
    }

    public Double getBalance() {
        return balance;
    }

    public Map<String, Double> getBalanceDetails() {
        return balanceDetails;
    }

    public void updateBalance(String userID, Double amount, TransactionsEnum transactionsType) {
        if(Objects.equals(user, userID)) return;
        switch (transactionsType) {
            case DEBIT -> {
                balance -= amount;
                balanceDetails.put(userID, balanceDetails.getOrDefault(userID, 0.0)-amount);
            }
            case CREDIT -> {
                balance += amount;
                balanceDetails.put(userID, balanceDetails.getOrDefault(userID, 0.0)+amount);
            }
            default -> throw new RuntimeException(String.format("%s: TransactionsEnum is INVALID", transactionsType));
        }
    }

}
