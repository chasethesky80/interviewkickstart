package com.subarrays;

import java.util.Arrays;
import java.util.List;

public class FindNoOfSubarraysOfSizeKWithTargetSum {

    public static void main(String[] args) {
        System.out.println("FIND NUMBER OF SUBARRAYS WITH SUM OF "+getNoOfSubarraysOfSizeKWithTargetSum(Arrays.asList(3, 7, 5, 8, 2, 10), 3, 15));
        System.out.println("FIND NUMBER OF SUBARRAYS WITH SUM OF "+getNoOfSubarraysOfSizeKWithTargetSum(Arrays.asList(1, 2, 3, 2, 3, 4), 2, 5));
    }

    private static int getNoOfSubarraysOfSizeKWithTargetSum(final List<Integer> input, final int K, final int targetSum) {
        int count = 0, sum = 0;
        for (int i = 0; i < K; i++) {
            sum = sum + input.get(i);
            if (sum == targetSum) {
                count++;
            }
        }
        for (int i = 1; i <= input.size() - K; i++) {
            int j = i + K -1;
            sum = sum - input.get(i-1) + input.get(j);
            if (sum == targetSum) {
                count++;
            }
        }
        return count;
    }
}
