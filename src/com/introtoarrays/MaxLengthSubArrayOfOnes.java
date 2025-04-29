package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of 1s & 0s and you are allowed to delete one element then find the maximum length subarray
 * containing only 1s
 */
public class MaxLengthSubArrayOfOnes {

    public static void main(String[] args) {
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                0, 1, 1, 1, 0, 1, 1, 0, 1
        )));
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                1, 1, 1, 1, 1, 1, 1, 0, 1
        )));
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                1, 0
        )));
    }

    private static Integer findMaxLengthSubArrayOfOnes(final List<Integer> input) {
        int i = 0, maxLength = Integer.MIN_VALUE;
        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).compareTo(0) == 0) {
                maxLength = Math.max(maxLength, j-i);
                i=j+1;
            }
        }
        return maxLength;
    }
}
