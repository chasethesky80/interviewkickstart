package com.twodimensionalarrays;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

// GIVEN A 2D ARRAY, ROTATE IT CLOCKWISE FROM TOP-RIGHT CORNER
public class GivenA2DSquareMatrixRotateItClockwiseFromTopRight {

    public static void main(String[] args) {
        System.out.println("ROTATED 2D MATRIX FROM TOP-RIGHT CORNER IS " + rotate2DArrayClockwiseFromTopRightCorner(Arrays.asList(
                Arrays.asList( 1, 2, 3, 4, 5 ), Arrays.asList( 6, 7, 8, 9, 10 ), Arrays.asList( 11, 12, 13, 14, 15 ),
                Arrays.asList( 16, 17, 18, 19, 20 ), Arrays.asList( 21, 22, 23, 24, 25 ))));
    }

    // THIS INVOLVES THE FOLLOWING 2 STEPS:
    // 1) PERFORM TRANSPOSE OF THE 2D MATRIX
    // 2) REVERSE ELEMENTS OF EACH ROW OF THE TRANSPOSED
    // TC = O(N^2) (FOR THE TRANSPOSE) + O(N^2) (FOR REVERSING THE ELEMENTS OF EACH ROW OF TRANSPOSED MATRIX) ~ O(N^2)
    // SC = O(1) SINCE THE ROTATION OF THE 2D MATRIX IS IN-PLACE AND NO EXTRA SPACE USED
    private static List<List<Integer>> rotate2DArrayClockwiseFromTopRightCorner(final List<List<Integer>> matrix) {
        // TC = O(N^2) FOR THE TRANSPOSE OPERATION AND SC = O(1) DUE TO NO EXTRA SPACE USED
        final List<List<Integer>> transposedMatrix = ArrayUtils.getTransposeOf2DSquareMatrix(matrix);
        int noOfColumns = transposedMatrix.get(0).size();
        // HERE WE ARE REVERSING THE ELEMENTS OF EACH ROW OF THE TRANSPOSED 2D MATRIX
        for (int i = 0; i < transposedMatrix.size(); i++) {
            for (int j=0, k= noOfColumns-1; j <=k; j++, k--) {
                Integer temp = transposedMatrix.get(i).get(j);
                transposedMatrix.get(i).set(j, transposedMatrix.get(i).get(k));
                transposedMatrix.get(i).set(k, temp);
            }
        }
        return transposedMatrix;
    }
}
