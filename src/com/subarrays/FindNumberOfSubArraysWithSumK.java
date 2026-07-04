package com.subarrays;

public class FindNumberOfSubArraysWithSumK {

    public static void main(String[] args) {
        System.out.println("NUMBER OF SUBARRAYS WITH SUM K "+ numOfSubArraysWithSumKWithSlidingWindowTechnique(new int[]{ 1, 2, 3 }, 3));
        System.out.println("NUMBER OF SUBARRAYS WITH SUM K "+ numOfSubArraysWithSumKWithSlidingWindowTechnique(new int[]{ 1, 1, 1 }, 2));
    }

    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to K
     * The subarrays can be of any size just that their sum should be K
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * NOTE: USES 2 POINTER / SLIDING WINDOW TECHNIQUE
     */
    private static int numOfSubArraysWithSumKWithSlidingWindowTechnique(int[] arr, int K) {
        int st = 0, end = 0, sum = 0, ans = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum > K && st < end) {
                sum -= arr[st];
                st++;
            }
            if (sum == K) {
                ans++;
            }
            end++;
        }
        return ans;
    }
}
