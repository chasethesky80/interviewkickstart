package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

/**
 * An equillibrium index of array is an index where sum of numbers to left of array equals sum of numbers
 * to the right of the array
 */
public class FindEquillibriumIndexOfArray {

    public static void main(String[] args) {
        System.out.println("EQUILLIBRIUM INDEX OF ARRAY "+ findEquillibriumIndex(Arrays.asList(1, 7, 3, 6, 5, 6)));
    }

    private static Integer findEquillibriumIndex(final List<Integer> input) {
        Integer totalSum = 0;
        for (Integer current: input) {
            totalSum = Integer.sum(totalSum, current);
        }

        Integer leftSum = 0;
        for (int i = 0; i < input.size(); i++) {
            leftSum = i == 0 ? 0 : leftSum + input.get(i-1);
            int rightSum = totalSum - leftSum - input.get(i);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
