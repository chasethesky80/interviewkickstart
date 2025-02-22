package com.bitmanipulation;

import java.util.Arrays;

/**
 * Given a decimal number convert to binary based on number of bits
 */
public class ConvertDecimalToBinary {

    public static void main(String[] args) {
        System.out.println("BINARY OF INPUT "+ Arrays.toString(convertToBinary(17, 32)));
        System.out.println("BINARY OF INPUT "+ Arrays.toString(convertToBinary(24, 32)));
    }

    /**
     * Method to convert a decimal to binary number based on number of digits
     * @param N
     * @param numberOfIndices
     * @return
     */
    private static int[] convertToBinary(int N, int numberOfIndices) {
        int[] binary = new int[numberOfIndices];
        int count = 0;
        while (N > 0) {
            int reminder = N % 2;
            binary[numberOfIndices - (count + 1)] = reminder;
            count = count + 1;
            N = N / 2;
        }
        return binary;
    }
}
