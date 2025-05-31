package com.bitmanipulation;

import com.util.BitManipulationHelper;

import java.util.Arrays;

/**
 * GIVEN A POSITIVE NUMBER REVERSE ITS BITS
 */
public class ReverseBitsOfANumber {

    public static void main(String[] args) {
        System.out.println("REVERSE BITS OF NUMBER "+ reverseBits(16));
        System.out.println("REVERSE BITS OF NUMBER "+ reverseBits(-17));
        System.out.println("BINARY VALUE "+ Arrays.toString(BitManipulationHelper.convertToBinary(16, 32)));
        System.out.println("BINARY VALUE "+ Arrays.toString(BitManipulationHelper.convertToBinary(-17, 32)));
    }

    private static int reverseBits(int n) {
        for (int i = 0; i < 32; i++) {
            n ^= 1 << i;
        }
        return n;
    }
}
