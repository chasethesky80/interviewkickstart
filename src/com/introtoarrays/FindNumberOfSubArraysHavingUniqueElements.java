package com.introtoarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumberOfSubArraysHavingUniqueElements {

    public static void main(String[] args) {
        System.out.println("NUMBER OF SUB ARRAYS CONTAINING UNIQUE ELEMENTS "+
                getNumberOfSubArraysContainingUniqueElementsBruteForce(Arrays.asList(1, 1, 3)));
        System.out.println("NUMBER OF SUB ARRAYS CONTAINING UNIQUE ELEMENTS "+
                getNumberOfSubArraysContainingUniqueElementsBruteForce(Arrays.asList(2, 1, 2)));
    }

    /**
     * TC = O(N^2) and SC = O(N)
     * @param input
     * @return
     */
    private static Integer getNumberOfSubArraysContainingUniqueElementsBruteForce(final List<Integer> input) {
        int count = input.size();
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                frequencyMap.merge(input.get(j), 1, Integer::sum);
                if (frequencyMap.get(input.get(j)) == 1 && j != i) {
                    System.out.println("I AND J VALUES "+ i +" "+j);
                    count++;
                }
            }
        }
        return count;
    }
}
