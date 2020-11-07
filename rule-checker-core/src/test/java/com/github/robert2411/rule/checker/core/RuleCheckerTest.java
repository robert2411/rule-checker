package com.github.robert2411.rule.checker.core;

import com.github.robert2411.rule.checker.core.impl.RuleCheckerImpl;
import com.github.robert2411.rule.checker.core.models.Rule;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class RuleCheckerTest {
    String sourceFolder = "./src/test/java/";
    Rule rule = new Rule("testRule", "testDescription", "@Test");
    RuleSet ruleSet = new RuleSet("testSet", "test 123", Collections.singletonList(rule));

    @Test
    public void checkTest(){
        RuleCheckerImpl ruleChecker = new RuleCheckerImpl();
        List<ScanError> errors = ruleChecker.check(sourceFolder, ruleSet);
        Assert.assertFalse(errors.isEmpty());
    }
}