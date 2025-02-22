package com.introtoproblemsolving;

public class SumOfDigitsOfANumber {

    public static void main(String[] args) {
        System.out.println("SUM OF DIGITS OF THE NUMBER "+ sumOfDigits(221));
        System.out.println("SUM OF DIGITS OF THE NUMBER "+ sumOfDigits(2678));
    }

    private static int sumOfDigits(int N) {
        int sum = 0;
        while (N > 0) {
            int remainder = N % 10;
            sum = sum + remainder;
            N = N / 10;
        }
        return sum;
    }
}
