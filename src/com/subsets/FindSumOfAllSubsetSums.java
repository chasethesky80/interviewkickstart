package com.subsets;

import com.util.BitManipulationHelper;

/**
 * GIVEN AN ARRAY OF SIZE N WITH DISTINCT ELEMENTS, RETURN THE SUM OF ALL SUBSET SUMS
 */
public class FindSumOfAllSubsetSums {
    public static void main(String[] args) {
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSums(new int[]{ 3, -1, 0, 6, 2, -3, 5}));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSumsOptimized(new int[]{ 3, -1, 0, 6, 2, -3, 5}));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSumsOptimizedV2(new int[]{ 3, -1, 0, 6, 2, -3, 5}));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSums(new int[]{ -2, 6, 4 }));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSumsOptimized(new int[]{ -2, 6, 4 }));
        System.out.println("SUM OF ALL SUBSET SUMS OF THE ARRAY IS "+ getSumOfAllSubsetSumsOptimizedV2(new int[]{ -2, 6, 4 }));
    }

    /**
     * RETURN SUM OF ALL SUBSET SUMS
     * TC = O(N*2^N) and SC = O(1)
     * @param arr
     * @return
     */
    private static Integer getSumOfAllSubsetSums(int[] arr) {
        int N = arr.length, totalSum = 0;
        for (int i = 0; i < Math.pow(2, N); i++) {
            /**
             * HERE WE ARE COMPUTING THE SUM OF ALL NUMBERS IN THE ARRAY OF SIZE N
             * THAT HAS THE BIT J SET IN WHICH CASE ADD arr[j] TO THE SUM
             */
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (BitManipulationHelper.checkIfBitIsSetInPosition(i, j)) {
                    sum += arr[j];
                }
            }
            totalSum += sum;
        }
        return totalSum;
    }

    /**
     * RETURN SUM OF ALL SUBSET SUMS USING CONTRIBUTION TECHNIQUE BY FINDING ALL SUBSETS WHERE ELEMENT
     * AT INDEX i IS PRESENT AS 2^N-1 (SIMILAR TO SUM OF ALL SUBARRAY SUMS)
     * TC = O(N) and SC = O(1)
     * @param arr
     * @return
     */
    private static Integer getSumOfAllSubsetSumsOptimized(int[] arr) {
        int N = arr.length, sum = 0;
        for (int i = 0; i < arr.length; i++) {
           sum+= (int) (arr[i]*Math.pow(2, N-1));
        }
        return sum;
    }

    private static Integer getSumOfAllSubsetSumsOptimizedV2(int[] arr) {
        int N = arr.length, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i]* (1 << N-1); // SINCE Math.pow(2, N-1) is 1 << N-1 using bit manipulation
        }
        return sum;
    }

}
