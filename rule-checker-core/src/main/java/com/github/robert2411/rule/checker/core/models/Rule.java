package com.github.robert2411.rule.checker.core.models;

import java.util.regex.Pattern;

public class Rule {
    private final String name;
    private final String description;
    private final String regex;
    private final Pattern pattern;

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
}
