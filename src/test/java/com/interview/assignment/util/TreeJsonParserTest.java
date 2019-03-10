package com.interview.assignment.util;

import com.interview.assignment.integration.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class TreeJsonParserTest {

    @Test
    public void convertToTrees() throws IOException {
        TreeJsonParser treeJsonParser = new TreeJsonParser();

        final InputStream in = ClassLoader.getSystemResourceAsStream("json/treedata.json");
        List<Tree> trees = treeJsonParser.convertToTrees(in);

        Assert.assertEquals(1000, trees.size());

        Assert.assertEquals("red maple", trees.get(0).getName());
        Assert.assertEquals(new BigDecimal("1027431.148"), trees.get(0).getX());
        Assert.assertEquals(new BigDecimal("202756.7687"), trees.get(0).getY());
    }
}