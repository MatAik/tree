package com.interview.assignment.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.assignment.integration.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class TreeJsonParser {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public List<Tree> convertToTrees(InputStream content) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(content));

        final ObjectMapper mapper = new ObjectMapper();

        final List<Tree> trees = mapper.readValue(in, new TypeReference<List<Tree>>() {});

        log.info("service returned " + trees.size() + " trees");

        return trees;
    }

}
