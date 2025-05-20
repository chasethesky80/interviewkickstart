package com.subsets;

import com.util.BitManipulationHelper;

/**
 * GIVEN AN ARRAY OF SIZE N WITH DISTINCT ELEMENTS, CHECK IF THERE EXISTS A SUBSET OF SUM K
 */
public class CheckIfExistsSubsetWithSumK {

    public static void main(String[] args) {
        System.out.println("DOES EXIST SUBSET WITH SUM K "+ doesExistSubsetOfSumK(new int[]{ 3, -1, 0, 6, 2, -3, 5}, 10));
        System.out.println("DOES EXIST SUBSET WITH SUM K "+ countNumberOfSubsetsWithSumK(new int[]{ 3, -1, 0, 6, 2, -3, 5}, 10));
    }

    /**
     * Using bit manipulation since an array with size N can produce 2^N subsets
     * @param arr
     * @param k
     * @return
     */
    private static boolean doesExistSubsetOfSumK(int[] arr, int k) {
        int N = arr.length;
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
            if (sum == k) {
                return true;
            }
        }
        return false;
    }

    private static int countNumberOfSubsetsWithSumK(int[] arr, int k) {
        int N = arr.length, count = 0;
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
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}
