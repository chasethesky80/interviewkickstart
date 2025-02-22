package com.twodimensionalarrays;

import java.util.List;

// GIVEN 2D SQUARE MATRIX, PRINT ITS DIAGNALS - LEFT TO RIGHT AND RIGHT TO LEFT
public class Given2DSquareMatrixPrintItsDiagnals {

    public static void main(String[] args) {
        printDiagonalsOfSquareMatrix(List.of(List.of( 3, 8, 9, 2 ), List.of( 1, 2, 3, 6 ), List.of( 4, 10, 11, 18 ), List.of( 7, 4, 5, 2 )));
    }

    // TC = O(N) WHERE N IS THE SIZE OF THE ARRAY AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static void printDiagonalsOfSquareMatrix(final List<List<Integer>> input) {
        // PRINTING DIAGONAL ELEMENTS FROM LEFT TO RIGHT (L-> R)
        System.out.println("PRINTING DIAGONAL ELEMENTS FROM LEFT TO RIGHT (L-> R)");
        for (int i=0, j=0; i < input.size() && j < input.size(); i++, j++) {
           System.out.print(input.get(i).get(j) +" ");
        }
        System.out.println();
        // PRINTING DIAGONAL ELEMENTS FROM RIGHT TO LEFT (L-> R)
        System.out.println("PRINTING DIAGONAL ELEMENTS FROM RIGHT TO LEFT (L-> R)");
        for (int i=0, j=input.size()-1; i < input.size() && j >=0; i++, j--) {
            System.out.print(input.get(i).get(j) +" ");
        }
    }
}
