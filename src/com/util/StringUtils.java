package com.util;

public class StringUtils {

    public static String reversePartOfString(final String input, final int startIndex, final int endIndex) {
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i = startIndex, j = endIndex; i <= j; i++, j--) {
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, stringBuilder.charAt(j));
            stringBuilder.setCharAt(j, temp);
        }
        return stringBuilder.toString();
    }
}
