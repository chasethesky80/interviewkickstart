package com.searching;

/**
 * GIVEN A SORTED ARRAY PERFORM A BINARY SEARCH TO RETURN INDEX OF TARGET ELEMENT TO BE SEARCHED, IF ELEMENT
 * IS NOT FOUND IN THE ARRAY RETURN -1
 */
public class ImplementBinarySearchOnASortedArray {

    public static void main(String[] args) {
        System.out.println("PERFORMED BINARY SEARCH ON ASORTED ARRAY "+ binarySearch(new int[]{ 2, 3, 5, 6, 7 }, 5));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
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
        return -1;
    }
}
