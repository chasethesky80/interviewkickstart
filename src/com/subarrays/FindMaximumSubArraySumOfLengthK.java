package com.subarrays;

import com.util.ArrayUtils;

import java.util.List;

public class FindMaximumSubArraySumOfLengthK {

    public static void main(String[] args) {
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K BRUTE FORCE " + getMaxSubArraySumOfSizeKForArrayBruteForce(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
        System.out.println();
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K CARRY FORWARD " + getMaxSubArraySumOfSizeKForArrayWithCarryForward(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
        System.out.println();
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH PREFIX SUM TECHNIQUE " + getMaxSubArraySumOfSizeKForArrayOptimizedWithPrefixSumArray(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
        System.out.println();
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH SLIDING WINDOW TECHNIQUE " + getMaxSubArraySumOfSizeKForArrayOptimizedWithSlidingWindowTechnique(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
        System.out.println();
        System.out.println("MAX SUB-ARRAY SUM OF LENGTH K OPTIMIZED WITH SLIDING WINDOW TECHNIQUE " + getMaxSubArraySumOfSizeKForArrayOptimizedWithSlidingWindowTechnique(List.of(3, -2, 4, -1, 2, 6), 3));
    }

    // TC = O((N-K+1) * K) DUE TO N-K+1 SUB-ARRAYS AND EACH SUB-ARRAY OF SIZE K AND SC = O(1) DUE TO NO EXTRA SPACE USED
    // 1) WHEN K = 1, THE SUB-ARRAY IS EACH ELEMENT IN THE ENTIRE ARRAY, SO ITS MAX OF ALL ELEMENTS OF ARRAY AND TC = O(N)
    // 2) WHEN K = N, THE SUB-ARRAY IS THE ENTIRE ARRAY, SO ITS THE SUM OF ALL ELEMENTS OF ARRAY, RUN JUST ONE LOOP AND FIND SUM AND TC = O(N)
    // 3) WHEN K = N/2, ITS O(N^2)
    private static int getMaxSubArraySumOfSizeKForArrayBruteForce(final List<Integer> input, final Integer K) {
        int N = input.size();
        int maxSum = Integer.MIN_VALUE;
        for (int i =0; i <= N - K; i++) {
            int j = i + K;
            int sum = 0;
            for (int e = i; e < j; e++) {
                sum = sum + input.get(e);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // TC = O((N-K+1) * K) DUE TO N-K+1 SUB-ARRAYS AND EACH SUB-ARRAY OF SIZE K AND SC = O(1) DUE TO NO EXTRA SPACE USED
    private static int getMaxSubArraySumOfSizeKForArrayWithCarryForward(final List<Integer> input, final Integer K) {
        int N = input.size();
        int maxSum = Integer.MIN_VALUE;
        for (int i =0; i <= N - K; i++) {
            int j = i + K;
            int sum = 0;
            for (int e = i; e < j; e++) {
                sum = sum + input.get(e);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    // TC = O(N-K) AND SC = O(N) DUE TO EXTRA PREFIX SUM ARRAY USED
    private static int getMaxSubArraySumOfSizeKForArrayOptimizedWithPrefixSumArray(final List<Integer> input, final Integer K) {
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        int N = input.size();
        int maxSum = Integer.MIN_VALUE;
        for (int i =0; i <= N - K; i++) {
            int j = i + K-1;
            maxSum = Math.max(maxSum, i == 0 ? prefixSumArray.get(j) : prefixSumArray.get(j) - prefixSumArray.get(i-1));
        }
        return maxSum;
    }

    // TC = O(N) DUE TO JUST ONE FOR LOOP AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static int getMaxSubArraySumOfSizeKForArrayOptimizedWithSlidingWindowTechnique(final List<Integer> input, final Integer K) {
        int sum = 0;
        for (int i=0; i < K; i++) {
            sum = sum + input.get(i);
        }
        int maxSum = sum;
        int N = input.size();
        for (int i =1; i <= N - K; i++) {
            int j = i + K-1;
            sum = sum-input.get(i-1) + input.get(j);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
