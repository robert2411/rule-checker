package com.github.robert2411.rule.checker.core.models;

import java.util.List;
import java.util.regex.Pattern;

public class RuleSet {
    private String name;
    private String description;
    private List<Rule> rules;

    public RuleSet(){

    }

    public RuleSet(String name, String description, List<Rule> rules) {
        this.name = name;
        this.description = description;
        this.rules = rules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
