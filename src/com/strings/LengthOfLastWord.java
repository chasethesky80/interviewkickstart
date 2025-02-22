package com.strings;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("LENGTH OF LAST WORD "+ lengthOfLastWord("fly me   to   the moon"));
        System.out.println("LENGTH OF LAST WORD "+ lengthOfLastWord("a a"));
        System.out.println("LENGTH OF LAST WORD "+ lengthOfLastWord("aa"));
    }
    private static int lengthOfLastWord(final String s) {
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
            if (s.charAt(i) == ' ') {
                index = i;
                break;
            }
        }
        return index == 0 ? s.length() : s.length() - 1 - index;
    }
}
