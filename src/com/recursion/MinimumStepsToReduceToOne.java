package com.recursion;

/**
 * FIND THE MINIMUM NUMBER OF STEPS TO REDUCE A NUMBER TO 1 AND FOLLOWING ARE CONDITIONS:
 * IF NUMBER IS DIVISIBLE BY 2 THEN DIVIDE BY 2 ELSE SUBTRACT 1 FROM THE NUMBER
 * TC = O(LOGN) SINCE WE ARE HALFING BY 2
 */
public class MinimumStepsToReduceToOne {

    public static void main(String[] args) {
        System.out.println("FIND MINIMUM STEPS TO REDUCE NUMBER TO 1 IS "+ minimumStepsToReduceToOne(150));
    }
    private static int minimumStepsToReduceToOne(int N) {
        if (N == 1) {
            return 0;
        }
        int count = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = N - 1;
            }
            count++;
        }
        return count;
    }
}
