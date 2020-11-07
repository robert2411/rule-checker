//package com.github.robert2411.rule.checker.maven.plugin;
//
//import org.apache.maven.plugin.testing.AbstractMojoTestCase;
//
//import java.io.File;
//
//import static org.junit.Assert.*;
//
//public class RuleCheckerMojoTest extends AbstractMojoTestCase
//{
//    /** {@inheritDoc} */
//    protected void setUp() throws Exception {
//        // required
//        super.setUp();
//    }
//
//    /** {@inheritDoc} */
//    protected void tearDown() throws Exception {
//        // required
//        super.tearDown();
//    }
//
//    /**
//     * @throws Exception if any
//     */
//    public void testSomething()
//            throws Exception
//    {
//        File pom = getTestFile( "src/test/resources/unit/project-to-test/pom.xml" );
//        assertNotNull( pom );
//        assertTrue( pom.exists() );
//
//        RuleCheckerMojo myMojo = (RuleCheckerMojo) lookupMojo( "checkRules", pom );
//        assertNotNull( myMojo );
//        myMojo.execute();
//    }
//
//}