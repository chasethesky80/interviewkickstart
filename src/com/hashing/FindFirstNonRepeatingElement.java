package com.hashing;

import com.util.CollectionUtils;

import java.util.List;
import java.util.Map;

// GIVEN ARRAY OF N ELEMENTS, FIND FIRST NON-REPEATING ELEMENT IN ARRAY
public class FindFirstNonRepeatingElement {

    public static void main(String[] args) {
        System.out.println("FIRST NON REPEATING ELEMENT "+getFirstNonRepeatingElement(List.of(1, 2, 3, 1, 2, 5)));
        System.out.println("FIRST NON REPEATING ELEMENT "+getFirstNonRepeatingElement(List.of(2, 2, 3, 3, 5, 5)));
    }

    // Time complexity: O(N) and space complexity: O(N)
    private static int getFirstNonRepeatingElement(final List<Integer> input) {
        final Map<Integer, Integer> inputFrequencyMap = CollectionUtils.buildFrequencyMap(input);
        for (Integer element: input) {
            if (inputFrequencyMap.get(element) == 1) {
                return element;
            }
        }
        return -1;
    }
}
