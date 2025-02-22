package com.introtoarrays;

import com.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

// GIVEN AN ARRAY OF N ELEMENTS, ROTATE IT K NUMBER OF TIMES BOTH CLOCKWISE AND ANTI-CLOCKWISE
public class RotateAGivenArrayKTimes {

    public static void main(String[] args) {
        // ROTATE CLOCKWISE
        rotateAntiClockwiseAndPrint(new ArrayList<>(List.of( 3, -2, 1, 4, 6, 9, 8)), 3);
        rotateAntiClockwiseAndPrint(new ArrayList<>(List.of( 3, -2, 1, 4, 6, 9, 8)), 8);
        rotateAntiClockwiseAndPrint(new ArrayList<>(List.of( 1, 2, 3, 4, 5)), 2);

        // ROTATE ANI-CLOCKWISE
        rotateClockwiseAndPrint(new ArrayList<>(List.of( 3, -2, 1, 4, 6, 9, 8)), 3);
        rotateClockwiseAndPrint(new ArrayList<>(List.of( 3, -2, 1, 4, 6, 9, 8)), 8);
        rotateClockwiseAndPrint(new ArrayList<>(List.of( 1, 2, 3, 4, 5)), 2);
    }

    private static void rotateAntiClockwiseAndPrint(final List<Integer> input, int K) {
        K = K % input.size();
        rotateArrayKTimesAntiClockwise(input, K);
        System.out.println("ROTATED ARRAY ANTI-CLOCKWISE "+ input);
    }

    private static void rotateClockwiseAndPrint(final List<Integer> input, int K) {
        K = K % input.size();
        rotateArrayKTimesClockwise(input, K);
        System.out.println("ROTATED ARRAY CLOCKWISE "+ input);
    }

    private static void rotateArrayKTimesAntiClockwise(final List<Integer> input, final int K) {
        ArrayUtils.reversePartOfArray(input, 0, input.size() - 1);
        ArrayUtils.reversePartOfArray(input, 0,  K - 1);
        ArrayUtils.reversePartOfArray(input, K, input.size() - 1);
    }

    private static void rotateArrayKTimesClockwise(final List<Integer> input, final int K) {
        ArrayUtils.reversePartOfArray(input, 0, input.size() - 1);
        ArrayUtils.reversePartOfArray(input, 0,  input.size() - K - 1);
        ArrayUtils.reversePartOfArray(input, input.size() - K, input.size() - 1);
    }

}
