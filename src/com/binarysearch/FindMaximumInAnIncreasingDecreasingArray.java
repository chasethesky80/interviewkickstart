package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindMaximumInAnIncreasingDecreasingArray {

    public static void main(String[] args) {
        System.out.println("FIND MAXIMUM IN A INCREASING DECREASING ARRAY "+ findMaximumInIncreasingDecreasingArray(Arrays.asList(1, 3, 5, 10, 15, 12, 6)));
        System.out.println("FIND MAXIMUM IN A INCREASING DECREASING ARRAY "+ findMaximumInIncreasingDecreasingArray(Arrays.asList(1, 2, 17, 15, 12, 10, 6)));
        System.out.println("FIND MAXIMUM IN A INCREASING DECREASING ARRAY "+ findMaximumInIncreasingDecreasingArray(Arrays.asList(18, 15, 13, 12, 10, 9, 6)));
        System.out.println("FIND MAXIMUM IN A INCREASING DECREASING ARRAY "+ findMaximumInIncreasingDecreasingArray(Arrays.asList(6, 8, 9, 10, 12, 14, 20)));
    }

    private static Integer findMaximumInIncreasingDecreasingArray(final List<Integer> input) {
        int l = 0, r = input.size() - 1;
        while (l <= r) {
            int middle = l + (r-l)/2;
            if ((middle == 0 || input.get(middle-1).compareTo(input.get(middle)) < 0) &&
                (middle == input.size() - 1 || input.get(middle).compareTo(input.get(middle + 1)) > 0)) {
                return input.get(middle);
            }
            if (middle != 0 && input.get(middle).compareTo(input.get(middle-1)) > 0) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }
}
