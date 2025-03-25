package com.introtoproblemsolving;

public class NumberOfTrailingZerosInFactorial {

    public static void main(String[] args) {
        System.out.println("FIND NUMBER OF TRAILING ZEROS IN FACTORIAL OF N "+ numberOfTrailingZeros(20));
        System.out.println("FIND NUMBER OF TRAILING ZEROS IN FACTORIAL OF N "+ numberOfTrailingZeros(25));
    }
    private static int numberOfTrailingZeros(int num) {
        int cnt2= 0;
        int cnt5 = 0;
        for (int i =1; i <= num; i++) {
            int N = i;
            while (N % 2 == 0) {
                cnt2++;
                N = N / 2;
            }
            while (N % 5 == 0) {
                cnt5++;
                N = N / 5;
            }
        }
        return Math.min(cnt2, cnt5);
    }
}
