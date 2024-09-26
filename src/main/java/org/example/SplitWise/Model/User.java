package org.example.SplitWise.Model;

import org.example.SplitWise.Constant.TransactionsEnum;

public class User {
    private String userID;
    private String userName;
    private String emailID;
    private long number;
    private Wallet wallet;

    public User(String userID, String userName, String emailID, long number, Wallet wallet) {
        this.userID = userID;
        this.userName = userName;
        this.emailID = emailID;
        this.number = number;
        this.wallet = wallet;
    }

    public String getUserID() {
        return userID;
    }

    public Wallet getWallet() {
        return wallet;
    }


}
