package com.introtoarrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array with duplicates remove duplicates and return length of sorted list
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println("REMOVE DUPLICATES FROM SORTED ARRAY "+ removeDuplicates(Arrays.asList(0, 1, 2, 2, 2, 2, 3, 3, 4)));
    }

    private static Integer removeDuplicates(final List<Integer> input) {
        int i = 0;
        for (int j = 1; j < input.size(); j++){
            while (input.get(i).compareTo(input.get(j)) == 0) {
                j++;
            }
            i++;
            input.set(i, input.get(j));
        }
        return i+1;
    }
}
