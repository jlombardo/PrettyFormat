package net.byteshop.util.string.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jlombardo
 */
public class GeneralStringUtilsTest {
    private String[] goodTestColData = {"xx","xxx","x","xxxxx","xxxxxxxxx","xxxx"};
    
    public GeneralStringUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   /**
     * Test of getLongestLine method, of class TableFormatter.
     */
    @Test
    public void testGetLongestLine() {
        String expected = "xxxxxxxxx";
        String actual = GeneralStringUtils.getLongestLine(goodTestColData);
        assertTrue("Longest line search failed", actual.equals(expected));
    }

    /**
     * Test of padleft method, of class TableFormatter.
     */
    @Test
    public void testPadLeft() {
        String testStr = "xx";
        int testPadLen = 9;
        int expectedLen = 11;
        String resultStr = GeneralStringUtils.padLeft(testStr, "x", testPadLen);
        //System.out.println(resultStr);
        assertTrue("Pad Left failed", resultStr.length() == expectedLen);
    }

    /**
     * Test of padRight method, of class TableFormatter.
     */
    @Test
    public void testPadRight() {
        String testStr = "xx";
        int testPadLen = 9;
        int expectedLen = 11;
        String resultStr = GeneralStringUtils.padRight(testStr, "x", testPadLen);
        //System.out.println(resultStr);
        assertTrue("Pad Left failed", resultStr.length() == expectedLen);
    }    
}
