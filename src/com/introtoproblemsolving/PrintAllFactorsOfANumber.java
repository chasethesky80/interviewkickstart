package com.introtoproblemsolving;

public class PrintAllFactorsOfANumber {

    public static void main(String[] args) {
        System.out.println("PRINTING ALL FACTORS FOR ");
        printAllFactors(100);
    }

    /**
     * FIND ALL FACTORS OF NUMBER OPTIMIZED, TC = O(SQRT(N)) and SC = Constant
     * @param N
     */
    private static void printAllFactors(int N) {
        for (int i = 1; i*i <= N; i++) {
            if (N % i == 0) {
                System.out.print(i == N/i ? i : (i +", "+N/i) +"\n");
            }
        }
    }
}
