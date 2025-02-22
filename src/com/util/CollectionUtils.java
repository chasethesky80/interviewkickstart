package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

    public static Map<Integer, Integer> buildFrequencyMap(final List<Integer> input) {
        final Map<Integer, Integer> inputFrequencyMap = new HashMap<>();
        for (Integer element: input) {
            inputFrequencyMap.put(element, !inputFrequencyMap.containsKey(element) ? 1 : inputFrequencyMap.get(element) + 1);
        }
        return inputFrequencyMap;
    }
}
