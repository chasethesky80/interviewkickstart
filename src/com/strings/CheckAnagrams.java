package com.strings;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class CheckAnagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("dog", "cat"));
        System.out.println(isAnagram("dog", "god"));
        System.out.println(isAnagram("dog", "dog"));
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] aChar = new char[26];
        char[] bChar = new char[26];
        for (int i = 0; i < a.length(); i++) {
            aChar[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {

        }
        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] != bChar[i]) {
                return false;
            }
        }
        return true;
    }
}
