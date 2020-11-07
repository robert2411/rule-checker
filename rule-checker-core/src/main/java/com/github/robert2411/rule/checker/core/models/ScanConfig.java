package com.github.robert2411.rule.checker.core.models;

public class ScanConfig {
    private final String name;
    private final String description;
    private final RuleSet[] ruleSets;

    public ScanConfig(String name, String description, RuleSet[] ruleSets) {
        this.name = name;
        this.description = description;
        this.ruleSets = ruleSets;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RuleSet[] getRuleSets() {
        return ruleSets;
    }
}