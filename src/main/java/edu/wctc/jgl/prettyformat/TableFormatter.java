package edu.wctc.jgl.prettyformat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

/**
 * Provides behaviors for outputting nicely formatted tabular data.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu 
 */
public class TableFormatter {
    
    /**
     * Formats table to with properly justified and spaced columns.
     * 
     * @param data a 2D array of row/col data
     * @param justifyDir a 1D array of JustifyDirection options for each
     * column
     * @param spacers number of spaces to use between columns
     * @return table formatted as one large String to be used by an output 
     * component
     * @throws IllegalArgumentException if
     */
    public String toFormattedStr(String[][] data, 
            JustifyDirection[] justifyDir, int spacers) throws IllegalArgumentException {
        
        // column count should equal JustifyDirection array length
        if(data == null || justifyDir == null || data[0].length != justifyDir.length) {
            throw new IllegalArgumentException("JustifyDirection options don't match column length");
        }
        
        StringBuilder sb = 
                new StringBuilder();
        
        // How many columns do we have
        int cols = data[0].length;
        
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
    
    /**
     * Gets the longest line in a collection of lines
     * @param data a collection of lines
     * @return the longest line
     * @since JDK 1.8
     */
    public String getLongestLine(String[] data) {
          return Arrays.stream(data)
                  .max(Comparator.comparingInt(String::length))
                  .get();
    }
    
    /**
     * Left justifies a collection of column data per row with padding
     * @param data a collection of column data per row
     * @return a justified collection
     * @since JDK 1.8
     */
    public String[] leftJustifyData(String[] data) {
        String longestLine = getLongestLine(data);
        
        for(int i=0; i < data.length; i++) {
            int pads = longestLine.length() - data[i].length();
            if(pads > 0) {
                data[i] = padRight(data[i]," ",pads);
            }
        }
        
        return data;
    }

    /**
     * Right justifies a collection of column data per row with padding
     * @param data a collection of column data per row
     * @return a justified collection
     * @since JDK 1.8
     */
    public String[] rightJustifyData(String[] data) {
        String longestLine = getLongestLine(data);
        
        for(int i=0; i < data.length; i++) {
            int pads = longestLine.length() - data[i].length();
            if(pads > 0) {
                data[i] = padLeft(data[i]," ", pads);
            }
        }
        
        return data;
    }
    
    /**
     * Pads a String by adding characters to the left
     * @param str the String to pad
     * @param padChar the character to use as padding
     * @param padsToAdd the number of characters to pad
     * @return the padded String
     */
    public String padLeft(String str, String padChar, int padsToAdd) {
        for (int i = 0; i < padsToAdd; i++)
            str = padChar + str;
        return str;
    }
    
    /**
     * Pads a String by adding characters to the right
     * @param str the String to pad
     * @param padChar the character to use as padding
     * @param padsToAdd the number of characters to pad
     * @return the padded String
     */
    public String padRight(String str, String padChar, int padsToAdd) {
        for (int i = 0; i < padsToAdd; i++)
            str += padChar;
        return str;
    } 
    
    
}
