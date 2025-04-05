package com.carryforward;

import com.introtoproblemsolving.Pair;

import java.util.List;

public class FindLongestSubArrayWithSumK {

    private static Integer getLongestSubArrayWithSumK(final List<Integer> input, final Integer K) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum = sum + input.get(j);
                if (sum == K) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}
