package com.strings;

public class LengthOfLongestPalindromicSubstring {

    public static void main(String[] args) {
      System.out.println("FIND LONGEST PALINDROMIC SUBSTRING FOR "+lengthOfLongestPalindromicSubstring("bdyzzydb"));
        System.out.println("FIND LONGEST PALINDROMIC SUBSTRING FOR "+lengthOfLongestPalindromicSubstring("xbdyzzydbdyzydx"));
    }

    private static int lengthOfLongestPalindromicSubstring(String input) {
        int answer = 1;
        // COMPUTE MAX LENGTH OF PALINDROMIC SUBSTRING FOR ODD LENGTH PALINDROME
        for (int i = 0; i < input.length(); i++) {
            answer = Math.max(answer, expand(input, i, i));
        }
        // COMPUTE MAX LENGTH OF PALINDROMIC SUBSTRING FOR EVEN LENGTH PALINDROME
        for (int i = 0; i < input.length()-1; i++) {
            answer = Math.max(answer, expand(input, i, i+1));
        }
        return answer;
    }
    private static int expand(final String input, int leftIndex, int rightIndex) {
        while(leftIndex >= 0 && rightIndex < input.length() && input.charAt(leftIndex) == input.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
