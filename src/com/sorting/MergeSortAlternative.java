package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * REFER INTERVIEW KICKSTART (IK) MERGE SORT ALGORITHM IN SORTING FOUNDATION MATERIAL
 */
public class MergeSortAlternative {

    public static void main(String[] args) {
        System.out.println("MERGE SORT "+ Arrays.toString(mergeSort(new int[]{3, 1, 5, 4, 6, 8})));
    }
    private static int[] mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        List<Integer> auxiliary = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                auxiliary.add(arr[i]);
                i++;
            } else if (arr[i] > arr[j]) {
                auxiliary.add(arr[j]);
                j++;
            }
        }
        while (i <= mid) {
            auxiliary.add(arr[i]);
            i++;
        }
        while (j <= right) {
            auxiliary.add(arr[j]);
            j++;
        }
        int index = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = auxiliary.get(index);
            index++;
        }
    }
}
