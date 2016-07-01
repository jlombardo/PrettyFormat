package edu.wctc.jgl.prettytermtable;

import edu.wctc.jgl.prettyformat.TableFormatter;
import edu.wctc.jgl.prettyformat.JustifyDirection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jlombardo
 */
public class TableFormatterTest {
    private static TableFormatter formatter;
    
    public TableFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        formatter = new TableFormatter();
    }
    
    @Before
    public void setUp() {
        
    }

    /**
     * Test of outputData method, of class TableFormatter. No asserts used 
     * because we are just visually confirming appearance of output. CAUTION: 
     * test will ALWAYS pass.
     */
    @Test
    public void testOutputData() {
        String[][] testData = {
            {"Part No","Description","Qty","Unit Cost","Ext. Price"},
            {"-------","-----------","---","---------","----------"},
            {"A100","Brewer Hat","2","29.95","59.90"},
            {"B12345","Mosquito Sprayer","20","9.95","199.99"}
        };
        JustifyDirection[] pads = {
            JustifyDirection.LEFT,JustifyDirection.LEFT,
            JustifyDirection.RIGHT,JustifyDirection.RIGHT,
            JustifyDirection.RIGHT
        };
        formatter.outputData(testData, pads, 2);
    }

    /**
     * Test of rightJustifyData method, of class TableFormatter.
     */
    @Test
    public void testRightJustifyData() {
        String[] testData = {"xx","xxx","x","xxxxx","xxxxxxxxx","xxxx"};
        String[] resultData = formatter.rightJustifyData(testData);
        int expectedLen = resultData[0].length();
        for(String s : resultData) {
            //System.out.println(s);
            assertTrue("Strings not padded correctly", s.length() == expectedLen);
        }
    }

    /**
     * Test of leftJustifyData method, of class TableFormatter.
     */
    @Test
    public void testLeftJustifyData() {
        String[] testData = {"xx","xxx","x","xxxxx","xxxxxxxxx","xxxx"};
        String[] resultData = formatter.leftJustifyData(testData);
        int expectedLen = resultData[0].length();
        for(String s : resultData) {
            //System.out.println(s);
            assertTrue("Strings not padded correctly", s.length() == expectedLen);
        }
    }

    /**
     * Test of getLongestLineLength method, of class TableFormatter.
     */
    @Test
    public void testGetLongestLineLength() {
        String[] testData = {"xx","xxx","x","xxxxx","xxxxxxxxx","xxxx"};
        int expectedLen = 9;
        int actualLen = formatter.getLongestLineLength(testData);
        assertTrue("Longest line length failed", actualLen == expectedLen);
    }

    /**
     * Test of padleft method, of class TableFormatter.
     */
    @Test
    public void testPadLeft() {
        String testStr = "xx";
        int testPadLen = 9;
        int expectedLen = 11;
        String resultStr = formatter.padLeft(testStr, "x", testPadLen);
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
        String resultStr = formatter.padRight(testStr, "x", testPadLen);
        //System.out.println(resultStr);
        assertTrue("Pad Left failed", resultStr.length() == expectedLen);
    }
    
}
