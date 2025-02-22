package com.strings;

import com.util.StringUtils;

// GIVEN A STRING OF CHARACTERS, SORT IT IN DICTIONARY ORDER
public class SortStringOfCharactersInDictionaryOrder {

    public static void main(String[] args) {
        System.out.println("SORT STRING IN DICTIONARY ORDER "+ sortInDictionaryOrderWithoutSortingAlgorithm("dabaedb"));
    }

    // TC = O(N) and SC = O(1), constant we using a count array of size 26
    private static String sortInDictionaryOrderWithoutSortingAlgorithm(final String input) {
        int hash[] = new int[26];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            hash[element - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < hash[i]; j++) {
                str.append((char) ('a' + i));
            }
        }
        return str.toString();
    }
}
