package com.interview.assignment.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class CartesianPointJson {

    @JsonCreator
    public CartesianPointJson(
            @JsonProperty("x")
            @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) BigDecimal x,
            @JsonProperty("y")
            @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT) BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    private BigDecimal x;

    private BigDecimal y;

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }
}
