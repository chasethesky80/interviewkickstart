package com.introtoproblemsolving;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * FIND THE MISSING NUMBER IS AN ARITHMETIC PROGRESSION OF ARRAY OF NUMBERS
 * AN ARITHMETIC PROGRESSION CAN BE EXPRESSED AS : [a, a + d, a + 2d, a + 3d, a+ 4d.....etc]
 */
public class GivenAnArrayAsAnAPFindMissingNumber {

    public static void main(String[] args) {
        System.out.println("FIND MISSING NUMBER IN ARITHMETIC PROGRESSION "+ findMissingNumberinArithmeticProgression(
                Arrays.asList(2, 4, 8, 10, 12)));
    }
    private static int findMissingNumberinArithmeticProgression(final List<Integer> input) {
        /**
         * FIND THE MINIMUM OF ALL DIFFERENCES FOR EG IN ABOVE INPUT MIN OF [2, 4, 2, 2], HERE WE ARE FINDING THE 'd'
         * IN THE ARITHMETIC PROGRESSION
         */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.size()-1; i++) {
            int difference = input.get(i+1) - input.get(i);
            if (difference < min) {
                min = difference;
            }
        }

        /**
         * THEN USE THE 'd' TO FIND TNE NUMBER THAT DOES NOT FIT IN ITS INDEX IN THE ARRAY
         */
        for (int i = 0; i < input.size(); i++) {
            int expected = input.get(0) + i*min;
            if (expected != input.get(i)) {
                return expected;
            }
        }
        return -1;
    }
}
