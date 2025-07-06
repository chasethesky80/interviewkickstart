package com.binarysearch;

/**
 * There is an integer array nums sorted in ascending order (not necessarily with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * NOTE: REFER TAKE U FORWARD CHANNEL VIDEO for explanation: https://www.youtube.com/watch?v=w2G2W8l__pc
 */
public class FindANumberInARotatedSortedArrayWithDuplicates {

    public static void main(String[] args) {
        System.out.println("Search In Rotated SortedArray "+ search(new int[] { 4,5,6,6,7,0,1,2,4 }, 1));
        System.out.println("Search In Rotated SortedArray "+ search(new int[] { 4,5,6,6,7,7,0,1,2 }, 6));
        System.out.println("Search In Rotated SortedArray "+ search(new int[] { 4,5,6,7,0,1,2,2,4 }, 9));
    }

    /**
     * FIND THE SORTED HALF AND SEARCH FOR THE TARGET IN THAT SORTED HALF AS EITHER THE LEFT OR RIGHT OF THE MID
     * WILL BE SORTED - EXPLANATION IN THIS VIDEO: https://www.youtube.com/watch?v=5qGrJbHhqFs
     * @param nums
     * @param target
     * @return
     */
    private static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return true;
            }
            /**
             * IF BOUNDARIES OF LEFT AND RIGHT HALF ARE EQUAL THEN SHRINK THE SEARCH SPACE
             */
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
