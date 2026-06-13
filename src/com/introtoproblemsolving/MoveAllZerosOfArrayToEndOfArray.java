package com.introtoproblemsolving;

import java.util.Arrays;

public class MoveAllZerosOfArrayToEndOfArray {

   public static void main(String[] args) {
       System.out.println("MOVE ZROS TO END "+ Arrays.toString(moveZeros(new int[]{1, 3, 0, 0, 5, 6, 7})));
   }

    private static int[] moveZeros(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        /**
         * If there are no zeros in the array to begin with then just return the original array since
         * there is nothing to do here
         */
        if (j == -1) {
            return arr;
        }
        for (int k = j + 1; k < arr.length; k++) {
            if (arr[k] != 0) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                j++;
            }
        }
        return arr;
    }
}
