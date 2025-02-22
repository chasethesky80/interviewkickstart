package com.twodimensionalarrays;

import java.util.List;

// GIVEN A 2D MATRIX OF SIZE [N, M], PRINT ROW WISE SUM
public class GivenA2DMatrixPrintRowWiseSum {

    public static void main(String[] args) {
        System.out.println("PRINT ROW WISE SUM FOR ");
        printRowWiseSum(List.of(List.of( 3, 8, 9, 2 ), List.of( 1, 2, 3, 6 ), List.of( 4, 10, 11, 17 )));
    }
    // TC = O(N*M) WHERE N IS NUMBER OF ROWS AND M IS NUMBER OF COLUMNS AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static void printRowWiseSum(final List<List<Integer>> input) {
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = 0; j < input.get(i).size(); j++) {
                sum = sum + input.get(i).get(j);
            }
            System.out.println("ROW WISE SUM "+ sum);
        }
    }
}
