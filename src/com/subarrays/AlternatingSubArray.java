package com.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
 * You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
 * A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's.
 * For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
 */
public class AlternatingSubArray {

    public static void main(String[] args) {
        System.out.println("IS ALTERNATING SUBARRAY "+ solve(Arrays.asList(0, 1, 0, 1), 1));
        System.out.println("IS ALTERNATING SUBARRAY "+ solve(Arrays.asList(0, 1, 0, 1, 0, 1), 2));
    }

    private static ArrayList<Integer> solve(List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int lastStart = A.size() - 1 - 2*B;
        for (int i=0; i <= lastStart; i++) {
            int j = 2*B + i;
            if (j>=A.size()) {
                break;
            }
            if(isAlternatingArray(A, i, j)) {
                result.add((int)(i + (j-i)/2));
            }
        }
        return result;
    }
    private static boolean isAlternatingArray(List<Integer> A, int i, int j) {
        for (int s=i; s<j; s++) {
            if((A.get(s) == 1 && A.get(s+1) == 1) || (A.get(s) == 0 && A.get(s+1) == 0)) {
                return false;
            }
        }
        return true;
    }
}
