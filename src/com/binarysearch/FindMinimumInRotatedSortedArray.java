package com.binarysearch;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * NOTE: REFER SCALER VIDEO BY SANDEEP :- Binary Search - 2 for explanation, THE PIVOT ELEMENT IN THIS VIDEO IS THE
 * MINIMUM IN THE ROTATED SORTED ARRAY WHICH IS THE FIRST ELEMENT IN THE SORTED ARRAY IF THE ARRAY WAS NOT ROTATED
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println("Find minimum of sorted array "+ findMin(new int[]{ 4,5,6,7,0,1,2 }));
    }
    private static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] <= nums[nums.length - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
