package org.example.SplitWise.Model;

import java.util.Map;

import static org.example.SplitWise.Constant.TransactionsEnum.CREDIT;
import static org.example.SplitWise.Constant.TransactionsEnum.DEBIT;

public class SplitWithExact implements Split<Map<User, Double>> {

    private final User userWhoLentMoney;

    public SplitWithExact(User userWhoLentMoney) {
        this.userWhoLentMoney = userWhoLentMoney;
    }

    @Override
    public void splitBalance(Map<User, Double> splitDetailsWithUserID, Double amount) {
        double sum = 0;
        for (Map.Entry<User, Double> details: splitDetailsWithUserID.entrySet()) {
            sum += details.getValue();
        }

        if(sum == amount) {
            for (Map.Entry<User, Double> details: splitDetailsWithUserID.entrySet()) {
                userWhoLentMoney.getWallet().updateBalance(details.getKey().getUserID(), details.getValue(), CREDIT);
                details.getKey().getWallet().updateBalance(userWhoLentMoney.getUserID(), details.getValue(), DEBIT);
            }
        } else {
            throw new IllegalArgumentException("Total sum must equal to amount for splitting.");
        }
    }
}
