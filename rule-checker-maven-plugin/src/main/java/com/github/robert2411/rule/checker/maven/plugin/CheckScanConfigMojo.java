package com.github.robert2411.rule.checker.maven.plugin;

import com.github.robert2411.rule.checker.maven.plugin.utils.FileUtils;
import com.github.robert2411.rule.checker.core.RuleChecker;
import com.github.robert2411.rule.checker.core.models.ScanConfig;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo( name = "checkScanConfig")
public class CheckScanConfigMojo extends AbstractCheckerMojo
{
    @Parameter(property = "scanConfigPath")
    private String scanConfigPath;

    @Override
    protected List<ScanError> execute(RuleChecker ruleChecker, String sourceDir) {
        ScanConfig scanConfig = FileUtils.scanConfigFromFile(scanConfigPath);
        return ruleChecker.check(sourceDir, scanConfig);
    }
}