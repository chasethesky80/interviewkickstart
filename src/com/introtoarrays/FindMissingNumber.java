package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of size N and the array contains numbers from 0 to N-1, one number is missing find the number
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        System.out.println("MISSING NUMBER "+ findMissingNumber(Arrays.asList(5, 4, 2, 1)));
        System.out.println("MISSING NUMBER "+ findMissingNumber(Arrays.asList(0, 1, 3, 4)));
        System.out.println("MISSING NUMBER "+ findMissingNumber(Arrays.asList(0, 1, 2, 3, 4)));
        System.out.println("MISSING NUMBER "+ findMissingNumber(Arrays.asList(9, 6, 4, 2, 3, 5, 7, 0, 1)));
    }

    private static Integer findMissingNumber(final List<Integer> input) {
        int N = input.size();
        for (int i = 0; i < input.size(); i++) {
            N = N ^ i ^ input.get(i);
        }
        return N;
    }
}
