package com.github.robert2411.rule.checker.core.models;

import java.util.List;

public class ScanConfig {
    private String name;
    private String description;
    private List<RuleSet> ruleSets;

    public ScanConfig(){}
    public ScanConfig(String name, String description, List<RuleSet> ruleSets) {
        this.name = name;
        this.description = description;
        this.ruleSets = ruleSets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuleSets(List<RuleSet> ruleSets) {
        this.ruleSets = ruleSets;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<RuleSet> getRuleSets() {
        return ruleSets;
    }
}