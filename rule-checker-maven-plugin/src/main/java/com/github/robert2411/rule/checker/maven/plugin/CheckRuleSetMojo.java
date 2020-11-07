package com.github.robert2411.rule.checker.maven.plugin;

import com.github.robert2411.rule.checker.core.FileUtils;
import com.github.robert2411.rule.checker.core.RuleChecker;
import com.github.robert2411.rule.checker.core.impl.RuleCheckerImpl;
import com.github.robert2411.rule.checker.core.models.RuleSet;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Mojo( name = "checkRuleSet")
public class CheckRuleSetMojo extends AbstractMojo
{
    @Parameter( property = "project", defaultValue = "${project}" )
    private MavenProject project;
    @Parameter(property = "ruleSetPath")
    private String ruleSetPath;
    public void execute() throws MojoExecutionException
    {
        try {
            RuleChecker ruleChecker = new RuleCheckerImpl();
            String sourceDir = project.getBuild().getSourceDirectory();
            RuleSet ruleSet = FileUtils.ruleSetFromFile(ruleSetPath);
            List<ScanError> errors = ruleChecker.check(sourceDir, ruleSet);
            errors.forEach(e -> getLog().error(e.toString()));
            if (!errors.isEmpty()){
                throw new MojoExecutionException("One or more errors where found, see the log output for more details");
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new MojoExecutionException(e.getMessage());
        }

    }
}