package org.example.StackOverflow.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.example.StackOverflow.View.NotificationService.userIdCreationNotification;
import static org.example.StackOverflow.View.NotificationService.userNotFoundAccountNotification;

public class AccountService {

    private static AccountService instance;
    private final Map<Integer, User> userData;

    public AccountService() {
        userData = new HashMap<>();
    }

    public static AccountService getInstance() {
        if(Objects.isNull(instance)) {
            instance = new AccountService();
        }
        return instance;
    }

    public void createAccount(String name, String profession) {
        User user = new User(name, profession);
        userData.put(user.getId(), user);
        userIdCreationNotification(user);
    }

    public User signIn(int userID) {
        if(userData.containsKey(userID)) {
            return userData.get(userID);
        }
        userNotFoundAccountNotification(userID);
        return null;
    }

}
