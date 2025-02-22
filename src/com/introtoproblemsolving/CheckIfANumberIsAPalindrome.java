package com.introtoproblemsolving;

public class CheckIfANumberIsAPalindrome {

    public static void main(String[] args) {
        System.out.println("IS A PALINDROM "+ isAPalindrome(676));
        System.out.println("IS A PALINDROM "+ isAPalindrome(677));
    }
    private static boolean isAPalindrome(int N) {
        int reverseNum = reversed(N);
        return N == reverseNum;
    }

    private static int reversed(int N) {
        int ans = 0;
        while (N > 0) {
            int modulus = N % 10;
            ans = ans * 10 + modulus;
            N = N / 10;
        }
        return ans;
    }
}
