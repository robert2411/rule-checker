package com.github.robert2411.rule.checker.core;

import com.github.robert2411.rule.checker.core.models.Rule;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class RuleCheckerTest {

    @Test
    public void getFilesTest(){
        RuleChecker ruleChecker = new RuleChecker();
        List<File> files = ruleChecker.getFiles("./src/test/java/");
        Assert.assertFalse(files.isEmpty());
    }

    @Test
    public void checkFileTest(){
        RuleChecker ruleChecker = new RuleChecker();
        List<ScanError> errors = ruleChecker.checkFile(new File("./src/test/java/com/github/robert2411/rule/checker/core/RuleCheckerTest.java"), Collections.singletonList(new Rule("testName", "testDescription", "@Test")));
        Assert.assertFalse(errors.isEmpty());
    }
}