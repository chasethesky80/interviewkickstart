package com.binarysearch;

/**
 * GIVEN A SORTED ARRAY WITH DUPLICATES, FIND FIRST OCCURRENCE OF A NUMBER IN THE SORTED ARRAY, IF THE NUMBER DOES NOT
 * EXIST IN THE SORTED ARRAY THEN RETURN THE POSITION WHERE THE NUMBER SHOULD BE INSERTED IN THE ARRAY
 */
public class FindFirstOccurrenceOfANumberInSortedArray {

    public static void main(String[] args) {
        System.out.println("FindFirstOccurrenceOfANumberInSortedArray "+ firstOccurrence(new int[] { 2, 3, 5, 5, 5, 6, 7, 8 },
                5));
        System.out.println("FindFirstOccurrenceOfANumberInSortedArray "+ firstOccurrence(new int[] { 2, 3, 6, 7, 8 },
                5));
    }
    private static int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target || nums[mid-1] == target) {
                high = mid - 1;
            } else if (nums[mid-1] != target) {
                return mid;
            }
        }
        return low;
    }
}
