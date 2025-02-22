package com.subarrays;

import java.util.List;

// GIVEN AN ARRAY OF SIZE N, FIND TOTAL NUMBER OF SUB ARRAYS
public class FindTotalNumberOFSubArraysForArray {

    public static void main(String[] args) {
        System.out.println("NUMBER OF SUBARRAYS FOR ARRAY IS "+ findNumberOfSubArraysForArray(List.of( -1, 2, 4, 5 )));
    }

    // TC = O(1) and SC = O(1)
    private static int findNumberOfSubArraysForArray(final List<Integer> input) {
        int N = input.size();
        return (N * (N+1)) / 2;
    }
}
