package com.subsets;

import com.util.BitManipulationHelper;

/**
 * Given an array find the sum of max of all subsequences of the array
 */
public class FindSumOfMaxOfAllSubsequences {

    public static void main(String[] args) {
        System.out.println("SUM OF MAX OF ALL SUBSEQUENCES OF ARRAY "+ findSumOfMaxOfAllSubsequencesBruteForce(new int[]{ 3, 1, -4 }));
    }

    private static int findSumOfMaxOfAllSubsequencesBruteForce(int[] arr) {
        int N = arr.length, sum = 0;
        for (int i = 0; i < Math.pow(2, N); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                if (BitManipulationHelper.checkIfBitIsSetInPosition(i, j)) {
                    max = Math.max(max, arr[j]);
                }
            }
            /**
             * Accommodate for the edge case where there can be an empty subset in which case max is never reassigned
             * and so compute sum only when max is assigned a valid value other than Integer.MIN_VALUE
             */
            if (max > Integer.MIN_VALUE) {
                sum += max;
            }
        }
        return sum;
    }
}
