package com.github.robert2411.rule.checker.core;

import com.github.robert2411.rule.checker.core.models.Rule;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanConfig;
import com.github.robert2411.rule.checker.core.models.ScanError;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RuleChecker {
    public void check(String sourceDir, ScanConfig scanConfig){
        // build a list with rules rename the rules to scanconfig_name::ruleset_name::rule_name
        List<Rule> rules = new ArrayList<>();
        String scanConfigName = scanConfig.getName();
        for (RuleSet ruleSet : scanConfig.getRuleSets()) {
            String rulesetName = ruleSet.getName();
            for (Rule rule: ruleSet.getRules()){
                String name = scanConfigName + "::" + rulesetName + "::" + rule.getName();
                rules.add(new Rule(name, rule));
            }
        }

        List<File> files = getFiles(sourceDir);




        // get a list of all the files
        // read the file line by line
        //
    }
    public List<File> getFiles(String sourceDir){
        List<File> files = new ArrayList<>();
        for (File file : new File(sourceDir).listFiles()){
            if (file.isDirectory()){
                files.addAll(getFiles(file.getPath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    public List<ScanError> checkFile(File file, List<Rule> rules){
        List<ScanError> errors = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)){
            int lineCount = 0;
            while (scanner.hasNext()){
                lineCount++;
                String line = scanner.nextLine();
                for (Rule rule: rules){
                    Matcher matcher = rule.getPattern().matcher(line);
                    if (matcher.find()){
                        ScanError error = new ScanError(rule.getName(), file, lineCount);
                        errors.add(error);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return errors;
    }
}
