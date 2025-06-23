package com.searching;

/** LEETCODE - Search Insert Position - REFER TO Searching 1 & Searching 2 videos from Bosscoderacademy for solution
 Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.
 You must write an algorithm with O(log n) runtime complexity.
 */
public class ImplementBinarySearchOnASortedArray {

    public static void main(String[] args) {
        System.out.println("PERFORMED BINARY SEARCH ON ASORTED ARRAY "+ binarySearch(new int[]{ 1, 3, 5, 6 }, 5));
        System.out.println("PERFORMED BINARY SEARCH ON ASORTED ARRAY "+ binarySearch(new int[]{ 1, 3, 5, 6 }, 2));
        System.out.println("PERFORMED BINARY SEARCH ON ASORTED ARRAY "+ binarySearch(new int[]{ 1, 3, 5, 6 }, 7));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        if (target > arr[end]) {
            return end + 1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
