package com.hashing;

import java.util.*;

// GIVEN AN ARRAY OF SIZE N, RETURN 2 VALUES FROM ARRAY SUCH THAT THE SUM
// OF ELEMENTS AT THOSE 2 INDICES EQUALS A GIVEN TARGET K ELSE RETURN EMPTY ARRAY
public class TwoSumProblemWithHashSet {

    public static void main(String[] args) {
        System.out.println("FIRST PAIR OF ELEMENTS SUMMING TO K EQUALS "+ Arrays.toString(getFirstPairOfValuesSummingToKOptimized(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 11)));
        System.out.println("FIRST PAIR OF ELEMENTS SUMMING TO K EQUALS WITH 2 POINTER APPROACH "+ Arrays.toString(getFirstPairOfValuesSummingToKWith2PointerApproach(
                new ArrayList<>(List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 )), 11)));
        System.out.println("FIRST PAIR OF ELEMENTS SUMMING TO K EQUALS "+ Arrays.toString(getFirstPairOfValuesSummingToKOptimized(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 22)));
        System.out.println("NUMBER OF PAIRS OF ELEMENTS SUMMING TO K EQUALS "+ getNumberOfPairsWhoseSumIsEqualToTargetSum(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 22));
        System.out.println("NUMBER OF PAIRS OF ELEMENTS SUMMING TO K EQUALS "+ getNumberOfPairsWhoseSumIsEqualToTargetSum(
                List.of( 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 ), 11));
        System.out.println("NUMBER OF PAIRS OF ELEMENTS SUMMING TO K EQUALS "+ getNumberOfPairsWhoseSumIsEqualToTargetSum(
                List.of( 8, 9, 2, 2, -2, 4, 5, 11, -6, 4 ), 7));
        System.out.println("NUMBER OF PAIRS OF ELEMENTS SUMMING TO K EQUALS "+ getNumberOfPairsWhoseSumIsEqualToTargetSum(
                Arrays.asList( 8, 9, 2, -2, 4, 5, -2, 5, 2 ), 7));

    }
    // TC = O(N) and SC = O(N) for the extra hashset
    private static Integer[] getFirstPairOfValuesSummingToKOptimized(final List<Integer> input, final Integer K) {
        final HashSet<Integer> hashSet = new HashSet<>();
        for(Integer element: input) {
            final Integer remaining = K - element;
            if (hashSet.contains(remaining)) {
                return new Integer[]{element, remaining};
            } else {
                hashSet.add(element);
            }
        }
        return new Integer[]{};
    }

    private static Integer getNumberOfPairsWhoseSumIsEqualToTargetSum(final List<Integer> input, final Integer K) {
        int answer = 0;
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer element: input) {
            int difference = K - element;
            if (frequencyMap.containsKey(difference)) {
                answer = answer + frequencyMap.get(difference);
            }
            frequencyMap.compute(element, (k, v) -> v == null ? 1 : v+1);
        }
        return answer;
    }

    /**
     * 2 POINTER APPROACH FOR 2-SUM PROBLEM
     * @param input
     * @param K
     * @return
     */
    private static Integer[] getFirstPairOfValuesSummingToKWith2PointerApproach(final List<Integer> input, final Integer K) {
        Collections.sort(input);
        int i = 0, j = input.size() - 1;
        while (i < j) {
            int sum = Integer.sum(input.get(i), input.get(j));
            if (sum < K) {
                i++;
            } else if (sum > K) {
                j--;
            } else {
                return new Integer[]{input.get(i), input.get(j)};
            }
        }
        return new Integer[]{};
    }
}
