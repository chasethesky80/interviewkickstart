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
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnesAlternateSoln(Arrays.asList(
                0, 1, 1, 1, 0, 1, 1, 0, 1
        )));
        System.out.println();
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                1, 1, 1, 1, 1, 1, 1, 0, 1
        )));
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnesAlternateSoln(Arrays.asList(
                1, 1, 1, 1, 1, 1, 1, 0, 1
        )));
        System.out.println();
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                1, 1, 0, 1
        )));
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnesAlternateSoln(Arrays.asList(
                1, 1, 0, 1
        )));
        System.out.println();
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnes(Arrays.asList(
                0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1
        )));
        System.out.println("FIND MAXIMUM LENGTH SUBARRAY CONTAINING ONLY 1s IS "+ findMaxLengthSubArrayOfOnesAlternateSoln(Arrays.asList(
                0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1
        )));
    }

    private static Integer findMaxLengthSubArrayOfOnes(final List<Integer> input) {
        int totalCount = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i)== 1) {
                continue;
            }
            int leftCount = 0;
            for (int j = i-1; j >=0; j--) {
                if (input.get(j) == 1) {
                    leftCount++;
                } else {
                    break;
                }
            }
            int rightCount = 0;
            for (int k = i+1; k < input.size(); k++) {
                if (input.get(k) == 1) {
                    rightCount++;
                } else {
                    break;
                }
            }
            totalCount = Math.max(totalCount, leftCount + rightCount);
        }
        return totalCount;
    }

    private static Integer findMaxLengthSubArrayOfOnesAlternateSoln(final List<Integer> input) {
        int start = 0, maxLength = 0, zeroCount = 0;
        for (int end = 0; end < input.size(); end++) {
            if (input.get(end).compareTo(0) == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (input.get(start).compareTo(0) == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start);
        }
        return maxLength;
    }
}
