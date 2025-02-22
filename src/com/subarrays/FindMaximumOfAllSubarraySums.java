package com.subarrays;

import java.util.Arrays;
import java.util.List;

// GIVEN AN ARRAY OF SIZE N, FIND MAXIMUM OF ALL SUBARRAY SUMS
public class FindMaximumOfAllSubarraySums {

    public static void main(String[] args) {
        System.out.println("MAX OF ALL SUBARRAY SUMS USING CARRY FORWARD TECHNIQUE "+ findMaximumOfAllSubarraySumsOptimizedUsingCarryForward(
                List.of( 7, 3, 2, -1, 6, 8, 2, 3 )));
        System.out.println("DOES CONTAIN SUBARRAY WITH SUM ZERO "+ findIfExistsSubArrayWithSumZeroWithCarryForwardTechnique(
                Arrays.asList(2, 2, 1, -3, 4, 3, 1, -2, -3, 2)));
        System.out.println("DOES CONTAIN SUBARRAY WITH SUM ZERO "+ findIfExistsSubArrayWithSumZeroWithCarryForwardTechnique(
                Arrays.asList(2, 3, 1, -3, 4, 3, 1, -2, -3, 2)));
    }

    // TC = O(N^2) and SC = O(1) due to no extra space needed
    private static int findMaximumOfAllSubarraySumsOptimizedUsingCarryForward(final List<Integer> input) {
        int N = input.size();
        int maxSubArraySum = Integer.MIN_VALUE;
        for (int i =0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum = sum + input.get(j);
                maxSubArraySum = Math.max(maxSubArraySum, sum);
            }
        }
        return maxSubArraySum;
    }

    /**
     * TC = O(N^2) and SC = O(1)
     * @param input
     * @return
     */
    private static boolean findIfExistsSubArrayWithSumZeroWithCarryForwardTechnique(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum = sum + input.get(j);
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
