package com.introtoproblemsolving;

public class FindIfNumberIsPalindrome {

    public static void main(String[] args) {
        System.out.println("Is NUMBER A PALINDROME "+ isNumberAPalindrome(221));
        System.out.println("Is NUMBER A PALINDROME "+ isNumberAPalindrome(757));
        System.out.println("Is NUMBER A PALINDROME "+ isNumberAPalindrome(888));
    }

    private static boolean isNumberAPalindrome(int N) {
        return N == reverseNumber(N);
    }

    private static int reverseNumber(int N) {
        int reversed = 0;
        while (N > 0) {
            int remainder = N % 10;
            reversed = reversed * 10 + remainder;
            N = N / 10;
        }
        return reversed;
    }
}
