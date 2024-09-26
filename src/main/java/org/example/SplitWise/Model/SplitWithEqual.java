package org.example.SplitWise.Model;

import java.util.List;
import java.util.Objects;

import static org.example.SplitWise.Constant.HelperMethod.getAmountToTwoDecimalPlace;
import static org.example.SplitWise.Constant.TransactionsEnum.CREDIT;
import static org.example.SplitWise.Constant.TransactionsEnum.DEBIT;

public class SplitWithEqual implements Split<List<User>> {

    private final User userWhoLentMoney;

    public SplitWithEqual(User userWhoLentMoney) {
        this.userWhoLentMoney = userWhoLentMoney;
    }

    @Override
    public void splitBalance(List<User> splitDetailsWithUserID, Double amount) {
        amount = getAmountToTwoDecimalPlace(amount);
        int splitWithNumberOfUser = splitDetailsWithUserID.size();
        double individualContribution = amount/splitWithNumberOfUser;
        double leftOverAmount = amount%splitWithNumberOfUser;
        for (User user: splitDetailsWithUserID) {
            user.getWallet().updateBalance(userWhoLentMoney.getUserID(), individualContribution, DEBIT);
            userWhoLentMoney.getWallet().updateBalance(user.getUserID(), individualContribution, CREDIT);
        }
        // Extra balance will be added to first person
        splitDetailsWithUserID.get(0).getWallet().updateBalance(userWhoLentMoney.getUserID(), leftOverAmount, DEBIT);
        userWhoLentMoney.getWallet().updateBalance( splitDetailsWithUserID.get(0).getUserID(), individualContribution, CREDIT);
    }
}
