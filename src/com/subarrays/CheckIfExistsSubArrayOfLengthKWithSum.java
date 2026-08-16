package com.subarrays;

import java.util.Arrays;
import java.util.List;

public class CheckIfExistsSubArrayOfLengthKWithSum {

    public static void main(String[] args) {
        System.out.println("CHECK IF SUBARRAY EXISTS WITH SIZE K AND TARGET SUM "+ checkIfSubarrayExists(Arrays.asList(2, 3, 1, 2, 4, 3), 3,
                7));
        System.out.println("CHECK IF SUBARRAY EXISTS WITH SIZE K AND TARGET SUM "+ checkIfSubarrayExistsAlternativeApproach(Arrays.asList(2, 3, 1, 2, 4, 3), 3, 7));
    }

    private static boolean checkIfSubarrayExists(final List<Integer> input, final int K, final int targetSum) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum = sum + input.get(i);
        }
        if (sum == targetSum) {
            return true;
        }
        for (int i = 1; i <= input.size() - K; i++) {
            int j = K + i - 1;
            sum = sum - input.get(i-1) + input.get(j);
            if (sum == targetSum) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfSubarrayExistsAlternativeApproach(final List<Integer> input, final int K, final int targetSum) {
        int sum = 0, i = 0;
        for (; i < K; i++) {
            sum = sum + input.get(i);
        }
        if (sum == targetSum) {
            return true;
        }
        int st = 0;
        while (i < input.size()) {
            sum = sum + input.get(i) - input.get(st);
            if (sum == targetSum) {
                return true;
            }
            i++;
            st++;
        }
        return false;
    }
}
