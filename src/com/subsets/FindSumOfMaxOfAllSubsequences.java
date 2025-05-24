package com.subsets;

import com.util.BitManipulationHelper;

import java.util.Arrays;

/**
 * Given an array find the sum of max of all subsequences of the array
 */
public class FindSumOfMaxOfAllSubsequences {

    public static void main(String[] args) {
        System.out.println("SUM OF MAX OF ALL SUBSEQUENCES OF ARRAY "+ findSumOfMaxOfAllSubsequencesBruteForce(new int[]{ 3, 1, -4 }));
        System.out.println("SUM OF MAX OF ALL SUBSEQUENCES OF ARRAY OPTIMIZED "+ findSumOfMaxOfAllSubsequencesOptimized(new int[]{ 3, 1, -4 }));
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

    /**
     * USE CONTRIBUTION TECHNIQUE TO FIND ALL SUBSEQUENCES WHERE EACH ELEMENT IS MAXIMUM AND MULTIPLY THAT BY THE
     * ELEMENT AND SUM ALL OF THEM
     * TC = O(NLOGN) FOR SORTING THE ARRAY
     * STEPS:
     * 1) SORT THE ARRAY
     * 2) FIND CONTRIBUTION OF EACH ELEMENT BY COMPUTING NUMBER OF ARRAYS WHERE THE ELEMENT IS MAXIMUM AND MULTIPLY BY
     * THAT ELEMENT AND SUM UP EVERYTHING
     * @param arr
     * @return
     */
    private static int findSumOfMaxOfAllSubsequencesOptimized(int[] arr) {
        Arrays.sort(arr);
        int maxSum = 0, N = arr.length;
        for (int i = 0; i < N; i++) {
            maxSum += (int) (arr[i] * Math.pow(2, i));
        }
        return maxSum;
    }
}
