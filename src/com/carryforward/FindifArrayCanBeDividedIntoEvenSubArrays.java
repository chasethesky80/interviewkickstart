package com.carryforward;

import java.util.List;

/***
 * You are given an integer array A.
 * Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
 * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
 */
public class FindifArrayCanBeDividedIntoEvenSubArrays {

    public static void main(String[] args) {
        System.out.println("CAN ARRAY BE DIVIDED INTO EVEN SUB-ARRAYS "+ findIfArrayCanBeDividedIntoEvenSubArrays(List.of( 2, 4, 6, 8 )));
        System.out.println("CAN ARRAY BE DIVIDED INTO EVEN SUB-ARRAYS "+ findIfArrayCanBeDividedIntoEvenSubArrays(List.of( 2, 4, 5, 6, 8 )));
        System.out.println("CAN ARRAY BE DIVIDED INTO EVEN SUB-ARRAYS "+ findIfArrayCanBeDividedIntoEvenSubArrays(List.of( 13, 2, 4, 5, 6, 8 )));
        System.out.println("CAN ARRAY BE DIVIDED INTO EVEN SUB-ARRAYS "+ findIfArrayCanBeDividedIntoEvenSubArrays(List.of( 12, 4, 5, 6, 8, 7 )));
    }

    // TC = O(N) DUE TO SIMPLE FOR LOOP AND SC = O(N) SINCE NO EXTRA SPACE
    private static boolean findIfArrayCanBeDividedIntoEvenSubArrays(final List<Integer> input) {
        int A = input.size();
        return A % 2 == 0 && input.get(0) % 2 == 0 && input.get(A-1) % 2 == 0;
    }
}
