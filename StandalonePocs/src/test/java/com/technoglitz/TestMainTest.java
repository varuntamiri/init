package com.technoglitz;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// TODO: Auto-generated Javadoc
/**
 * Unit test for simple App.
 */
public class TestMainTest 
    extends TestCase
{
    
    /**
     * Create the test case.
     *
     * @param testName name of the test case
     */
    public TestMainTest( String testName )
    {
        super( testName );
    }

    /**
     * Suite.
     *
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestMainTest.class );
    }

    /**
     * Rigourous Test :-).
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
