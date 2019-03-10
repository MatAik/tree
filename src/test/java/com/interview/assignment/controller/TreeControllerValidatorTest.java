package com.interview.assignment.controller;

import com.interview.assignment.data.CartesianPointJson;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TreeControllerValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersAllWrong() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(null, null);
        try {
            TreeControllerValidator.validateParameters(-1, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Given radius is too small, Point X is missing, Point Y is missing]", e.getMessage());
            throw e;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersRadiusTooSmall() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(new BigDecimal("1"), new BigDecimal("1"));
        try {
            TreeControllerValidator.validateParameters(-1, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Given radius is too small]", e.getMessage());
            throw e;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersRadiusTooBig() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(new BigDecimal("1"), new BigDecimal("1"));
        try {
            TreeControllerValidator.validateParameters(2001, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Given radius is too big]", e.getMessage());
            throw e;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersPointAllWrong() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(null, null);
        try {
            TreeControllerValidator.validateParameters(1, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Point X is missing, Point Y is missing]", e.getMessage());
            throw e;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersPointYWrong() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(new BigDecimal("1"), null);
        try {
            TreeControllerValidator.validateParameters(1, cartesianPointJson,2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Point Y is missing]", e.getMessage());
            throw e;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateParametersPointXWrong() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(null, new BigDecimal("1"));
        try {
            TreeControllerValidator.validateParameters(1, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("[Point X is missing]", e.getMessage());
            throw e;
        }

    }

    @Test
    public void validateParametersAllGood() {

        CartesianPointJson cartesianPointJson = new CartesianPointJson(new BigDecimal("1"), new BigDecimal("1"));
        try {
            TreeControllerValidator.validateParameters(1, cartesianPointJson, 2000);
        } catch (IllegalArgumentException e){
            throw e;
        }

    }
}