package com.github.robert2411.rule.checker.core.models;

import java.io.File;

public class ScanError {
    private final String rule;
    private final File file;
    private final int line;

    public ScanError(String rule, File file, int line) {
        this.rule = rule;
        this.file = file;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Error{" +
                "rule='" + rule + '\'' +
                ", file='" + file + '\'' +
                ", line=" + line +
                '}';
    }
}
