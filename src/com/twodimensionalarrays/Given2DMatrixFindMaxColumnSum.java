package com.twodimensionalarrays;

import java.util.List;

// GIVEN A 2D MATRIX OF SIZE [N, M], FIND MAXIMUM COLUMN SUM
public class Given2DMatrixFindMaxColumnSum {

    public static void main(String[] args) {
        System.out.println("MAX COLUMN SUM IS "+getMaxColumnSum(List.of(List.of( 3, 8, 9, 2 ), List.of( 1, 2, 3, 6 ), List.of( 4, 10, 11, 18 ))));
    }

    // TC IS O(N*M) WHERE N IS NUMBER OF ROWS AND M IS NUMBER OF COLUMNS AND SC = O(1) SINCE NO EXTRA SPACE USED
    private static Integer getMaxColumnSum(final List<List<Integer>> input) {
        int maxSum = Integer.MIN_VALUE;
        int noOfRows = input.size(), noOfColumns = input.get(0).size();
        for (int j =0; j <noOfColumns; j++) {
            int sum = 0;
            for (int i = 0; i < noOfRows; i++) {
                sum = sum + input.get(i).get(j);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


}
