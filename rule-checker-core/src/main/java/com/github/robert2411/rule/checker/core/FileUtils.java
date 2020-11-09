package com.github.robert2411.rule.checker.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.robert2411.rule.checker.core.models.RuleSet;

import java.io.File;
import java.io.IOException;

public abstract class FileUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //To make sure that the project can handle rules for newer versions

    private FileUtils(){
    }

    public static RuleSet ruleSetFromFile(String filePath) {
        try {
            return OBJECT_MAPPER.readValue(new File(filePath), RuleSet.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
