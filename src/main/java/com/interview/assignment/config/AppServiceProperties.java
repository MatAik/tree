package com.interview.assignment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
@EnableConfigurationProperties
@PropertySource("classpath:app.properties")
@ConfigurationProperties(prefix = "treedata")
public class AppServiceProperties {

    @NotBlank
    private String url;

    private int maxRadius;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
    }
}
