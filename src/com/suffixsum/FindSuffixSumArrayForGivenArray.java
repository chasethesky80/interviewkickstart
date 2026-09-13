package com.suffixsum;

import java.util.Arrays;

public class FindSuffixSumArrayForGivenArray {

    public static void main(String[] args) {
        System.out.println("SUFFIX SUM ARRAY FOR ARRAY "+ Arrays.toString(buildSuffixSumArray(new int[]{10, 2, 6, 7, 8, 9, 11})));
    }


    private static int[] buildSuffixSumArray(int[] array) {
        int N = array.length;
        int[] suffixSumArray = new int[array.length];
        suffixSumArray[N - 1] = array[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            suffixSumArray[i] = array[i] + suffixSumArray[i + 1];
        }
        return suffixSumArray;
    }
}
