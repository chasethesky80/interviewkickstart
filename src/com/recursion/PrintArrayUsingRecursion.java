package com.recursion;

import java.util.Arrays;
import java.util.List;

public class PrintArrayUsingRecursion {

    public static void main(String[] args) {
        printArray(Arrays.asList(2, 4, 1, 6, 7));
    }

    private static void printArray(final List<Integer> A) {
        printArrayHelper(A, 0);
    }
    private static void printArrayHelper(final List<Integer> A, int index) {
        if (index == A.size()) {
            return;
        }
        System.out.print(A.get(index) +" ");
        printArrayHelper(A, index+1);
    }
}
