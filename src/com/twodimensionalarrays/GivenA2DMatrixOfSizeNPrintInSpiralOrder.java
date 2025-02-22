package com.twodimensionalarrays;

import java.util.ArrayList;
import java.util.Arrays;

// GIVEN A 2D MATRIX OF SIZE N, TRAVERSE THE MATRIX IN SPIRAL ORDER AND PRINT ITS ELEMENTS
public class GivenA2DMatrixOfSizeNPrintInSpiralOrder {

    public static void main(String[] args) {
        System.out.println("GENERATED 2D MATRIX IN SPIRAL ORDER FOR MATRIX OF SIZE A WHERE A IS "+ printMatrixInSpiralOrder(5));
    }

    // TC = O(A*A) SINCE WE ARE POPULATING ALL CELLS IN THE 2D MATRIX AND SC = O(1) SINCE NO EXTRA SPACE USED
    // NOTE: THE LIST OF LISTS CREATED IN THE SOLUTION IS NOT CONSIDERED EXTRA SPACE
    /** CREATING AND INITIALIZING A 2D MATRIX WITH 0s SINCE THIS SOLUTION WORKS MUCH BETTER WITH ARRAYS THAN ARRAYLIST
     BUILD THE 2D ARRAY MATRIX FIRST SINCE THE SOLUTION WORKS MUCH BETTER WITH 2D ARRAYS AND THEN CONVERT THAT 2D
     MATRIX TO A LIST OF LISTS **/
    private static ArrayList<ArrayList<Integer>> printMatrixInSpiralOrder(Integer A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Integer[][] matrix = new Integer[A][A];
        for (Integer[] row: matrix) {
            Arrays.fill(row, 0);
        }
        int k =1, row = 0, column = 0;
        while (A > 1) {
            for (int i = 1; i < A; i++) {
                matrix[row][column] = k;
                k++;
                column++;
            }
            for (int i = 1; i < A; i++) {
                matrix[row][column] = k;
                k++;
                row++;
            }
            for (int i = 1; i < A; i++) {
                matrix[row][column] = k;
                k++;
                column--;
            }
            for (int i = 1; i < A; i++) {
                matrix[row][column] = k;
                k++;
                row--;
            }
            row++;
            column++;
            A = A-2;
        }
        if (A == 1) {
            matrix[row][column] = k;
        }
        // NOW CONVERTING THE 2D MATRIX ARRAY TO LIST OF LISTS
        for (Integer[] current: matrix) {
            result.add(new ArrayList<>(Arrays.asList(current)));
        }
        return result;
    }
}

