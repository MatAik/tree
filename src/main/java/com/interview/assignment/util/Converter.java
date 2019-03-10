package com.interview.assignment.util;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

    final private static BigDecimal A_FOOT_IN_METERS = new BigDecimal("0.3048");

    public static BigDecimal feetToMeters(final long feet){
        return feetToMeters(new BigDecimal(feet));
    }

    public static BigDecimal metersToFeet(final long meters){
        return metersToFeet(new BigDecimal("" + meters));
    }

    public static BigDecimal feetToMeters(final BigDecimal feet){
        return feet.multiply(A_FOOT_IN_METERS).setScale(10, RoundingMode.HALF_UP);
    }

    public static BigDecimal metersToFeet(final BigDecimal meters){
        return meters.divide(A_FOOT_IN_METERS, 10,RoundingMode.HALF_UP);
    }
}
