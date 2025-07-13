package com.binarysearch;

import com.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element
 * which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * REFER YOUTUBE LINK : https://takeuforward.org/plus/dsa/binary-search/logic-building/single-element-in-sorted-array?tab=editorial
 */
public class FindSingleNumberInASortedArray {

    public static void main(String[] args) {
        System.out.println("FIND SINGLE NUMBER IN A SORTED ARRAY "+ findSingleNumber(new int[] { 1,1,2,3,3,4,4,8,8 }));
        System.out.println("FIND SINGLE NUMBER IN A SORTED ARRAY "+ findSingleNumber(new int[] { 3,3,7,7,10,11,11 }));
    }

    private static int findSingleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length-1] != nums[nums.length - 2]) {
            return nums[nums.length-1];
        }
        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            if ((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid+1]))
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
