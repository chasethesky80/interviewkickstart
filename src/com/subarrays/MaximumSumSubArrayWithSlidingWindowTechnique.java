package com.subarrays;

import java.util.List;

 public class MaximumSumSubArrayWithSlidingWindowTechnique {

        public static void main(String[] args) {
            System.out.println("MAX SUB-ARRAY SUM OF LENGTH K BRUTE FORCE " + getMaximumSumSubArrayWidthSlidingWindow(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
            System.out.println("MAX SUB-ARRAY SUM OF LENGTH K BRUTE FORCE " + getMaximumSumSubArrayWidthSlidingWindowAlternativeSolution(List.of( -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 ), 5));
            System.out.println("MAX SUB-ARRAY SUM OF LENGTH K BRUTE FORCE " + maximumSubarraySum(new int[]{ -3, 4, -2, 5, 3, -2, 8, 2, -1, 4 }, 5));
        }

        private static int getMaximumSumSubArrayWidthSlidingWindow(final List<Integer> input, final int K) {
            int maxSum = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < K; i++) {
                sum = sum + input.get(i);
            }

            for (int i = 1; i <= input.size() - K; i++) {
                int j = K + i - 1;
                sum = sum - input.get(i-1) + input.get(j);
                maxSum = Math.max(maxSum, sum);
            }
            return maxSum;
        }

         private static Integer getMaximumSumSubArrayWidthSlidingWindowAlternativeSolution(final List<Integer> arr, int K) {
             int maxSum = Integer.MIN_VALUE, sum = 0, N = arr.size();
             int end;
             int start = 0;
             for (end = 0; end < K; end++) {
                 sum += arr.get(end);
             }
             maxSum = sum;
             while (end <  N) {
                 sum = sum + arr.get(end) - arr.get(start);
                 end++;
                 start++;
                 maxSum = Math.max(maxSum, sum);
             }
             return maxSum;
         }

         private static long maximumSubarraySum(int[] nums, int k) {
             int st = 0, end = 0, N = nums.length, maxSum = Integer.MIN_VALUE, sum = 0;
             while (end < k) {
                 sum = sum + nums[end];
                 end++;
             }
             maxSum = sum;
             while (end < N) {
                 sum = sum + nums[end];
                 sum = sum - nums[st];
                 maxSum = Math.max(maxSum, sum);
                 st++;
                 end++;
             }
             return maxSum;
         }
}
