package com.interview.assignment.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void feetToMeters() {

        assertEquals(0, BigDecimal.ONE.compareTo(Converter.feetToMeters(new BigDecimal("3.2808398950131233595800524934383"))));
        assertEquals(0, new BigDecimal("-1").compareTo(Converter.feetToMeters(new BigDecimal("-3.2808398950131233595800524934383"))));

        assertEquals(0, BigDecimal.ZERO.compareTo(Converter.feetToMeters(BigDecimal.ZERO)));
        assertEquals(0, BigDecimal.TEN.compareTo(Converter.feetToMeters(new BigDecimal("32.808398950131233595800524934383"))));

    }

    @Test
    public void feetToMetersLong() {

        assertEquals(0, BigDecimal.ZERO.compareTo(Converter.feetToMeters(0)));
        assertEquals(0, new BigDecimal("0.3048").compareTo(Converter.feetToMeters(1)));

    }

    @Test
    public void metersToFeet() {

        assertEquals(0, BigDecimal.ZERO.compareTo(Converter.metersToFeet(new BigDecimal("0"))));
        assertEquals(0, new BigDecimal("1").compareTo(Converter.metersToFeet(new BigDecimal("0.3048"))));
        assertEquals(0, BigDecimal.TEN.compareTo(Converter.metersToFeet(new BigDecimal("3.0480"))));
        assertEquals(0, new BigDecimal("-1").compareTo(Converter.metersToFeet(new BigDecimal("-0.3048"))));

    }

    @Test
    public void metersToFeetLong() {

        assertEquals(0, BigDecimal.ZERO.compareTo(Converter.metersToFeet(new BigDecimal("0"))));
        assertEquals(0, new BigDecimal("3.2808398950").compareTo(Converter.metersToFeet(1)));
        assertEquals(0, new BigDecimal("32.8083989501").compareTo(Converter.metersToFeet(10)));
        assertEquals(0, new BigDecimal("-3.2808398950").compareTo(Converter.metersToFeet(-1)));

    }
}