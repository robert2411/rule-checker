package com.github.robert2411.rule.checker.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.net.URI;
import java.util.Arrays;

@Mojo( name = "checkRules")
public class RuleCheckerMojo extends AbstractMojo
{
    @Parameter( property = "project", defaultValue = "${project}" )
    private MavenProject project;
    @Parameter(property = "scanconfigUrl")
    private URI scanConfig;
    public void execute() throws MojoExecutionException
    {
        getLog().info("" + project);
        getLog().info("" + project.getBasedir());
        getLog().info("" + project.getBuild().getSourceDirectory());
        getLog().info("" + Arrays.toString(new File(project.getBuild().getSourceDirectory()).listFiles()));
        getLog().info( "Hello, world." );
    }
}