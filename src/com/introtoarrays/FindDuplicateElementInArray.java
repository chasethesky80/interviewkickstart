package com.introtoarrays;

/**
 * Given an array of integers with one integer repeating and others unique, return the duplicate integer
 */
public class FindDuplicateElementInArray {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}));
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    /**
     * Implement the solution using a slow and fast pointer approach in O(N) time and O(1) space complexity
     * @param arr
     * @return
     */
    private static Integer findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
