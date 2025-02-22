package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindUniqueElementInArrayWithDuplicates {

    public static void main(String[] args) {
        System.out.println("FIND UNIQUE ELEMENT IN ARRAY "+ findUniqueElementInArrayWithDuplicates(Arrays.asList(8, 8, 5, 5, 6, 2, 2)));
        System.out.println("FIND UNIQUE ELEMENT IN ARRAY "+ findUniqueElementInArrayWithDuplicates(Arrays.asList(8, 8, 5, 5, 6, 6, 7, 7, 9, 10, 10, 11, 11)));
        System.out.println("FIND UNIQUE ELEMENT IN ARRAY "+ findUniqueElementInArrayWithDuplicates(Arrays.asList(8, 8, 5, 5, 3, 6, 6, 7, 7, 10, 10, 11, 11)));
    }

    /**
     * Given an array with duplicate elements and an unique element where duplicate elements are adjacent to each other
     * find the unique element
     * @param input
     * @return
     */
    private static Integer findUniqueElementInArrayWithDuplicates(final List<Integer> input) {
        int l = 0, r = input.size() - 1;
        while (l <= r) {
            int middle = l + (r-l)/2;
            if ((middle == 0 || input.get(middle).compareTo(input.get(middle-1)) != 0) &&
                    (middle == input.size() - 1 || input.get(middle).compareTo(input.get(middle+1)) != 0)) {
                return input.get(middle);
            }
            if (middle != input.size() - 1 && input.get(middle).compareTo(input.get(middle+1)) == 0){
                  if (middle % 2 == 0) {
                      l = middle + 2;
                  } else {
                      r = middle - 1;
                  }
            } else {
                if (middle % 2 == 0) {
                    r = middle - 2;
                } else {
                    l = middle + 1;
                }
            }
        }
        return -1;
    }
}
