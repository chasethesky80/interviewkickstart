package com.introtoarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSumProblemOptimizedSolution {

    public static void main(String[] args) {
        final List<Integer[]> triplets = threeSumProblemOptimized(new Integer[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0);
        System.out.println("FIND ARRAY OF TRIPLETS WHOSE SUM EQUALS TARGET SUM IF NOT RETURN EMPTY ARRAY ");
        triplets.forEach(array -> System.out.println(Arrays.toString(array)));
    }

    // TC = O(N^2) -> (O(N^2) + O(NLOGN) TO SORT THE ARRAY AND SC = O(N) DUE TO THE LIST CREATED TO HOLD THE RESULT (SOLUTION DERIVED FROM ALGO-EXPERT)
    private static List<Integer[]> threeSumProblemOptimized(final Integer[] array, final int targetSum) {
        final List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array); // TC = O(NLOGN)
        for (int i = 0; i <array.length; i++) {
            int right = array.length - 1;
            int current = array[i];
            int left = i+1;
            while (left < right) {
                int sum = current + array[left] + array[right];
                if (sum < targetSum) {
                    left++;
                } else if (sum > targetSum) {
                    right--;
                } else {
                    result.add(new Integer[]{ current, array[left], array[right] });
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
