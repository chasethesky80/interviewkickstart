package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindFrequencyOfNoInSortedArray {

    public static void main(String[] args) {
        System.out.println("FIND FREQUENCY OF NUMBER IN SORTED ARRAY WITH DUPLICATES "+ frequencyOfNumberInArrayWithDuplicatesLinearSearch(Arrays.asList(
                -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 15), 5));
        System.out.println("FIND FREQUENCY OF NUMBER IN SORTED ARRAY WITH DUPLICATES BINARY SEARCH "+ frequencyOfNumberInArrayWithDuplicatesBinarySearch(Arrays.asList(
                -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 15), 5));
        System.out.println("FIND FREQUENCY OF NUMBER IN SORTED ARRAY WITH DUPLICATES BINARY SEARCH "+ frequencyOfNumberInArrayWithDuplicatesBinarySearch(Arrays.asList(
                -3 ,2, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 15), 5));
        System.out.println("FIND FREQUENCY OF NUMBER IN SORTED ARRAY WITH DUPLICATES BINARY SEARCH "+ frequencyOfNumberInArrayWithDuplicatesBinarySearch(Arrays.asList(
                -3 ,2, 8, 10, 10, 15, 15, 15, 15), 15));
    }
    /**
     * TC = O(N) as it is just one loop and SC = O(1) with
     * @param input
     * @param K
     * @return
     */
    private static Integer frequencyOfNumberInArrayWithDuplicatesLinearSearch(final List<Integer> input, final Integer K) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).compareTo(K) == 0) {
                count++;
            }
        }
        return count;
    }

    private static Integer frequencyOfNumberInArrayWithDuplicatesBinarySearch(final List<Integer> input, final Integer K) {
        int firstOccurrence = getFirstOccurrence(input, K);
        int lastOccurrence = getLastOccurrence(input, K);
        return lastOccurrence - firstOccurrence + 1;
    }

    /**
     * Get first occurrence of K
     * @param input
     * @param K
     * @return
     */
    private static Integer getFirstOccurrence(final List<Integer> input, final Integer K) {
        int l = 0, r = input.size()- 1;
        while (l <= r) {
            int middle = l + (r - l)/2;
            Integer current = input.get(middle);
            if (current.compareTo(K) == 0) {
                if (middle == 0 || current.compareTo(input.get(middle-1)) != 0) {
                    return middle;
                } else if (current.compareTo(input.get(middle+1)) == 0) {
                    r = middle - 1;
                }
            } else if (current.compareTo(K) < 0) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Get last occurrence of K
     * @param input
     * @param K
     * @return
     */
    private static Integer getLastOccurrence(final List<Integer> input, final Integer K) {
        int l = 0, r = input.size()- 1;
        while (l <= r) {
            int middle = l + (r - l)/2;
            Integer current = input.get(middle);
            if (current.compareTo(K) == 0) {
                if (middle == input.size() - 1 || current.compareTo(input.get(middle+1)) != 0) {
                    return middle;
                } else if (current.compareTo(input.get(middle+1)) == 0) {
                    l = middle + 1;
                }
            } else if (current.compareTo(K) < 0) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }
}
