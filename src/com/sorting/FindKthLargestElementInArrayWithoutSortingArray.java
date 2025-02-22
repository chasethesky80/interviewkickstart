package com.sorting;

import java.util.*;

public class FindKthLargestElementInArrayWithoutSortingArray {

    public static void main(String[] args) {
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT "+ findKthLargestElementInArray(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3), 3));
        System.out.println("SSORT ELEMENTS WITH SELECTION SORT "+ findKthLargestElementInArray(Arrays.asList(3, 8, 9, 2, -7, 5, 7, -4), 2));
    }

    /**
     * TC = O(K*N) USING SELECTION SORT
     * @param input
     * @param K
     * @return
     */
    /**
     * KEEP SWAPPING ELEMENTS FROM LARGEST TILL KTH LARGEST SO THEY ARE IN THEIR CORRECT POSITION USING SELECTION SORT
     * SO ONLY THE LAST K ELEMENTS ARE SORTED IN INCREASING ORDER AND THEN ADD THE RESULT TO A HASHSET TO REMOVE ANY DUPLICATES
     * AND THEN ACCESS THE KTH LARGEST ELEMENT FROM THE END OF THE HASHSET
     * @param input
     * @param K
     * @return
     */
    private static Integer findKthLargestElementInArray(final List<Integer> input, final Integer K) {
        int N = input.size();
        for (int i = N-1; i >= N-K; i--) {
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
        return input.get(input.size() - K);
    }
}
