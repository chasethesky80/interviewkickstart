package com.prefixsum;

import com.util.ArrayUtils;

import java.util.List;

// GIVEN N ARRAY ELEMENTS AND Q QUERIES, FIND SUM OF ODD INDICES FOR EACH QUERY
public class GivenArrayFindSumOfOddIndicesForQueries {

    public static void main(String[] args) {
        System.out.println("SUM OF EVEN INDICES FOR START AND END INDEX IS "+ findSumOfOddIndicesForIndices(List.of( 3, 4, -2, 8, 6, 2, 1, 3 ),
                2, 6));
        System.out.println("SUM OF EVEN INDICES FOR START AND END INDEX IS "+ findSumOfOddIndicesForIndices(List.of( 3, 4, -2, 8, 6, 2, 1, 3 ),
                3, 7));
    }
    private static Integer findSumOfOddIndicesForIndices(final List<Integer> input, final Integer startIndex, final Integer endIndex) {
        final List<Integer> oddPrefixSumArray = ArrayUtils.buildOddPrefixSumArray(input);
        return startIndex == 0
                ? oddPrefixSumArray.get(endIndex)
                : oddPrefixSumArray.get(endIndex) - oddPrefixSumArray.get(startIndex - 1);
    }
}
