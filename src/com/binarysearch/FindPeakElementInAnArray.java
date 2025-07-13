package com.binarysearch;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
 * than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * REFER TO STRIVERS (TAKE U FORWARD) YOUTUBE VIDEO : https://www.youtube.com/watch?v=cXxmbemS6XM
 */
public class FindPeakElementInAnArray {

    public static void main(String[] args) {
        System.out.println("Find peak element in an array "+ findPeakElement(new int[]{ 1, 2, 3, 1 }));
        System.out.println("Find peak element in an array "+ findPeakElement(new int[]{ 1, 2, 1, 3, 5, 6, 4 }));
        System.out.println("Find peak element in an array "+ findPeakElement(new int[]{ 1, 4, 2, 3, 5, 6, 4 }));
    }
    private static int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int low = 1, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid-1] < nums[mid]) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
