package net.byteshop.util.string.prettyformat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the TableFormatter class
 * 
 * @author Jim Lombardo, jlombardo@wbyteshop.net 
 * @version 1.01
 * @since JDK 8
 */
public class TableFormatterTest {
    private TableFormatter formatter;
    
    private String[][] goodTestData1 = {
            {"Part No","Description","Qty","Unit Cost","Ext. Price"},
            {"-------","-----------","---","---------","----------"},
            {"A100","Brewer Hat","2","29.95","59.90"},
            {"B12345","Mosquito Sprayer","20","9.95","199.99"}
        };
    private String[][] nullTestData = null;
 
    private JustifyDirection[] goodPads = {
            JustifyDirection.LEFT,JustifyDirection.LEFT,
            JustifyDirection.RIGHT,JustifyDirection.RIGHT,
            JustifyDirection.RIGHT
        };
    private JustifyDirection[] nullPads = null;
    
    private String[] goodTestColData = {"xx","xxx","x","xxxxx","xxxxxxxxx","xxxx"};
    
    
    public TableFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        formatter = new TableFormatter();        
    }

    /**
     * Test of toFormattedStr method, of class TableFormatter. Any Exceptions
     * will cause test to fail. However, we can also visually confirm the output 
     * at the console.
     */
    @Test
    public void testToFormattedStr() {
        String strFormatted = formatter.toFormattedStr(goodTestData1, goodPads, 2);
        System.out.println("\n" + strFormatted);
    }
    
    /**
     * Test of toFormattedStr method throws an exception if data param is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToFormattedStrNullTestData() {
        String strFormatted = formatter.toFormattedStr(nullTestData, goodPads, 2);
    }
    
    /**
     * Test of toFormattedStr method throws an exception if justifyDir param is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToFormattedStrNullPads() {
        String strFormatted = formatter.toFormattedStr(goodTestData1, nullPads, 2);
    }
 
    /**
     * Test of rightJustifyData method, of class TableFormatter.
     */
    @Test
    public void testRightJustifyData() {
        String[] resultData = formatter.rightJustifyData(goodTestColData);
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
        String[] resultData = formatter.leftJustifyData(goodTestColData);
        int expectedLen = resultData[0].length();
        for(String s : resultData) {
            //System.out.println(s);
            assertTrue("Strings not padded correctly", s.length() == expectedLen);
        }
    }

    
}
