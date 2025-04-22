package com.subarrays;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class FindSumOfAllOddLengthSubArrays {

    public static void main(String[] args) {
        System.out.println("SUM OF ODD LENGTH SUBARRAYS " + sumOfAllOddLengthSubArrays(Arrays.asList(1, 4, 2, 5, 3)));
    }

    private static Integer sumOfAllOddLengthSubArrays(final List<Integer> input) {
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                int length = j-i + 1;
                if (length % 2 == 1) {
                    sum = sum + (i == 0 ? prefixSumArray.get(j) : prefixSumArray.get(j) - prefixSumArray.get(i-1));
                }
            }
        }
        return sum;
    }
}
