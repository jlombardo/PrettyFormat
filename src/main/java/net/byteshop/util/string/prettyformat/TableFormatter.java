package net.byteshop.util.string.prettyformat;

import java.util.StringJoiner;
import net.byteshop.util.string.common.GeneralStringUtils;

/**
 * This class is a utility for outputting nicely formatted tabular String data 
 * where mono-spaced fonts are used such as at the console and with some GUI 
 * components.<br>
 * <br>
 * It primarily solves the problem of proper column justification where row 
 * length and justification needs vary.
 * 
 * @author Jim Lombardo, jlombardo@byteshop.net 
 * @version 1.01
 * @since JDK 8
 */
public class TableFormatter {
    private static final int ROW = 0;
    private static final int COL = 1;
    
    /**
     * Formats mono-spaced output table with properly justified and spaced columns. 
     * This is typically needed for console output but can be used anywhere a 
     * mono-spaced table of data can be displayed.<br>
     * <br>
     * Example Input:
     * <pre>
     * String[][] goodTestData1 = {
     *      {"Part No","Description","Qty","Unit Cost","Ext. Price"},
     *      {"-------","-----------","---","---------","----------"},
     *      {"A100","Brewer Hat","2","29.95","59.90"},
     *      {"B12345","Mosquito Sprayer","20","9.95","199.99"}
     *  };
     *
     * JustifyDirection[] goodPads = {
     *      JustifyDirection.LEFT,JustifyDirection.LEFT,
     *      JustifyDirection.RIGHT,JustifyDirection.RIGHT,
     *      JustifyDirection.RIGHT
     *  };
     *
     * int spacers = 2;
     * 
     * Example Output:
     * 
     * Part No  Description       Qty  Unit Cost  Ext. Price
     * -------  -----------       ---  ---------  ----------
     * A100     Brewer Hat          2      29.95       59.90
     * B12345   Mosquito Sprayer   20       9.95      199.99
     * </pre>
     * 
     * @param data a 2D array of row/col data.
     * @param justifyDir a 1D array of JustifyDirection options for each
     * column in order from left to right relative to the input data
     * @param spacers number of spaces to use between columns
     * @return table formatted as one large String to be used for output
     * @throws IllegalArgumentException when input is null or empty, or when
     * JustifyDir options don't match column count.
     * @since JDK 8
     */
    public String toFormattedStr(String[][] data, 
            JustifyDirection[] justifyDir, int spacers) 
            throws IllegalArgumentException {
        
        if(data == null || justifyDir == null || data.length == 0 
                || justifyDir.length == 0) {
            throw new IllegalArgumentException(
                    "Input arguments cannot be null or empty");
        }

        // column count should equal JustifyDirection array length
        if(data[COL].length != justifyDir.length) {
            throw new IllegalArgumentException(
                    "JustifyDirection options don't match column count");
        }
        
        StringBuilder sb = new StringBuilder();
        
        // How many columns do we have
        int cols = data[ROW].length;
        
        justifyColumns(cols, data, justifyDir);
        
        // now produce spacing between columns
        String spacing = "";
        for(int i=0; i < spacers; i++) {
            spacing += " ";
        }
        StringJoiner sj = new StringJoiner(spacing);
        
        // Finally, output formatted column with spacing
        for(int row = 0; row < data.length; row++) {
            for(int col = 0; col < cols; col++) {
                sj.add(data[row][col]);
            }
            sb.append(sj.toString()).append("\n");
            sj = new StringJoiner(spacing);
        }
        
        return sb.toString();
    }

    private void justifyColumns(int cols, String[][] data, JustifyDirection[] justifyDir) {
        // justify each data column according to spec in justifyDir and spacers
        for(int colNo=0; colNo < cols; colNo++) {
            // first gather column data into a temp array
            String[] colData = new String[data.length];
            for(int row = 0; row < data.length; row++) {
                colData[row] = data[row][colNo];
            }
            
            // now use that temp array to justify each item in column
            if(justifyDir[colNo] == JustifyDirection.LEFT) {
                colData = leftJustifyData(colData);
            } else {
                colData = rightJustifyData(colData);
            }
            
            // then put justified column array back in data[][]
            for(int row = 0; row < data.length; row++) {
                data[row][colNo] = colData[row];
            }
        }
    }
   
    /**
     * Left justifies a column data for one row using space padding
     * @param data a collection of column data for one row
     * @return a justified collection of column data for one row
     */
    public String[] leftJustifyData(String[] data) {
        String longestLine = GeneralStringUtils.getLongestLine(data);
        
        for(int i=0; i < data.length; i++) {
            int pads = longestLine.length() - data[i].length();
            if(pads > 0) {
                data[i] = GeneralStringUtils.padRight(data[i]," ",pads);
            }
        }
        
        return data;
    }

    /**
     * Right justifies a column of data for one row with space padding
     * @param data a collection of column data for one row
     * @return a justified collection of column data for one row
     */
    public String[] rightJustifyData(String[] data) {
        String longestLine = GeneralStringUtils.getLongestLine(data);
        
        for(int i=0; i < data.length; i++) {
            int pads = longestLine.length() - data[i].length();
            if(pads > 0) {
                data[i] = GeneralStringUtils.padLeft(data[i]," ", pads);
            }
        }
        
        return data;
    }
    
    
}
