package com.interview.assignment.service;

import com.interview.assignment.data.CartesianPointJson;

public interface TreeService {

    String fetchTreeData(CartesianPointJson point, long radiusInMeters) throws Exception;
}
