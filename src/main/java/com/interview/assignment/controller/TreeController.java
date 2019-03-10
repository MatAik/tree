package com.interview.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.assignment.config.AppServiceProperties;
import com.interview.assignment.data.CartesianPointJson;
import com.interview.assignment.service.TreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tree")
public class TreeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private AppServiceProperties appServiceProperties;

    private final TreeService treeService;

    @Autowired
    public void setAppServiceProperties(AppServiceProperties appServiceProperties) {
        this.appServiceProperties = appServiceProperties;
    }

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping(value = "/treedata", produces = "application/json")
    public @ResponseBody
    String getTreeData(@RequestParam(value = "point") String point,
                           @RequestParam(value = "radius") int radiusInMeters) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        CartesianPointJson mappedPoint = mapper.readValue(point, CartesianPointJson.class);

        log.info("requesting tree data for point (x = " + mappedPoint.getX() +
                " y = " + mappedPoint.getY() + ") and radius " + radiusInMeters + " meters");

        TreeControllerValidator.validateParameters(radiusInMeters, mappedPoint, appServiceProperties.getMaxRadius());

        return treeService.fetchTreeData(mappedPoint, radiusInMeters);
    }
}
