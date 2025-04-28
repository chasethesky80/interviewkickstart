package com.subarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLengthOfLongestSubArrayWithSumK {

    public static void main(String[] args) {
        System.out.println("LONGEST SUBARRAY WITH SUM "+ longestSubArrayWithSumK(Arrays.asList(2, 0, 0, 3), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER APPROACH "+ longestSubArrayWithSumKTwoPointerApproach(Arrays.asList(
                2, 0, 0, 3), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER ALTERNATE APPROACH "+ longestSubArrayWithSumKTwoPointerAlternateApproach(Arrays.asList(
                2, 0, 0, 3), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER APPROACH "+ longestSubArrayWithSumKTwoPointerApproach(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0, 0), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER ALTERATE APPROACH "+ longestSubArrayWithSumKTwoPointerAlternateApproach(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0, 0), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER APPROACH "+ longestSubArrayWithSumKTwoPointerApproach(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0), 3));
        System.out.println("LONGEST SUBARRAY WITH SUM USING 2 POINTER ALTERNATE APPROACH "+ longestSubArrayWithSumKTwoPointerAlternateApproach(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0), 3));
    }

    private static Integer longestSubArrayWithSumK(final List<Integer> input, final Integer K) {
        int maxLength = Integer.MIN_VALUE, sum = 0;
        final Map<Integer, Integer> prefixSumMap = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            sum = sum + input.get(i);
            if (sum == K) {
                maxLength = Math.max(maxLength, i+1);
            } else {
                int difference = sum - K;
                if (prefixSumMap.containsKey(difference)) {
                    maxLength = Math.max(maxLength, i - prefixSumMap.get(difference));
                }
                if (!prefixSumMap.containsKey(sum)) {
                    prefixSumMap.put(sum, i);
                }
            }
        }
        return maxLength;
    }

    /**
     * 2 POINTER APPROACH IF THE SUBARRAY ONLY CONTAINS POSITIVES AND ZEROS USES SLIDING WINDOW CONCEPT
     */
    private static Integer longestSubArrayWithSumKTwoPointerApproach(final List<Integer> input, final Integer K) {
        int i = 0, j = 0, sum = input.get(0), maxLength = Integer.MIN_VALUE;
        while (j < input.size()) {
            if (sum == K) {
                maxLength = Math.max(maxLength, j-i + 1);
                j++;
                if (j < input.size()) {
                    sum = sum + input.get(j);
                }
            } else if (sum < K) {
                j++;
                if (j < input.size()) {
                    sum = sum + input.get(j);
                }
            } else {
                sum = sum - input.get(i);
                i++;
            }
        }
        return maxLength;
    }

    /**
     * 2 POINTER APPROACH USES SLIDING WINDOW CONCEPT
     * @param input
     * @param K
     * @return
     */
    private static Integer longestSubArrayWithSumKTwoPointerAlternateApproach(final List<Integer> input, final Integer K) {
        int left = 0, sum = 0, maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < input.size(); right++) {
            sum = sum + input.get(right);
            while (sum > K && left <= right) {
                sum = sum - input.get(left);
                left++;
            }
            if (sum == K) {
                maxLength = Math.max(maxLength, right-left+1);
            }
        }
        return maxLength;
    }
}
