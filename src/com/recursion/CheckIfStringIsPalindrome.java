package com.recursion;

public class CheckIfStringIsPalindrome {

    public static void main(String[] args) {
        System.out.println("CHECK FOR PALINDROME "+checkForPalindromeRegularAppraoch("malayalam"));
        System.out.println("CHECK FOR PALINDROME "+checkForPalindromeRegularAppraoch("malayala"));
        System.out.println("CHECK FOR PALINDROME "+checkForPalindromeRecursiveApproach("malayalam", 0, "malayalam".length()-1));
        System.out.println("CHECK FOR PALINDROME "+checkForPalindromeRecursiveApproach("malayala", 0, "malayala".length()-1));
    }

    private static boolean checkForPalindromeRecursiveApproach(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return true;
        }

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return checkForPalindromeRecursiveApproach(s, startIndex+1, endIndex-1);
        }
        return false;
    }

    private static boolean checkForPalindromeRegularAppraoch(String s) {
        for (int i =0, j = s.length()-1; i <= j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
