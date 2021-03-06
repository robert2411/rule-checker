package com.github.robert2411.rule.checker.maven.plugin.models;

import java.util.List;

public class MavenScanConfig {
    private String name;
    private String description;
    private List<String> ruleSetPaths;

    public MavenScanConfig(){}
    public MavenScanConfig(String name, String description, List<String> ruleSetPaths) {
        this.name = name;
        this.description = description;
        this.ruleSetPaths = ruleSetPaths;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuleSetPaths(List<String> ruleSetPaths) {
        this.ruleSetPaths = ruleSetPaths;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRuleSetPaths() {
        return ruleSetPaths;
    }
}