package com.sorting;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println("SORTED ELEMENTS USING SELECTION SORT "+ performSelectionSort(Arrays.asList(2, 5, 3, 7, 1, 6)));
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT ALTERNATIVE "+ performSelectionSort(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3)));
    }

    private static List<Integer> performSelectionSort(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int currentMin = input.get(i);
            int currentMinIndex = i;
            for (int j = i+1; j < input.size(); j++) {
                if (input.get(j).compareTo(currentMin) < 0) {
                    currentMinIndex = j;
                    currentMin = input.get(j);
                }
            }
            int temp = input.get(i);
            input.set(i, input.get(currentMinIndex));
            input.set(currentMinIndex, temp);
        }
        return input;
    }
}
