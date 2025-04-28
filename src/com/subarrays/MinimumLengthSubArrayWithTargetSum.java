package com.subarrays;

import java.util.Arrays;
import java.util.List;

/**
 * Find minimum length subarray whose sum equals target sum
 */
public class MinimumLengthSubArrayWithTargetSum {

    public static void main(String[] args) {
        System.out.println("MINIMUM LENGTH SUBARRAY WITH SUM EQUALS TARGET SUM "+ minimumLengthSubArray(Arrays.asList(
                2, 3, 1, 2, 4, 3), 7));
    }

    /**
     * USING 2 POINTER APPROACH AND SLIDING WINDOW APPROACH COMBINATION
     * @param input
     * @param K
     * @return
     */
    private static Integer minimumLengthSubArray(final List<Integer> input, int K) {
        int left = 0, sum = 0, minimumLength = Integer.MAX_VALUE;
        for (int right = 0; right < input.size(); right++) {
            sum = sum + input.get(right);

            while (left <= right && sum > K) {
                sum = sum - input.get(left);
                left++;
            }

            if (sum == K) {
                minimumLength = Math.min(minimumLength, right-left+1);
            }
        }
        return minimumLength;
    }
}
