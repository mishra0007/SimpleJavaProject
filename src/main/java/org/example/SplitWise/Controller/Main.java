package org.example.SplitWise.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SplitWiseController controller = new SplitWiseController();

        // Hardcoded commands simulating user input
        String[] commands = {
                "SHOW",
                "SHOW U1",
                "EXPENSE U1 1000 4 U1 U2 U3 U4 EQUAL",
                "SHOW U4",
                "SHOW U1",
                "EXPENSE U1 1250 2 U2 U3 EXACT 370 880",
                "SHOW",
                "EXPENSE U4 1200 4 U1 U2 U3 U4 PERCENT 40 20 20 20",
                "SHOW U1",
                "SHOW"
        };

        for (String command : commands) {
            System.out.println("Executing command: " + command);
            if (command.equals("SHOW")) {
                controller.displayAll();
            } else if (command.startsWith("SHOW ")) {
                String userId = command.split(" ")[1];
                controller.display(userId);
            } else if (command.startsWith("EXPENSE ")) {
                String[] parts = command.split(" ");
                String whoLentMoney = parts[1];
                Double amount = Double.parseDouble(parts[2]);
                int noOfUsers = Integer.parseInt(parts[3]);
                List<String> whoBorrowedMoney = Arrays.asList(Arrays.copyOfRange(parts, 4, 4 + noOfUsers));
                String splitTypeStr = parts[4 + noOfUsers];

                switch (splitTypeStr) {
                    case "EQUAL" -> controller.SplitWithEqual(whoLentMoney, whoBorrowedMoney, amount);
                    case "EXACT" -> {
                        List<Double> exactAmounts = new ArrayList<>();
                        for (int i = 0; i < noOfUsers; i++) {
                            exactAmounts.add(Double.parseDouble(parts[5 + noOfUsers + i]));
                        }
                        controller.splitWithExact(whoLentMoney, whoBorrowedMoney, amount, exactAmounts);
                    }
                    case "PERCENT" -> {
                        List<Integer> percentages = new ArrayList<>();
                        for (int i = 0; i < noOfUsers; i++) {
                            percentages.add(Integer.parseInt(parts[5 + noOfUsers + i]));
                        }
                        controller.splitWithPercentages(whoLentMoney, whoBorrowedMoney, amount, percentages);
                    }
                }
            }
        }
    }
}
