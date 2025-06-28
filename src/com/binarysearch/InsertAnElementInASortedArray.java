package com.binarysearch;

/**
 * GIVEN A SORTED ARRAY AND A TARGET ELEMENT RETURN POSITION IN ARRAY WHERE ELEMENT SHOULD BE INSERTED TO MAINTAIN
 * THE ARRAY AS SORTED ELSE RETURN -1
 **/
public class InsertAnElementInASortedArray {

    public static void main(String[] args) {
        System.out.println("Inserting a new element at  "+ insertInSortedArray(new int[]{ 1, 2, 4, 5, 6 }, 3));
    }

    private static int insertInSortedArray(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n) {
                return i;
            }
        }
        return -1;
    }
}
