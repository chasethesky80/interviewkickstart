package com.introtoproblemsolving;

public class SumOfAlternateDigitsOfNumber {

    public static void main(String[] args) {
        System.out.println("SUM OF ALTERNATE DIGITS ");
        sumOfAlternateDigits(123456);
    }
    private static void sumOfAlternateDigits(int N) {
        int sum1 = 0, sum2 = 0, count = 0;
        while (N > 0) {
             int remainder = N % 10;
             count++;
             if (count % 2 == 1) {
                 sum1 = sum1 + remainder;
             } else {
                 sum2 = sum2 + remainder;
             }
             N = N / 10;
        }
        System.out.println("SUM OF ALTERNATE DIGITS "+ sum1 +" "+ sum2);
    }
}
