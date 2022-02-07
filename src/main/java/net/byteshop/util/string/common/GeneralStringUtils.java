package net.byteshop.util.string.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Some basic text handling utilities.
 * 
 * @author Jim Lombardo, jlombardo@wbyteshop.net 
 * @version 1.01
 * @since JDK 8
 */
public class GeneralStringUtils {
    
    /**
     * Gets the longest line in a collection of lines (rows).
     * 
     * @param data a 1-D collection of lines (rows)
     * @return the longest line (row)
     */
    public static String getLongestLine(final String[] data) {
          return Arrays.stream(data)
                  .max(Comparator.comparingInt(String::length))
                  .get();
    }
    
    /**
     * Pads a String by adding characters to the left
     * @param str the String to pad
     * @param padChar the character to use as padding
     * @param padsToAdd the number of characters to pad
     * @return the padded String
     */
    public static String padLeft(String str, final String padChar, final int padsToAdd) {
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
    public static String padRight(String str, final String padChar, final int padsToAdd) {
        for (int i = 0; i < padsToAdd; i++)
            str += padChar;
        return str;
    } 
    
}
