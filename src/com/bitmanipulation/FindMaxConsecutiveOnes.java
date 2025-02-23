package com.bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println("FIND MAX COUNT OF 1s "+ maxConsecutiveOnes(Arrays.asList(1, 1, 0, 1, 1, 1)));
    }

    private static int maxConsecutiveOnes(final List<Integer> input) {
        int count = 0, maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
