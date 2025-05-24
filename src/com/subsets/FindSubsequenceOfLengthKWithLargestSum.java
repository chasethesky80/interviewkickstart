package com.subsets;

import java.util.Arrays;

/**
 * Given an array return the subsequence of length K with largest sum
 */
public class FindSubsequenceOfLengthKWithLargestSum {

    public static void main(String[] args) {
        System.out.println("SUBSEQUENCE OF LENGTH K WITH LARGEST SUM "+ Arrays.toString(findSubsequence(new int[]{2, 1, 3, 3}, 2)));
    }

    private static int[] findSubsequence(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE, N = nums.length;
        int[] result = new int[k];
        for (int i = 0; i < Math.pow(2, N); i++) {
            int sum = 0, index = 0;
            int[] temp = new int[k];
            for (int j = 0; j < N; j++) {
                if (isCheckBit(i, j) && index < k) {
                    temp[index] = nums[j];
                    sum = sum + nums[j];
                    index++;
                    if (index == k && sum > maxSum) {
                        maxSum = sum;
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isCheckBit(int N, int j) {
        return ((N >> j) & 1) == 1;
    }
}
