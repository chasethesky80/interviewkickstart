package com.subarrays;

import java.util.List;

public class PrintStartAndEndIndexOfSubArrayLengthK {

    public static void main(String[] args) {
        System.out.println("PRINTING START AND END INDEX OF SUB-ARRAYS OF LENGTH ");
        printStartAndEndIndexOfSubArrayLengthK(List.of( 7, 3, 2, -1, 6, 8, 2, 3 ), 4);
        System.out.println();
        printStartAndEndIndexOfSubArrayLengthK(List.of( 3, 4, 2, -1, 6, 7, 8, 9, 3, 2, -1, 4 ), 3);
        System.out.println();
        printStartAndEndIndexOfSubArrayLengthK(List.of( 3, 4, 2, -1, 6, 7, 8, 9, 3, 2, -1, 4 ), 6);
    }

    // TC = O(N) AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static void printStartAndEndIndexOfSubArrayLengthK(final List<Integer> input, final int K) {
        int N = input.size();
        for (int i = 0; i <= N-K; i++) {
            System.out.println("START AND END INDEX "+ i +" "+(i + K-1));
        }
    }
}
