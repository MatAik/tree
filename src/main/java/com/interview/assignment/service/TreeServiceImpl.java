package com.interview.assignment.service;

import com.google.gson.Gson;
import com.interview.assignment.data.CartesianPointJson;
import com.interview.assignment.integration.Tree;
import com.interview.assignment.integration.TreeDataHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class TreeServiceImpl implements TreeService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final TreeDataHandler treeDataHandler;

    @Autowired
    public TreeServiceImpl(TreeDataHandler treeDataHandler) {
        this.treeDataHandler = treeDataHandler;
    }

    @Override
    public String fetchTreeData(final CartesianPointJson point, final long radiusInMeters) throws Exception {
        final List<Tree> allTrees = treeDataHandler.fetchTrees(point.getX(), point.getY(), radiusInMeters);

        final HashMap<String, Integer> treeCounter = TreeServiceUtil.sortToTreesWithinRadius(point, radiusInMeters, allTrees);

        // remove any unknown trees
        treeCounter.remove(null);

        log.info("returning data containing info on " + treeCounter.size() + " tree types and " +
                treeCounter.values().stream().mapToInt(Integer::intValue).sum() + " trees");

        return new Gson().toJson(treeCounter);
    }

}
