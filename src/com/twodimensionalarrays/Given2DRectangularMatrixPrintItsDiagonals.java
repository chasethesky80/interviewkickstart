package com.twodimensionalarrays;

import java.util.List;

// GIVEN A 2D RECTANGULAR MATRIX, PRINT ITS DIAGONAL CELLS
public class Given2DRectangularMatrixPrintItsDiagonals {

    public static void main(String[] args) {
        System.out.println("MAX COLUMN SUM IS ");
        printDiagonalsOf2DRectMatrix(List.of(List.of( 3, 8, 9, 2 ), List.of( 1, 2, 3, 6 ), List.of( 4, 10, 11, 17 ), List.of( 7, 4, 5, 2 ),
                List.of( 2, 6, 8, 9 )));
    }

    // TC = O(N*M) WHERE N IS NO OF ROWS AND M IS NO OF COLUMNS AND SC=O(1) SINCE NO EXTRA SPACE NEEDED
    private static void printDiagonalsOf2DRectMatrix(final List<List<Integer>> matrix) {
        // PART-1 FIRST PRINTING THE DIAGONAL ELEMENTS FROM LEFT->RIGHT TILL END OF COLUMNS
        for (int j = 0; j < matrix.get(0).size(); j++) {
            int xTemp = 0, yTemp = j;
            System.out.println();
            while (xTemp < matrix.size() && yTemp >= 0) {
                System.out.print(matrix.get(xTemp).get(yTemp) +" ");
                xTemp++;
                yTemp--;
            }
        }
        // PART-2 PRINTING ELEMENTS FROM 1ST ROW AND LAST COLUMN FROM LEFT->RIGHT TILL END OF ROWS
        for (int x = 1; x < matrix.size(); x++) {
            int temp = x, j = matrix.get(0).size() - 1;
            System.out.println();
            while (temp < matrix.size() && j >= 0) {
                System.out.print(matrix.get(temp).get(j) + " ");
                temp++;
                j--;
            }
        }
    }
}
