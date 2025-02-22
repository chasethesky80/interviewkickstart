package com.sorting;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class SortElementsOfArrayWithSelectionSort {

    public static void main(String[] args) {
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT "+ sortUsingSelectionSort(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3)));
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT ALTERNATIVE "+ sortUsingSelectionSortAlternative(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3)));
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT "+ sortUsingSelectionSort(Arrays.asList(3, 8, 9, 2, -7, 5, 7, -4)));
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT ALTERNATIVE "+ sortUsingSelectionSortAlternative(Arrays.asList(3, 8, 9, 2, -7, 5, 7, -4)));
    }

    private static List<Integer> sortUsingSelectionSort(final List<Integer> input) {
        int N = input.size();
        for (int i = N-1; i >= 1; i--) {
            int indexOfLargestNumber = 0;
            for (int j = 0; j <= i; j++) {
                if (input.get(j).compareTo(input.get(indexOfLargestNumber)) > 0) {
                    indexOfLargestNumber = j;
                }
            }
            Integer temp = input.get(indexOfLargestNumber);
            input.set(indexOfLargestNumber, input.get(i));
            input.set(i, temp);
        }
        return input;
    }

    private static List<Integer> sortUsingSelectionSortAlternative(final List<Integer> input) {
        int N = input.size();
        for (int i = 0; i < N -1; i++) {
            int indexOfSmallestNumber = i+1;
            for (int j = i+1; j < N; j++) {
                if (input.get(j).compareTo(input.get(indexOfSmallestNumber)) < 0) {
                    indexOfSmallestNumber = j;
                }
            }
            Integer temp = input.get(indexOfSmallestNumber);
            input.set(indexOfSmallestNumber, input.get(i));
            input.set(i, temp);
        }
        return input;
    }
}
