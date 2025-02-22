package com.hashing;

import java.util.*;

public class FindNoOfDistinctElementsInSubArrayLengthK {

    public static void main(String[] args) {
        System.out.println("NUMBER OF DISTINCT ELEMENTS OF ALL SUBARRAYS OF LENGTH K " + getLengthOfSubArraysOfLengthKBruteForce(
                Arrays.asList(2, 4, 3, 8, 3, 9, 4, 9, 4, 10), 4));
        System.out.println("NUMBER OF DISTINCT ELEMENTS OF ALL SUBARRAYS OF LENGTH K OPTIMIZED " + getLengthOfSubArraysOfLengthKOptimized(
                Arrays.asList(2, 4, 3, 8, 3, 9, 4, 9, 4, 10), 4));
    }


    /**
     * TC = O((N-K+1) * K) - THE NUMBER OF SUB ARRAYS IS N-K+1 AND SIZE OF EACH SUBARRAY IS K AND SC = O(K)
     * @param input
     * @param K
     * @return
     */
    private static List<Integer> getLengthOfSubArraysOfLengthKBruteForce(final List<Integer> input, final Integer K) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= input.size() - K; i++) {
            final Set<Integer> hashSet = new HashSet<>();
            for (int j = i; j < i+K; j++) {
                hashSet.add(input.get(j));
            }
            result.add(hashSet.size());
        }
        return result;
    }

    /**
     * SLIDING WINDOW WITH FREQUENCY HASHMAP TECHNIQUE - TC = O(N) and SC = O(K)
     * @param input
     * @param K
     * @return
     */
    private static List<Integer> getLengthOfSubArraysOfLengthKOptimized(final List<Integer> input, final Integer K) {
        final List<Integer> result = new ArrayList<>();
        /**
         * Populate the frequency for the first window from indices 0 to K-1
         */
        final Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < K; i++) {
            store.compute(input.get(i), (k, v) -> v == null ? 1 : v+1);
        }
        result.add(store.size());
        for (int i = 1; i <= input.size() - K; i++) {
            final Integer key = input.get(i - 1);
            store.compute(key, (k, v) ->  v - 1);
            int j = i + K-1;
            store.compute(input.get(j), (k, v) -> v == null ? 1 : v + 1);
            store.entrySet().removeIf(entry -> entry.getValue() == 0);
            result.add(store.size());
        }
        return result;
    }
}
