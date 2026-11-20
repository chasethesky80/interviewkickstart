package com.strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithNonRepeatingChars {

    public static void main(String[] args) {
        System.out.println("LONGEST SUBSTRING WITH NON REPEATING CHARACTERS "+ longestSubstringWithNonRepeatingCharacters(
                "aebcabgeb@#gbkdb#"
        ));
    }

    private static int longestSubstringWithNonRepeatingCharacters(String s) {
        int st = 0, end = 0, result = 0;
        final Map<Character, Integer> characterMap = new HashMap<>();
        while (end < s.length()) {
            char current = s.charAt(end);
            if (characterMap.containsKey(current)) {
                int index = characterMap.get(current);
                if (index >= st) {
                    st = index + 1;
                }
            }
            characterMap.put(current, end);
            result = Math.max(result, end - st + 1);
            end++;
        }
        return result;
    }
}
