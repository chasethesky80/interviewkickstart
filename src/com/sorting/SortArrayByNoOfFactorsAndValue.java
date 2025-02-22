package com.sorting;

import com.util.NumberUtils;

import java.util.Arrays;

// GIVEN AN ARRAY, SORT THE NUMBERS IN ASCENDING ORDER BY NUMBER OF FACTORS AND IF NUMBER OF FACTORS ARE EQUAL THEN SORT BY VALUE
public class SortArrayByNoOfFactorsAndValue {

    public static void main(String[] args) {
        System.out.println("SORT THE NUMBERS BY NUMBER OF FACTORS AND THEN BY VALUE "+ Arrays.toString(sortByNoOfFactorsAndValue(
                new Integer[]{10, 4, 6, 9, 3})));
    }

    private static Integer[] sortByNoOfFactorsAndValue(Integer[] input) {
        Arrays.sort(input, (a1, a2) -> {
            int f1 = NumberUtils.numberOfFactors(a1); // NEED TO IMPLEMENT THE - NumberUtils.numberOfFactors method STILL
            int f2 = NumberUtils.numberOfFactors(a2);
            if (f1 < f2) {
                return 1;
            } else if (f1 == f2) {
                return a2.compareTo(a1);
            }
            return -1;
        });
        return input;
    }
}
