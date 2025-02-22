package com.hashing;

import java.util.Arrays;
import java.util.List;

// GIVEN AN ARRAY OF SIZE N, RETURN 2 VALUES FROM ARRAY A[I] and A[J] SUCH THAT A[I] - A[J] = K
// AND I != J OR ELSE RETURN EMPTY ARRAY
public class TwoDifferenceProblemWithHashSet {

    public static void main(String[] args) {
        System.out.println("FIRST PAIR OF ELEMENTS SUMMING TO K EQUALS "+ Arrays.toString(getFirstPairWhoseDifferenceIsKKOptimized(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 11)));
        System.out.println("FIRST PAIR OF ELEMENTS SUMMING TO K EQUALS "+ Arrays.toString(getFirstPairWhoseDifferenceIsKKOptimized(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 22)));
    }
    // TODO: TC = O(N) and SC = O(N) for the extra hashset
    private static Integer[] getFirstPairWhoseDifferenceIsKKOptimized(final List<Integer> input, final Integer K) {
          return new Integer[]{};
    }
};
