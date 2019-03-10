package com.interview.assignment.service;

import com.interview.assignment.data.CartesianPointJson;
import com.interview.assignment.integration.Tree;
import com.interview.assignment.util.Calculator;
import com.interview.assignment.util.Converter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

class TreeServiceUtil {

    static HashMap<String, Integer> sortToTreesWithinRadius(final CartesianPointJson point, final long radiusInMeters, final List<Tree> allTrees) {
        final HashMap<String, Integer> treeCounter = new HashMap<>();

        final BigDecimal bigDecimalRadius = new BigDecimal(radiusInMeters);

        for (Tree allTree : allTrees) {
            final BigDecimal distanceFromCenter = Converter.feetToMeters(
                    Calculator.calculateDistance(point.getX(), point.getY(), allTree.getX(), allTree.getY()));

            if (distanceFromCenter.compareTo(bigDecimalRadius) <= 0) {
                if (treeCounter.containsKey(allTree.getName())) {
                    treeCounter.replace(allTree.getName(), treeCounter.get(allTree.getName()) + 1);
                } else {
                    treeCounter.put(allTree.getName(), 1);
                }
            }
        }

        return treeCounter;
    }
}
