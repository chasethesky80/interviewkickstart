package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println("MERGE 2 SORTED ARRAYS "+ mergeSortedArrays(Arrays.asList(2, 5, 6, 7, 8), Arrays.asList(1, 8, 9, 10)));
    }

    private static List<Integer> mergeSortedArrays(final List<Integer> array1, final List<Integer> array2) {
        final List<Integer> auxillary = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i).compareTo(array2.get(j)) <= 0) {
                auxillary.add(array1.get(i));
                i++;
            } else {
                auxillary.add(array2.get(j));
                j++;
            }
        }
        while (i < array1.size()) {
            auxillary.add(array1.get(i));
            i++;
        }
        while (j < array2.size()) {
            auxillary.add(array2.get(j));
            j++;
        }
        return auxillary;
    }
}
