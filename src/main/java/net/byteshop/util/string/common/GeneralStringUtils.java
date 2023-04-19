package net.byteshop.util.string.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

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
     * Gets the longest line in a collection of lines (rows).
     *
     * @param data a 1-D collection of lines (rows)
     * @return an <code>java.util.Optional</code> with the longest line (row) or
     * nothing
     */
    public static Optional<String> getLongestLine2(final String[] data) {
        return Arrays.stream(data)
                .max(Comparator.comparingInt(String::length));
    }

    /**
     * Pads a String by adding characters to the left
     *
     * @param str the String to pad
     * @param padChar the character to use as padding
     * @param padsToAdd the number of characters to pad
     * @return the padded String
     */
    public static String padLeft(String str, final String padChar, int padsToAdd) {
        StringBuilder sb = new StringBuilder();
        while (padsToAdd > 0) {
            sb.append(padChar);
            padsToAdd--;
        }
        return sb.append(str).toString();
    }

    /**
     * Pads a String by adding characters to the right
     *
     * @param str the String to pad
     * @param padChar the character to use as padding
     * @param padsToAdd the number of characters to pad
     * @return the padded String
     */
    public static String padRight(String str, final String padChar, final int padsToAdd) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < padsToAdd; i++) {
            sb.append(padChar);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        String[] lines = {
//            "this is a short line",
//            "this is a very, very long line xxxx xxx xxx xxx xx"
//        };
//        
//        Optional<String> longest = getLongestLine2(lines);
//        if(longest.isPresent()) {
//            System.out.println("The longest line is: " + longest);
//        } else {
//            System.out.println("No value could be found");
//        }
//    }
}
