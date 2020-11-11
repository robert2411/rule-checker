package com.github.robert2411.rule.checker.maven.plugin;

import com.github.robert2411.rule.checker.core.RuleChecker;
import com.github.robert2411.rule.checker.core.impl.RuleCheckerImpl;
import com.github.robert2411.rule.checker.core.models.ScanError;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

public abstract class AbstractCheckerMojo extends AbstractMojo
{
    @Parameter( property = "project", defaultValue = "${project}" )
    private MavenProject project;
    @Parameter(name = "skip")
    private boolean skip;
    public void execute() throws MojoExecutionException
    {
        if (skip || "pom".equalsIgnoreCase(project.getPackaging())){
            getLog().info("Skipping execution of the plugin");
            return;
        }
        try {
            RuleChecker ruleChecker = new RuleCheckerImpl();
            String sourceDir = project.getBuild().getSourceDirectory();
            List<ScanError> errors = execute(ruleChecker, sourceDir);
            errors.forEach(e -> getLog().error(e.toString()));
            if (!errors.isEmpty()){
                throw new MojoExecutionException("One or more errors where found, see the log output for more details");
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new MojoExecutionException(e.getMessage());
        }
    }

    protected abstract List<ScanError> execute(RuleChecker ruleChecker, String sourceDir);
}