package com.hashing;

import java.util.*;

public class SubArraysWithSumK {

    public static void main(String[] args) {
        System.out.println("DOES EXIST A SUBARRAY WITH SUM "+doesSubArrayExistWithSumK(List.of(2, 3, 9, -4, 1), 10));
        System.out.println("NUMBER OF SUBARRAYS WITH TARGET SUM "+countNumberOfSubArraysWhoseSumIsK(List.of(2, 3, 9, -4, 1, 13, 5, 5), 10));
    }

    private static boolean doesSubArrayExistWithSumK(final List<Integer> input, final Integer K) {
        Integer prefixSum = 0;
        final Set<Integer> hashSet = new HashSet<>();
        for (Integer element: input) {
            prefixSum = prefixSum + element;
            if (prefixSum.equals(K) || hashSet.contains(prefixSum - K)) {
                return true;
            }
            hashSet.add(prefixSum);
        }
        return false;
    }

    private static Integer countNumberOfSubArraysWhoseSumIsK(final List<Integer> input, final Integer K) {
        int answer = 0;
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        int prefixSum = 0;
        for (Integer element: input) {
            prefixSum = prefixSum + element;
            int difference = prefixSum - K;
            if (frequencyMap.containsKey(difference)) {
                answer = answer + frequencyMap.get(difference);
            } else if (prefixSum == K) {
                answer++;
            }
            frequencyMap.compute(prefixSum, (k, v) -> v == null ? 1 : v+1);
        }
        return answer;
    }
}
