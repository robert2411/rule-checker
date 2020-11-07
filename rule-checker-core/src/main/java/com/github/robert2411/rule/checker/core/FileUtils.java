package com.github.robert2411.rule.checker.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.robert2411.rule.checker.core.models.RuleSet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class FileUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private FileUtils(){
    }

    public static RuleSet ruleSetFromFile(String filePath) {
//        String json = readFile(filePath);
        try {
            return OBJECT_MAPPER.readValue(new File(filePath), RuleSet.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

//    private static String readFile(String path)
//            throws IOException
//    {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, StandardCharsets.UTF_8);
//    }
}
