package org.example.SplitWise.Model;

import java.util.Map;

import static org.example.SplitWise.Constant.TransactionsEnum.CREDIT;
import static org.example.SplitWise.Constant.TransactionsEnum.DEBIT;

public class SplitWithPercentage implements Split<Map<User, Integer>> {
    private final User userWhoLentMoney;

    public SplitWithPercentage(User userWhoLentMoney) {
        this.userWhoLentMoney = userWhoLentMoney;
    }

    @Override
    public void splitBalance(Map<User, Integer> splitDetailsWithUserID, Double amount) {
        double totalPercentage = calculateTotalPercentage(splitDetailsWithUserID);

        if (totalPercentage != 100.0) {
            throw new IllegalArgumentException("Total percentage must equal 100 for splitting.");
        }
        distributeAmount(splitDetailsWithUserID, amount);
    }

    private double calculateTotalPercentage(Map<User, Integer> splitDetailsWithUserID) {
        return splitDetailsWithUserID.values().stream()
                .mapToDouble(Integer::doubleValue)
                .sum();
    }

    private void distributeAmount(Map<User, Integer> splitDetailsWithUserID, Double amount) {
        for (Map.Entry<User, Integer> entry : splitDetailsWithUserID.entrySet()) {
            User user = entry.getKey();
            int percentage = entry.getValue();
            double userShare = calculateUserShare(amount, percentage);

            updateBalances(user, userShare);
        }
    }

    private double calculateUserShare(Double amount, int percentage) {
        return amount * percentage / 100.0;  // Calculate user share based on the percentage
    }

    private void updateBalances(User user, double userShare) {
        userWhoLentMoney.getWallet().updateBalance(user.getUserID(), userShare, CREDIT);
        user.getWallet().updateBalance(userWhoLentMoney.getUserID(), userShare, DEBIT);
    }
}
