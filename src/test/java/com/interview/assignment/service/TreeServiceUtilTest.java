package com.interview.assignment.service;

import com.interview.assignment.data.CartesianPointJson;
import com.interview.assignment.integration.Tree;
import com.interview.assignment.util.Converter;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeServiceUtilTest {

    @Test
    public void sortToTreesWithinRadiusCorrectPick() {

        final int radiusInMeters = 5;

        final List<Tree> trees = new ArrayList<>();

        trees.add(new Tree("treeBarelyInVertical", Converter.metersToFeet(radiusInMeters), BigDecimal.ZERO));
        trees.add(new Tree("treeBarelyOutVertical", Converter.metersToFeet(radiusInMeters).add(new BigDecimal("0.000001")), BigDecimal.ZERO));
        trees.add(new Tree("treeBarelyInHorizontal", BigDecimal.ZERO, Converter.metersToFeet(radiusInMeters)));
        trees.add(new Tree("treeBarelyOutHorizontal", BigDecimal.ZERO, Converter.metersToFeet(radiusInMeters).add(new BigDecimal("0.000001"))));
        trees.add(new Tree("treeAtCenter", BigDecimal.ZERO, BigDecimal.ZERO));
        trees.add(new Tree("treeCloseBy", BigDecimal.ONE, BigDecimal.ONE));
        trees.add(new Tree("treeWayOut", new BigDecimal("4000"), new BigDecimal("3000")));
        trees.add(new Tree("treeOutInCorner", Converter.metersToFeet(radiusInMeters), Converter.metersToFeet(radiusInMeters)));
        trees.add(new Tree("treeOnTheCircle", Converter.metersToFeet(4), Converter.metersToFeet(3)));
        trees.add(new Tree("treeJustOutsideTheCircle", Converter.metersToFeet(4).add(new BigDecimal("0.00000001")), Converter.metersToFeet(3)));

        final CartesianPointJson cartesianPointJson = new CartesianPointJson(BigDecimal.ZERO, BigDecimal.ZERO);

        HashMap<String, Integer> treesWithin = TreeServiceUtil.sortToTreesWithinRadius(cartesianPointJson, radiusInMeters, trees);

        Assert.assertTrue(treesWithin.containsKey("treeBarelyInVertical"));
        Assert.assertTrue(treesWithin.containsKey("treeBarelyInHorizontal"));
        Assert.assertTrue(treesWithin.containsKey("treeAtCenter"));
        Assert.assertTrue(treesWithin.containsKey("treeCloseBy"));
        Assert.assertTrue(treesWithin.containsKey("treeOnTheCircle"));

        Assert.assertFalse(treesWithin.containsKey("treeBarelyOutVertical"));
        Assert.assertFalse(treesWithin.containsKey("treeBarelyOutHorizontal"));
        Assert.assertFalse(treesWithin.containsKey("treeOutInCorner"));
        Assert.assertFalse(treesWithin.containsKey("treeWayOut"));
        Assert.assertFalse(treesWithin.containsKey("treeJustOutsideTheCircle"));

        Assert.assertEquals(5, treesWithin.size());
    }

    @Test
    public void sortToTreesWithinRadiusCorrectCount() {

        final int radiusInMeters = 5;

        final List<Tree> trees = new ArrayList<>();

        trees.add(new Tree("tree1", Converter.metersToFeet(radiusInMeters), BigDecimal.ZERO));
        trees.add(new Tree("tree1", Converter.metersToFeet(radiusInMeters).subtract(new BigDecimal("0.000001")), BigDecimal.ZERO));
        trees.add(new Tree("tree2", BigDecimal.ZERO, Converter.metersToFeet(radiusInMeters)));
        trees.add(new Tree("tree2", BigDecimal.ZERO, Converter.metersToFeet(radiusInMeters).subtract(new BigDecimal("0.000001"))));
        trees.add(new Tree("tree2", BigDecimal.ZERO, BigDecimal.ZERO));
        trees.add(new Tree("tree3", BigDecimal.ONE, BigDecimal.ONE));
        trees.add(new Tree("tree4", new BigDecimal("0"), new BigDecimal("0")));
        trees.add(new Tree("tree2", Converter.metersToFeet(1), Converter.metersToFeet(1)));
        trees.add(new Tree("tree6", Converter.metersToFeet(0), Converter.metersToFeet(1)));

        // below is out
        trees.add(new Tree("tree3", Converter.metersToFeet(4).add(new BigDecimal("0.00000001")), Converter.metersToFeet(3)));

        final CartesianPointJson cartesianPointJson = new CartesianPointJson(BigDecimal.ZERO, BigDecimal.ZERO);

        HashMap<String, Integer> treesWithin = TreeServiceUtil.sortToTreesWithinRadius(cartesianPointJson, radiusInMeters, trees);

        Assert.assertEquals(2, treesWithin.get("tree1").intValue());
        Assert.assertEquals(4, treesWithin.get("tree2").intValue());
        Assert.assertEquals(1, treesWithin.get("tree3").intValue());
        Assert.assertEquals(1, treesWithin.get("tree4").intValue());
        Assert.assertEquals(1, treesWithin.get("tree6").intValue());

        Assert.assertEquals(5, treesWithin.size());
    }
}