package com.subarrays;

// Subarrays with Bitwise OR 1

import java.util.Arrays;
import java.util.List;

/**
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
 * Note : The answer can be large. So, return type must be long.
 */
public class SubArraysWithBitwiseORAs1 {

    public static void main(String[] args) {
        System.out.println("FIND NUMBER OF SUBARRAYS WITH BITWISE OR AS 1 = "+ getNumberOfSubArraysWithBitwise0RAs1(
                Arrays.asList(0, 0, 1, 1, 0, 0)));
        System.out.println("FIND NUMBER OF SUBARRAYS WITH BITWISE OR AS 1 = "+ getNumberOfSubArraysWithBitwise0RAs1AlternativeSolution(
                Arrays.asList(0, 0, 1, 1, 0, 0)));
    }
    private static long getNumberOfSubArraysWithBitwise0RAs1(final List<Integer> A) {
        /** NOTE: PLEASE REFER INTERMEDIATE DSA - PROBLEM SOLVING SESSION 1 FROM SANDEEP MAHAPATRA LECTURES FOR SOLUTION AS FOLLOWS:
         * CHECK IF AN ELEMENT AT AN INDEX OF THE ARRAY CONTAINS 1 AND I YES THEN THE NUMBER OF SUBARRAYS WHERE THE ELEMENT
        / WILL PARTICIPATE TILL INDEX I IS :- i + 1, TC = O(N) AND SC = CONSTANT
         */
        int count = 0, last = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).compareTo(1) == 0) {
                last = i+1;
            }
            count = count + last;
        }
        return count;
    }

    private static long getNumberOfSubArraysWithBitwise0RAs1AlternativeSolution(final List<Integer> B) {
        int N = B.size();
        return (long) N *(N+1)/2 - getNumberOfSubArraysWithAllZeros(B);
    }

    private static long getNumberOfSubArraysWithAllZeros(List<Integer> B) {
        long count = 0L, zeros = 0L;
        for (Integer element: B) {
            if (element.compareTo(0) == 0) {
                zeros = zeros + 1;
            } else {
                count = count + (zeros * (zeros + 1)) / 2;
                zeros = 0;
            }
        }
        count = count + (zeros * (zeros + 1)) / 2;
        return count;
    }
}
