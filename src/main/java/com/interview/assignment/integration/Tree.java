package com.interview.assignment.integration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tree {

    private String name;

    private BigDecimal x;

    private BigDecimal y;

    public Tree(@JsonProperty("spc_common")
                @JsonFormat(shape = JsonFormat.Shape.STRING) String name,
                @JsonProperty("x_sp")
                @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) BigDecimal x,
                @JsonProperty("y_sp")
                @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) BigDecimal y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }
}
