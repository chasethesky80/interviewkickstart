package com.sorting;

import java.util.Arrays;
import java.util.List;

// GIVEN AN ARRAY OF N INTEGERS, COUNT NUMBER OF NOBLE INTEGERS PRESENT IN ARRAY. FOR ANY INDEX i, A[i] IS A NOBLE INTEGER IF
// NUMBER IF ARRAY ELEMENTS < A[i] == A[i]
public class FindNobleIntegersInArray {

    public static void main(String[] args) {
        System.out.println("FIND NOBLE INTEGER COUNT FOR ARRAY "+findNobleIntegersInArray(new int[]{ -1, 1, 1, 2, 3, 4, 4, 4 }));
        System.out.println("FIND NOBLE INTEGER COUNT FOR ARRAY "+findNobleIntegersInArray(new int[]{ 1, 4, 4, 4, 4 }));
    }

    // TC = O(NLOGN) FOR SORTING THE ARRAY AND O(N) FOR COMPARING VALUES BETWEEN THE 2 ARRAYS, SO TOTAL TC = O(NLOGN)
    // SC = O(N) FOR THE EXTRA ARRAY
    private static int findNobleIntegersInArray(int[] input) {
        Arrays.sort(input);
        int[] numLesserElementsArray = new int[input.length];
        numLesserElementsArray[0] = 0;
        for (int i =1; i < input.length; i++) {
            if (input[i] != input[i-1]) {
                numLesserElementsArray[i] = i;
            } else {
                numLesserElementsArray[i] = numLesserElementsArray[i-1];
            }
        }
        int nobleIntegerCount = 0;
        for (int i =0; i < numLesserElementsArray.length; i++) {
            if (numLesserElementsArray[i] == input[i]) {
                nobleIntegerCount++;
            }
        }
        return nobleIntegerCount;
    }
}
