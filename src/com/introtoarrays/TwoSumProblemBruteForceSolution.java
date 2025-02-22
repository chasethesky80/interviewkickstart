package com.introtoarrays;

import java.util.List;

// GIVEN AN ARRAY OF SIZE N, CHECK IF EXISTS A PAIR (I,J) SUCH THAT THEIR SUM EQUALS A GIVEN INPUT K
public class TwoSumProblemBruteForceSolution {

    public static void main(String[] args) {
        System.out.println("DOES EXIST A PAIR WITH SUM K "+ doesAPairExistWithSumEqualsKBruteForce(List.of( 3, -2, 1, 4, 3, 6, 8 ), 10));
        System.out.println("DOES EXIST A PAIR WITH SUM K "+ doesAPairExistWithSumEqualsKBruteForce(List.of( 2, 4, -3, 7 ), 5));
    }
    // TC = O(N^2) since there are 2 for loops with N iterations each and SC = O(1)
    // NO OF ITERATIONS :- N * (N-1) / 2 :- (N-1) + (N-2) + (N-3) + ........+1 + 0 = (N-1) * N / 2
    private static boolean doesAPairExistWithSumEqualsKBruteForce(final List<Integer> input, final Integer K) {
        for (int i =0; i < input.size(); i++) {
            for (int j = i +1; j < input.size(); j++) {
                if (Integer.sum(input.get(i), input.get(j)) == K) {
                    return true;
                }
            }
        }
        return false;
    }
}
