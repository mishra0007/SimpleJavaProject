package org.example.SplitWise.Constant;

public class HelperMethod {

    public static Double getAmountToTwoDecimalPlace(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
