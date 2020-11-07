package com.github.robert2411.rule.checker.core.models;

import java.util.regex.Pattern;

public class RuleSet {
    private final String author;
    private final String version;
    private final String name;
    private final String description;
    private final Rule[] rules;
    private final String language;
    private final String fileRegex;
    private final Pattern pattern;
    public RuleSet(String author, String version, String name, String description, Rule[] rules, String language, String fileRegex) {
        this.author = author;
        this.version = version;
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.language = language;
        this.fileRegex = fileRegex;
        this.pattern = Pattern.compile(fileRegex);
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Rule[] getRules() {
        return rules;
    }

    public String getLanguage() {
        return language;
    }

    public String getFileRegex() {
        return fileRegex;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
