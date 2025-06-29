package com.binarysearch;

/**
 * GIVEN A SORTED ARRAY WITH DUPLICATES, FIND LAST OCCURRENCE OF A NUMBER IN THE SORTED ARRAY, IF THE NUMBER DOES NOT
 * EXIST IN THE SORTED ARRAY THEN RETURN THE POSITION WHERE THE NUMBER SHOULD BE INSERTED IN THE ARRAY
 */
public class FindLastOccurrenceOfANumberInSortedArray {

    public static void main(String[] args) {
        System.out.println("FindLastOccurrenceOfANumberInSortedArray "+ lastOccurrence(new int[] { 2, 3, 5, 5, 5, 6, 7, 8 },
                5));
        System.out.println("FindLastOccurrenceOfANumberInSortedArray "+ lastOccurrence(new int[] { 2, 3, 6, 7, 8 },
                4));
    }
    private static int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] < target || nums[mid + 1] == target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid+1] != target) {
                return mid;
            }
        }
        return low;
    }
}
