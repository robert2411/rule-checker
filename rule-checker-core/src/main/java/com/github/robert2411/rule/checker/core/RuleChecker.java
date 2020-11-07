package com.github.robert2411.rule.checker.core;

import com.github.robert2411.rule.checker.core.models.Rule;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanConfig;
import com.github.robert2411.rule.checker.core.models.ScanError;

import java.util.List;

public interface RuleChecker {
    List<ScanError> check(String sourceDir, ScanConfig scanConfig);
    List<ScanError> check(String sourceDir, RuleSet ruleSet);
}
