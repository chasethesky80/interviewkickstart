package com.introtoproblemsolving;

/**
 * A number is a perfect number if sum of its factors excluding the number equals the number
 */
public class CheckIfANumberIsAPerfectNumber {

    public static void main(String[] args) {
        System.out.println("IS NUMBER PERFECT NUMBER "+ isPerfectNumber(28));
        System.out.println("IS NUMBER PERFECT NUMBER "+ isPerfectNumber(100));
    }

    private static boolean isPerfectNumber(final Integer N) {
        int sum = 1;
        for (int i = 2; i*i <= N; i++) {
            if (N % i == 0) {
                sum = sum + i;
                if (i != N/i) {
                    sum = sum + N/i;
                }
            }
        }
        return sum == N;
    }
}
