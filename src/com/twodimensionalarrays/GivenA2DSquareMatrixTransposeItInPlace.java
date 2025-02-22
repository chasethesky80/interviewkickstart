package com.twodimensionalarrays;

import com.util.ArrayUtils;

import java.util.Arrays;

// GIVEN A 2D SQUARE MATRIX OR LIST OF LISTS WITH NO OF ROWS EQUALS NO OF COLUMNS, PERFORM A TRANSPOSE OF THE MATRIX IN-PLACE
// NOTE: A RECTANGULAR MATRIX WHERE NO OF ROWS DOES NOT EQUAL NO OF COLUMNS CANNOT BE TRANSPOSED IN-PLACED ONLY A SQUARE MATRIX
// CAN BE TRANSPOSED IN-PLACE
public class GivenA2DSquareMatrixTransposeItInPlace {

    public static void main(String[] args) {
        System.out.println("TRANSPOSED SQUARE MATRIX IS " + ArrayUtils.getTransposeOf2DSquareMatrix(Arrays.asList(
                Arrays.asList(3, 8, 9, 2), Arrays.asList(1, 2, 3, 6), Arrays.asList(4, 10, 11, 17), Arrays.asList(7, 4, 5, 2))));
    }

}
