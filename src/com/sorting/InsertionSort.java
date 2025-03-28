package com.sorting;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println("PERFORM INSERTION SORT "+ performInsertionSort(Arrays.asList(6, 5, 1, 8, 3, 2)));
        System.out.println("PERFORM INSERTION SORT "+ performInsertionSort(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    private static List<Integer> performInsertionSort(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int temp = input.get(i);
            int red = i - 1;
            while (red >= 0 && input.get(red) > temp) {
                input.set(red + 1, input.get(red));
                red--;
            }
            input.set(red + 1, temp);
        }
        return input;
    }
}
