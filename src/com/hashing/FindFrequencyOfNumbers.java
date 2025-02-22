package com.hashing;

import com.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GIVEN ARRAY OF N ELEMENTS, RETURN THE FREQUENCY OF NUMBERS IN ARRAY
public class FindFrequencyOfNumbers {

    public static void main(String[] args) {
        System.out.println("QUERY FREQUENCY MAP "+buildQueryFrequencyMap(List.of(2, 6, 3, 8, 2, 8, 2, 3, 8), List.of(2, 8, 3, 5)));
    }

    // TC is O(N + Q) due to 2 for loops where N is size of input and Q is size of query array, SC = O(N) for extra hash maps
    private static Map<Integer, Integer> buildQueryFrequencyMap(final List<Integer> input, final List<Integer> queries) {
        final Map<Integer, Integer> queryFrequencyMap = new HashMap<>();
        final Map<Integer, Integer> inputFrequencyMap = CollectionUtils.buildFrequencyMap(input);
        for (Integer element: queries) {
            queryFrequencyMap.put(element, inputFrequencyMap.getOrDefault(element, 0));
        }
        return queryFrequencyMap;
    }
}
