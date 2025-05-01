package com.subarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLengthOfLongestSubArrayWithPosAndNegNosAndSumK {

    public static void main(String[] args) {
        System.out.println("LONGEST SUBARRAY WITH SUM USING HASHMAP "+ longestSubArrayWithSumK(Arrays.asList(2, 0, 0, 3), 3));
        System.out.println();
        System.out.println("LONGEST SUBARRAY WITH SUM USING HASHMAP "+ longestSubArrayWithSumK(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0, 0), 5));
        System.out.println();
        System.out.println("LONGEST SUBARRAY WITH SUM USING HASHMAP "+ longestSubArrayWithSumK(Arrays.asList(
                2, 0, 0, 3, 1, 2, 0, 0), 3));
        System.out.println();
        System.out.println("LONGEST SUBARRAY WITH SUM USING HASHMAP "+ longestSubArrayWithSumK(Arrays.asList(
                10, 5, 2, 7, 1, -10), 15));
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
            }
            prefixSumMap.put(sum, i);
        }
        return maxLength;
    }
}
