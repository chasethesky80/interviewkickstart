package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        final List<Integer> input = Arrays.asList(6, 4, 7, 3, 2, 1, 10);
        System.out.println("MERGE SORT OF ARRAY");
        final List<Integer> sorted = merge_sort(input);
        System.out.println(sorted);
    }
    static List<Integer> merge_sort(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        int mid = arr.size()/ 2;
        final List<Integer> leftHalf = new ArrayList<>(arr.subList(0, mid));
        final List<Integer> rightHalf = new ArrayList<>(arr.subList(mid, arr.size()));
        return mergeSortHelper(merge_sort(leftHalf), merge_sort(rightHalf));
    }

    static List<Integer> mergeSortHelper(final List<Integer> leftHalf, final List<Integer> rightHalf) {
        final ArrayList<Integer> auxillary = new ArrayList<>();
        int i = 0, j = 0;
        while (i < leftHalf.size() && j < rightHalf.size()) {
            if (leftHalf.get(i).compareTo(rightHalf.get(j)) <= 0) {
                auxillary.add(leftHalf.get(i));
                i++;
            } else {
                auxillary.add(rightHalf.get(j));
                j++;
            }
        }
        while (i < leftHalf.size()) {
            auxillary.add(leftHalf.get(i));
            i++;
        }
        while (j < rightHalf.size()) {
            auxillary.add(rightHalf.get(j));
            j++;
        }
        return auxillary;
    }
}
