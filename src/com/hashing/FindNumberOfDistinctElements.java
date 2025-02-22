package com.hashing;

import java.util.HashSet;
import java.util.List;

// GIVEN ARRAY OF N ELEMENTS, FIND THE NUMBER OF DISTINCT ELEMENTS IN THE ARRAY
public class FindNumberOfDistinctElements {

    public static void main(String[] args) {
        System.out.println("FIND NUMBER OF DISTINCT ELEMENTS IN ARRAY "+getNumberOfDistinctElements(List.of(6, 3, 7, 3, 8, 6, 9)));
        System.out.println("FIND NUMBER OF DISTINCT ELEMENTS IN ARRAY "+getNumberOfDistinctElements(List.of(1, 1, 2, 2, 3, 3)));
    }
    // Time complexity: O(N) and space complexity: O(N)
    private static int getNumberOfDistinctElements(final List<Integer> input) {
        return new HashSet<>(input).size();
    }
}
