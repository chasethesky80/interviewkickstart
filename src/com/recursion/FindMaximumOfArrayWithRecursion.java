package com.recursion;

import java.util.Arrays;
import java.util.List;

public class FindMaximumOfArrayWithRecursion {

    public static void main(String[] args) {
        System.out.println("FIND MAXIMUM OF ARRAY USING "+ getMax(Arrays.asList(12, -3, 4, 17, 8, 9)));
    }
    private static int getMax(List<Integer> A) {
        return getMaxHelper(0, A);
    }

    private static int getMaxHelper(final int index, final List<Integer> input) {
        if (index == input.size() - 1) {
            return input.get(index);
        }
        return Math.max(input.get(index), getMaxHelper(index + 1, input));
    }
}
