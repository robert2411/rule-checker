package com.github.robert2411.rule.checker.core.models;

import java.util.regex.Pattern;

public class Rule {
    private String name;
    private String description;
    private String regex;
    private Pattern pattern;

    public Rule() {
    }
    public Rule(String name, String description, String regex) {
        this.name = name;
        this.description = description;
        this.regex = regex;
        pattern = Pattern.compile(regex);
    }
    public Rule(String name, Rule rule) {
        this.name = name;
        this.description = rule.getDescription();
        this.regex = rule.getRegex();
        this.pattern = rule.getPattern();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRegex() {
        return regex;
    }

    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
