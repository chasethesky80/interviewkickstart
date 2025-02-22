package com.arraysandmath;

import java.util.Arrays;

// Given an array of size N, find if there exists an element whose frequency in the array > N/2 and return it as the majority element
// else return -1. NOTE: The constraint is no extra space is allowed and the solution should be implemented in-place
public class FindMajorityElementsFreqGreaterThanSizeBy3 {

    public static void main(String[] args) {
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+ Arrays.toString(findMajorityElementsOptimized(new int[]{3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3})));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+ Arrays.toString(findMajorityElementsOptimized(new int[]{1, 6, 1, 1, 2, 1})));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+ Arrays.toString(findMajorityElementsOptimized(new int[]{3, 3, 3, 2, 4, 4})));
    }


    // OPTIMIZED SOLUTION USES - TWEAK MOORE'S VOTING ALGORITHM: TC = O(N) BUT INSTEAD 2 MAJORITY ELEMENTS CAN EXIST
    // SINCE CONDITION OF MAJORITY ELEMENT IS THAT FREQUENCY > N/3 WHERE N IS LENGTH OF ARRAY
    private static int[] findMajorityElementsOptimized(int[] input) {
        return new int[]{};
    }
}
