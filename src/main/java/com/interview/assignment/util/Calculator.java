package com.interview.assignment.util;


import java.math.BigDecimal;

public class Calculator {

    public static BigDecimal calculateDistance(final BigDecimal firstX, final BigDecimal firstY, final BigDecimal secondX, final BigDecimal secondY) {
        final BigDecimal vertical = firstY.compareTo(secondY) > 0 ? firstY.subtract(secondY) : secondY.subtract(firstY);
        final BigDecimal horizontal = firstX.compareTo(secondX) > 0 ? firstX.subtract(secondX) : secondX.subtract(firstX);

        return new BigDecimal(Math.sqrt(vertical.pow(2).add(horizontal.pow(2)).doubleValue()));
    }
}
