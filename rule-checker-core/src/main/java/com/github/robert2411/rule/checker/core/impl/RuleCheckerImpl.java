package com.github.robert2411.rule.checker.core.impl;

import com.github.robert2411.rule.checker.core.RuleChecker;
import com.github.robert2411.rule.checker.core.models.Rule;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanConfig;
import com.github.robert2411.rule.checker.core.models.ScanError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class RuleCheckerImpl implements RuleChecker {
    Logger logger = Logger.getLogger(RuleCheckerImpl.class.getName());

    @Override
    public List<ScanError> check(String sourceDir, ScanConfig scanConfig){
        // build a list with rules rename the rules to scanconfig_name::ruleset_name::rule_name
        List<Rule> rules = new ArrayList<>();
        String scanConfigName = scanConfig.getName();
        List<RuleSet> ruleSets = scanConfig.getRuleSets();
        for (RuleSet ruleSet : ruleSets) {
            String rulesetName = ruleSet.getName();
            for (Rule rule: ruleSet.getRules()){
                String name = scanConfigName + "::" + rulesetName + "::" + rule.getName();
                rules.add(new Rule(name, rule));
            }
        }
        return check(sourceDir, rules);
    }

    @Override
    public List<ScanError> check(String sourceDir, RuleSet ruleSet) {
        List<Rule> rules = new ArrayList<>();
        String rulesetName = ruleSet.getName();
        for (Rule rule: ruleSet.getRules()){
            String name = rulesetName + "::" + rule.getName();
            rules.add(new Rule(name, rule));
        }
        return check(sourceDir, rules);
    }

    private List<ScanError> check(String sourceDir, List<Rule> rules){
        return getFiles(sourceDir)
                .stream()
                .map(f -> checkFile(f, rules))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    private List<File> getFiles(String sourceDir){
        List<File> files = new ArrayList<>();
        File baseFile = new File(sourceDir);
        if (!(baseFile.exists() && baseFile.isDirectory())){
            throw new RuntimeException(sourceDir +" is not a valid source dir");
        }
        for (File file : baseFile.listFiles()){
            if (file.isDirectory()){
                files.addAll(getFiles(file.getPath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    private List<ScanError> checkFile(File file, List<Rule> rules){
        List<ScanError> errors = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)){
            int lineCount = 0;
            while (scanner.hasNext()){
                lineCount++;
                String line = scanner.nextLine();
                for (Rule rule: rules){
                    Matcher matcher = rule.getPattern().matcher(line);
                    if (matcher.find()){
                        ScanError error = new ScanError(rule, file, lineCount, line);
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
