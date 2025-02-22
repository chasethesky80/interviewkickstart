package com.prefixsum;

import com.util.ArrayUtils;

import java.util.List;

// GIVEN N ARRAY ELEMENTS AND Q QUERIES, FIND SUM OF EVEN INDICES FOR EACH QUERY
public class GivenArrayFindSumOfEvenIndicesForQueries {

    public static void main(String[] args) {
        System.out.println("SUM OF EVEN INDICES FOR START AND END INDEX IS "+ findSumOfEvenIndicesForIndices(List.of( 3, 4, -2, 8, 6, 2, 1, 3 ),
                2, 6));
        System.out.println("SUM OF EVEN INDICES FOR START AND END INDEX IS "+ findSumOfEvenIndicesForIndices(List.of( 3, 4, -2, 8, 6, 2, 1, 3 ),
                3, 7));
    }
    private static Integer findSumOfEvenIndicesForIndices(final List<Integer> input, final Integer startIndex, final Integer endIndex) {
        final List<Integer> evenPrefixSumArray = ArrayUtils.buildEvenPrefixSumArray(input);
        return startIndex == 0
                ? evenPrefixSumArray.get(endIndex)
                : evenPrefixSumArray.get(endIndex) - evenPrefixSumArray.get(startIndex - 1);
    }
}
