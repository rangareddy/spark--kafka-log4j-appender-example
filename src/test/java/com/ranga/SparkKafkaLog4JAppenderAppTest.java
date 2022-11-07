package com.ranga;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple KafkaLog4jAppenderApp.
 */
public class SparkKafkaLog4JAppenderAppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SparkKafkaLog4JAppenderAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SparkKafkaLog4JAppenderAppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
