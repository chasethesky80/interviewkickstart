package com.hashing;

import java.util.HashSet;
import java.util.List;

//GIVEN AN ARRAY OF N ELEMENTS, RETURN IF ALL ELEMEMTS OF THE ARRAY ARE DISTINCT OR NOT
public class CheckIfAllArrayElementsAreDistinct {

    public static void main(String[] args) {
        System.out.println("CHECK OF ALL ELEMENTS OF ARRAY ARE DISTINCT "+areAllElementsInArrayDistinct(List.of(6, 3, 7, 3, 8, 6, 9)));
        System.out.println("CHECK OF ALL ELEMENTS OF ARRAY ARE DISTINCT "+areAllElementsInArrayDistinct(List.of(1, 2, 3, 4, 5, 6)));
    }

    // Time complexity: O(N) and space complexity: O(N)
    private static boolean areAllElementsInArrayDistinct(final List<Integer> input) {
        return new HashSet<>(input).size() == input.size();
    }
}
