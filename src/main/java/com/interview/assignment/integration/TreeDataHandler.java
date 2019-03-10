package com.interview.assignment.integration;

import com.interview.assignment.config.AppServiceProperties;
import com.interview.assignment.util.Converter;
import com.interview.assignment.util.TreeJsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class TreeDataHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TreeJsonParser treeJsonParser;

    private AppServiceProperties appServiceProperties;

    @Autowired
    public void setTreeJsonParser(TreeJsonParser treeJsonParser) {
        this.treeJsonParser = treeJsonParser;
    }

    @Autowired
    public void setAppServiceProperties(AppServiceProperties appServiceProperties) {
        this.appServiceProperties = appServiceProperties;
    }

    public List<Tree> fetchTrees(final BigDecimal x, final BigDecimal y, final long radiusInMeters) throws Exception{

        try {
            final BigDecimal maxX = x.add(Converter.metersToFeet(radiusInMeters));
            final BigDecimal minX = x.subtract(Converter.metersToFeet(radiusInMeters));

            final BigDecimal maxY = y.add(Converter.metersToFeet(radiusInMeters));
            final BigDecimal minY = y.subtract(Converter.metersToFeet(radiusInMeters));

            final int maxTrees = 50000;
            // Let's limit the found trees to a rectangle shape area to avoid excess handling
            final String clause = "?$limit=" + maxTrees + "&$where=x_sp%20>=%20" + minX + "%20AND%20" +
                    "x_sp%20<=%20" + maxX + "%20AND%20" +
                    "y_sp%20>=%20" + minY + "%20AND%20" +
                    "y_sp%20<=%20" + maxY;

            URL url = new URL(appServiceProperties.getUrl() + clause);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();

            List<Tree> trees = treeJsonParser.convertToTrees(content);

            if (trees.size() == maxTrees) {
                log.warn("Max number (" + maxTrees + ") of trees found, results are inaccurate. Returning error.");
                throw new Exception("Too many results, cannot give proper result");
            }

            return trees;

        } catch (IOException e) {
            log.warn("Failed to fetch trees from external service ", e);
            throw new Exception("Internal error");
        }
    }
}
