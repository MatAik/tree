package com.interview.assignment.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculatorTest {


    @Test
    public void calculateDistance() {
        Assert.assertEquals(new BigDecimal(5), Calculator.calculateDistance(BigDecimal.ZERO, BigDecimal.ZERO , new BigDecimal(4),new BigDecimal(3)));
        Assert.assertEquals(BigDecimal.ZERO, Calculator.calculateDistance(BigDecimal.ZERO, BigDecimal.ZERO , BigDecimal.ZERO,BigDecimal.ZERO));
    }
}