package com.interview.assignment.controller;

import com.interview.assignment.data.CartesianPointJson;

import java.util.ArrayList;
import java.util.List;

class TreeControllerValidator {

    static void validateParameters(int radiusInMeters, CartesianPointJson mappedPoint, int maxRadius) {
        final List<String> invalidArguments = new ArrayList<>();

        if (radiusInMeters < 0) {
            invalidArguments.add("Given radius is too small");
        }

        if (radiusInMeters > maxRadius){
            invalidArguments.add("Given radius is too big");
        }

        if (mappedPoint.getX() == null) {
            invalidArguments.add("Point X is missing");
        }

        if (mappedPoint.getY() == null) {
            invalidArguments.add("Point Y is missing");
        }

        if (!invalidArguments.isEmpty()) {
            throw new IllegalArgumentException(invalidArguments.toString());
        }
    }
}
