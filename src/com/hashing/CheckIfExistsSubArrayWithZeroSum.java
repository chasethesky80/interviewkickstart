package com.hashing;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// GIVEN AN ARRAY OF SIZE N, CHECK IF THERE EXISTS A SUBARRAY WITH SUM OF 0 IN THE ARRAY
public class CheckIfExistsSubArrayWithZeroSum {

    public static void main(String[] args) {
        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArray(List.of(2, 2, 1, -3, 4, 3, 1, -2, -3, 2)));
        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArray(List.of(6, 6, 1, -3, 4, 3, 1, -2, -3, 2)));
        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArray(List.of(2, -2)));

        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArrayInASingleLoop(List.of(2, 2, 1, -3, 4, 3, 1, -2, -3, 2)));
        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArrayInASingleLoop(List.of(6, 6, 1, -3, 4, 3, 1, -2, -3, 2)));
        System.out.println("DOES EXIST A ZERO SUM SUBARRAY FOR "+doesExistZeroSumSubArrayInASingleLoop(List.of(2, -2)));
    }

    // TC = O(N) and SC = O(N) FOR PREFIX SUM ARRAY, BUILD A PREFIX SUM ARRAY FOR GIVEN ARRAY AND CHECK IF THERE ARE DUPLICATES IN
    // PF SUM ARRAY SINCE IF A SUB ARRAY SUM IS 0, THEN ITS PF SUM ARRAY WILL HAVE DUPLICATES
    private static boolean doesExistZeroSumSubArray(final List<Integer> input) {
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        final Set<Integer> set = new HashSet<>();
        for (Integer element: prefixSumArray) {
            if (element.compareTo(0) == 0 || !set.add(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * TC = O(N) due to a single for loop and SC = O(N) due to use of hashset
     * @param input
     * @return
     */
    private static boolean doesExistZeroSumSubArrayInASingleLoop(final List<Integer> input) {
        Integer pfSum = 0;
        final Set<Integer> set = new HashSet<>();
        for (Integer element: input) {
            pfSum = Integer.sum(pfSum, element);
            if (pfSum.compareTo(0) == 0 || set.contains(pfSum)) {
                return true;
            }
            set.add(pfSum);
        }
        return false;
    }
}
