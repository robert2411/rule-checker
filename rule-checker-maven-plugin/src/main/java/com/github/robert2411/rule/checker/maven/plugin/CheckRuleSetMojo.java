package com.github.robert2411.rule.checker.maven.plugin;

import com.github.robert2411.rule.checker.maven.plugin.utils.FileUtils;
import com.github.robert2411.rule.checker.core.RuleChecker;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo( name = "checkRuleSet")
public class CheckRuleSetMojo extends AbstractCheckerMojo
{
    @Parameter(property = "ruleSetPath")
    private String ruleSetPath;

    @Override
    protected List<ScanError> execute(RuleChecker ruleChecker, String sourceDir) {
        RuleSet ruleSet = FileUtils.ruleSetFromFile(ruleSetPath);
        return ruleChecker.check(sourceDir, ruleSet);
    }
}