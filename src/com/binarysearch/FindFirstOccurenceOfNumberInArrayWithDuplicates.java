package com.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindFirstOccurenceOfNumberInArrayWithDuplicates {

    public static void main(String[] args) {
        System.out.println("PERFORM BINARY SEARCH FOR K ON "+ binarySearch(Arrays.asList(3, 6, 9, 12, 14, 19, 20, 23, 25, 27), 20));
        System.out.println("FIRST OCCURRENCE OF NUMBER K IN ARRAY "+ findFirstOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(3, 6, 9, 12, 12, 14, 19, 20, 23, 25, 27), 20));
        System.out.println("LAST OCCURRENCE OF NUMBER K IN ARRAY "+ findLastOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(3, 6, 9, 12, 12, 14, 19, 20, 23, 25, 27), 20));

        System.out.println("FIRST OCCURRENCE OF NUMBER K IN ARRAY "+ findFirstOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(3, 6, 7, 12, 12, 14, 19, 20, 23, 25, 27), 12));
        System.out.println("LAST OCCURRENCE OF NUMBER K IN ARRAY "+ findLastOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(3, 6, 7, 12, 12, 14, 19, 20, 23, 25, 27), 12));

        System.out.println("FIRST OCCURRENCE OF NUMBER K IN ARRAY "+ findFirstOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(12, 12), 12));
        System.out.println("LAST OCCURRENCE OF NUMBER K IN ARRAY "+ findLastOccurrenceOfNumberInGivenArrayWithDuplicates(Arrays.asList(12, 12), 12));
    }

    /**
     * Given a sorted array with duplicates find the first occurrence of a given number
     * @param input - the input array
     * @param K - the target to search for in the given array
     * @return
     */
    private static Integer findFirstOccurrenceOfNumberInGivenArrayWithDuplicates(final List<Integer> input, final Integer K) {
        int l = 0, r = input.size() - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            final Integer middle = input.get(mid);
            if (middle.compareTo(K) == 0 && (mid == 0 || input.get(mid-1).compareTo(middle) < 0)) {
                return mid;
            }
            if (K.compareTo(middle) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Given a sorted array with duplicates find the last occurrence of a given number
     * @param input - the input array
     * @param K - the target number to search for in the array
     * @return
     */
    private static Integer findLastOccurrenceOfNumberInGivenArrayWithDuplicates(final List<Integer> input, final Integer K) {
        int l = 0, r = input.size() - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            final Integer middle = input.get(mid);
            if (middle.compareTo(K) == 0 && (mid == input.size() -1 || input.get(mid+1).compareTo(middle) > 0)) {
                return mid;
            } else if (middle.compareTo(K) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Basic Binary Search
     * @param input
     * @param K
     * @return
     */
    private static int binarySearch(final List<Integer> input, final Integer K) {
        int l = 0, r = input.size() - 1;

        while (l <= r) {
            int mid = l + (r-l)/2;

            if (input.get(mid).compareTo(K) == 0) {
                return mid;
            }

            if (K.compareTo(input.get(mid)) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
