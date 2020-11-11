package com.github.robert2411.rule.checker.core.models;

import java.io.File;

public class ScanError {
    private final Rule rule;
    private final File file;
    private final int lineNumber;
    private final String line;

    public ScanError(Rule rule, File file, int lineNumber, String line) {
        this.rule = rule;
        this.file = file;
        this.lineNumber = lineNumber;
        this.line = line;
    }

    @Override
    public String toString() {
        return "ScanError{" +
                "rule=" + rule +
                ", file=" + file.getName() +
                ", lineNumber=" + lineNumber +
                ", line='" + line + '\'' +
                '}';
    }
}
