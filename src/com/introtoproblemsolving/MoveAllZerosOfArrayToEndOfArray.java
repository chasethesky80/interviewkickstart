package com.introtoproblemsolving;

import java.util.Arrays;

public class MoveAllZerosOfArrayToEndOfArray {

   public static void main(String[] args) {
       System.out.println("MOVE ZROS TO END "+ Arrays.toString(moveZeros(new int[]{1, 3, 0, 0})));
   }

    private static int[] moveZeros(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
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
