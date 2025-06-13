package com.bitmanipulation;

import java.util.Arrays;

/**
 * There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].
 * Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.
 * NOTE: REFER BOSSCODER ACADEMY CLASS : Bit Manipulation || IL : Bit Manipulation
 */
public class DecodeXORedPermutation {

    public static void main(String[] args) {
        System.out.println("DecodeXORedPermutation "+ Arrays.toString(decodeXORedPermutation(new int[]{3, 1})));
        System.out.println("DecodeXORedPermutation "+ Arrays.toString(decodeXORedPermutation(new int[]{ 6, 5, 4, 6 })));
    }

    private static int[] decodeXORedPermutation(int[] encoded) {
        int xor_All = 0, n = encoded.length;
        for (int i = 1; i <=n+1; i++) {
            xor_All = xor_All ^ i;
        }

        int xor_Odds = 0;
        for (int i = 1; i < n; i=i+2) {
            xor_Odds = xor_Odds ^ encoded[i];
        }

        int[] perm = new int[n+1];
        perm[0] = xor_All ^ xor_Odds;
        for (int i = 0; i < n; i++) {
            perm[i+1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
