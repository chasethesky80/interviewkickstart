package com.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println("QUICK SORT");
        int[] arr = new int[]{ 7, 3, 4 ,2 ,1, 6 };
        quickSort(arr);
        System.out.println("SORTED ARRAY" + Arrays.toString(arr));
    }
    private static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    /**
     * NOTE: Refer interviewkickstart video lomotto partition on quick sort
     * @param array
     * @param start
     * @param end
     */
    private static void quickSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        //TODO NEED TO PICK PIVOT AS RANDOM NUMBER INSTEAD OF START OF ARRAY
        int smaller = start;
        for (int bigger = start+1; bigger <= end; bigger++) {
            if (array[bigger] <= array[start]) {
                smaller++;
                int temp = array[smaller];
                array[smaller] = array[bigger];
                array[bigger] = temp;
            }
        }
        int temp = array[start];
        array[start] = array[smaller];
        array[smaller] = temp;
        quickSortHelper(array, start, smaller-1);
        quickSortHelper(array, smaller+1, end);
    }
}
