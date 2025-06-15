package com.bitmanipulation;

import java.util.Arrays;

/**
 * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
 * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
 * Return an array answer where answer[i] is the answer to the ith query.
 */
public class XORQueriesOfASubArray {

    public static void main(String[] args) {
        System.out.println("XOR QUERIES OF A SUB ARRAY "+ Arrays.toString(xorQueries(new int[]{ 1, 3, 4, 8 },
                                                            new int[][]{{ 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 }})));
        System.out.println("XOR QUERIES OF A SUB ARRAY "+ Arrays.toString(xorQueries(new int[]{ 4, 8, 2, 10 },
                new int[][]{{ 2, 3 }, { 1, 3 }, { 0, 0 }, { 0, 3 }})));
    }

    private static int[] xorQueries(int[] arr, int[][] queries) {
        /**
         *. USING PREFIX XOR ARRAY (SIMILAR TO PREFIX SUM ARRAY)
         */
        int[] prefixXORArray = new int[arr.length + 1];
        prefixXORArray[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            prefixXORArray[i] = prefixXORArray[i - 1] ^ arr[i - 1];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int result = prefixXORArray[left] ^ prefixXORArray[right + 1];
            answer[i] = result;
        }
        return answer;
    }
}
