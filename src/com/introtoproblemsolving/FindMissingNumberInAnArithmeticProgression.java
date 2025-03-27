package com.introtoproblemsolving;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array representing an arithmetic progression find the missing number where the AP can be represented as follows:
 * a, a + d, a + 2d, a + 3d etc
 */
public class FindMissingNumberInAnArithmeticProgression {

    public static void main(String[] args) {
        System.out.println("FIND THE MISSING NUMBER IN THE ARRAY "+ findMissingNumberInAnAP(Arrays.asList(2, 4, 8, 10, 12)));
        System.out.println("FIND THE MISSING NUMBER IN THE ARRAY "+ findMissingNumberInAnAP(Arrays.asList(3, 6, 9, 15, 18)));
    }

    private static Integer findMissingNumberInAnAP(final List<Integer> input) {
        int difference = Integer.MAX_VALUE;
        for (int i = 1; i < input.size(); i++) {
            difference = Math.min(difference, input.get(i) - input.get(i-1));
        }
        for (int i = 0; i < input.size(); i++) {
            int expected = input.get(0) + i * difference;
            if (expected != input.get(i)) {
                return expected;
            }
        }
        return -1;
    }
}
