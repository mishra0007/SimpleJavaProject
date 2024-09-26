package org.example.SplitWise.View;

import org.example.SplitWise.Model.User;
import org.example.SplitWise.Model.Wallet;

import java.util.List;
import java.util.Map;

public class DisplayBalance {

    public void displayBalanceForUser(User user) {
        Wallet wallet = user.getWallet();
        System.out.printf("Total OutStanding Balance for User %s is %.2f.%n", user.getUserID(), wallet.getBalance());

        for (Map.Entry<String, Double> balanceDetails: wallet.getBalanceDetails().entrySet()) {
            if(balanceDetails.getValue() > 0) {
                System.out.printf("%s Owe %.2f amount to %s%n",
                        balanceDetails.getKey(), balanceDetails.getValue(), user.getUserID());
            } else if (balanceDetails.getValue() < 0) {
                System.out.printf("%s Owe %.2f amount to %s%n",
                        user.getUserID(), balanceDetails.getValue(), balanceDetails.getKey());
            }

        }

    }

    public void displayAll(List<User> userList) {
        for (User user: userList) {
            displayBalanceForUser(user);
        }
    }

}
