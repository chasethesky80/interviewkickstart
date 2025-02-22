package com.strings;

// GIVEN A STRING TOGGLE CHARACTERS OF THE STRING - CONVERT UPPER CASE CHARS TO LOWER CASE AND VICE VERSA
public class ToggleCharactersOfAString {

    public static void main(String[] args) {
        System.out.println("TOGGLE CHARACTERS OF STRING "+toggleChars("aEErTsD"));
        System.out.println("TOGGLE CHARACTERS OF STRING "+toggleCharsImprovised("aEErTsD"));
        System.out.println("TOGGLE CHARACTERS OF STRING "+toggleCharsWithBitManipulation("aEErTsD"));
    }

    // TC = O(N) since it takes constant time to update a character in string builder and hence O(N) for all N characters,
    // SC = O(1) since no extra space used, adding ASCII values of characters to convert from lowercase to uppercase
    // and vice versa
    private static String toggleChars(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i =0; i < input.length(); i++) {
            char value = stringBuilder.charAt(i);
            if (value >= 'a' && value <= 'z') {
                stringBuilder.setCharAt(i, (char)(value - 32));
            } else if (value >= 'A' && value <= 'Z') {
                stringBuilder.setCharAt(i, (char)(value + 32));
            }
        }
        return stringBuilder.toString();
    }

    // HERE I DO NOT WANT TO REMEMBER THE VALUE OF 32 SO USE 'a' - 'A' AS THE DIFFERENCE IN ASCII VALUES BETWEEN A UPPERCASE
    // AND LOWERCASE CHARACTER
    private static String toggleCharsImprovised(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i =0; i < input.length(); i++) {
            char value = stringBuilder.charAt(i);
            if (value >= 'a' && value <= 'z') {
                stringBuilder.setCharAt(i, (char)(value - ('a' - 'A')));
            } else if (value >= 'A' && value <= 'Z') {
                stringBuilder.setCharAt(i, (char)(value + ('a' - 'A')));
            }
        }
        return stringBuilder.toString();
    }

    // TC = O(N), HERE WE JUST FLIP THE 5TH BIT OF ORIGINAL STRING WHICH IS SAME AS 2^5 = 32 IN VALUE SINCE THE ASCII
    // VALUE DIFFERENCE BETWEEN UPPER AND LOWER CASE CHARACTERS IS 32 AND THIS WILL
    // CONVERT LOWER CASE TO UPPER CASE CHARACTERS AND VICE VERSA - PLEASE REFER VIDEO LECTURE
    // SC = O(1)
    private static String toggleCharsWithBitManipulation(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i =0; i < input.length(); i++) {
            char value = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, (char)(value ^ (1 << 5)));
        }
        return stringBuilder.toString();
    }
}
