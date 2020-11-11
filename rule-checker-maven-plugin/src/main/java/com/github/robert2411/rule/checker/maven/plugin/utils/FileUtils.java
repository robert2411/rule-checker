package com.github.robert2411.rule.checker.maven.plugin.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanConfig;
import com.github.robert2411.rule.checker.maven.plugin.models.MavenScanConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FileUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //To make sure that the project can handle rules for newer versions

    private FileUtils(){
    }

    public static ScanConfig scanConfigFromFile(String filePath) {
        try {
            File scanConfigFile = new File(filePath);
            String basePath = scanConfigFile.getParent();
            MavenScanConfig scanConfig = OBJECT_MAPPER.readValue(scanConfigFile, MavenScanConfig.class);
            List<RuleSet> ruleSets = scanConfig.getRuleSetPaths().stream().map(p -> ruleSetFromFile(basePath + "/" + p)).collect(Collectors.toList());
            return new ScanConfig(scanConfig.getName(), scanConfig.getDescription(), ruleSets);

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static RuleSet ruleSetFromFile(String filePath) {
        try {
            return OBJECT_MAPPER.readValue(new File(filePath), RuleSet.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
