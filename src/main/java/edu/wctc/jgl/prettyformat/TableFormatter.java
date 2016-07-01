package edu.wctc.jgl.prettyformat;

import java.util.StringJoiner;

/**
 * Provides behaviors for outputting nicely formatted tabular data.
 * 
 * @author Jim Lombardo, jlombardo@wctc.edu
 */
public class TableFormatter {
    
    /**
     * Outputs table to console with properly justified and spaced columns.
     * 
     * @param data a 2D array of row/col data
     * @param justifyDir a 1D array of JustifyDirection options for each
     * column
     * @param spacers number of spaces to use between columns
     */
    public void outputData(String[][] data, 
            JustifyDirection[] justifyDir, int spacers) {
        
        // How many columns do we have
        int cols = data[0].length;
        
        // justify each column according to spec in padLocs
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
            System.out.println(sj.toString());
            sj = new StringJoiner(spacing);
        }
    }
    
    /**
     * Gets the length of the longest line in a collection of lines
     * @param data a collection of lines
     * @return the length of the longest line
     */
    public int getLongestLineLength(String[] data) {
        String longestLine = data[0];
        
        for(int i=0; i < data.length; i++) {
            if(data[i].length() > longestLine.length()) {
                longestLine = data[i]; 
            }
        }
        
        return longestLine.length();
    }
    
    /**
     * Left justifies a collection of column data per row
     * @param data a collection of column data per row
     * @return a justified collection
     */
    public String[] leftJustifyData(String[] data) {
        String longestLine = data[0];
        
        for(int i=0; i < data.length; i++) {
            if(data[i].length() > longestLine.length()) {
                longestLine = data[i]; 
            }
        }
        
        for(int i=0; i < data.length; i++) {
            int pads = longestLine.length() - data[i].length();
            if(pads > 0) {
                data[i] = padRight(data[i]," ",pads);
            }
        }
        
        return data;
    }

    /**
     * Right justifies a collection of column data per row
     * @param data a collection of column data per row
     * @return a justified collection
     */
    public String[] rightJustifyData(String[] data) {
        String longestLine = data[0];
        
        for(int i=0; i < data.length; i++) {
            if(data[i].length() > longestLine.length()) {
                longestLine = data[i]; 
            }
        }
        
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
