package com.introtoarrays;

import com.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

// GIVEN AN ARRAY OF SIZE N, REVERSE ITS ELEMENTS IN PLACE
public class GivenAnArrayReverseItsElements {

    public static void main(String[] args) {
        final List<Integer> input1 = new ArrayList<>(List.of(-1, 4, 7, 6, -2, 7, 8, 10));
        final List<Integer> input2 = new ArrayList<>(List.of(-1, 4, 7, 6, -2, 7, 8, 10));
        reverseArray(input1);
        ArrayUtils.reversePartOfArray(input2, 2, 4);
        System.out.println("FIRST ARRAY REVERSED "+ input1);
        System.out.println("SECOND ARRAY REVERSED "+ input2);
    }
    // TC = O(N) and SC = O(1) since no extra space
    private static void reverseArray(final List<Integer> input) {
        ArrayUtils.reversePartOfArray(input, 0, input.size()-1);
    }

}
