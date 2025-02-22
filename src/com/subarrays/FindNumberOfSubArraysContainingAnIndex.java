package com.subarrays;

import java.util.List;

// GIVEN AN ARRAY OF SIZE N, FIND NUMBER OF SUB-ARRAYS CONTAINING INDEX I
public class FindNumberOfSubArraysContainingAnIndex {



    // TC IS O(1) AND SC = O(1)
    private static int findNumberOfSubarraysContainingAnIndexI(final List<Integer> input, final Integer i) {
        // FOR THE NUMBER OF SUB-ARRAYS CONTAINING INDEX i, THE STARTING INDEX OF SUB-ARRAY CONTAINING INDEX i IS <= i AND
        // ENDING INDEX OF SUB-ARRAY CONTAINING INDEX i >= i
        // SO START INDEX OF SUB-ARRAY IS IN RANGE [0...i] AND ENDING INDEX OF SUB-ARRAY IS IN RANGE [i...N-1] WHERE N IS SIZE OF ARRAY
        // SO NUMBER OF SUB-ARRAYS IS (i+1)*(N-i)
        int N = input.size();
        return (i+1) * (N-i);
    }
}
