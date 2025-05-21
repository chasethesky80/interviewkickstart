package com.util;

import java.util.Arrays;
import java.util.List;

public class BitManipulationHelper {

    public static void main(String[] args) {
        System.out.println("BINARY REPRESENTATION OF 13 "+ Arrays.toString(convertToBinary(13, 8)));
        System.out.println("DECIMAL EQUIVALENT FOR 13 IN BINARY "+ binaryToDecimal(Arrays.asList(1, 1, 0, 1)));
        System.out.println("BINARY REPRESENTATION OF 13 "+ Arrays.toString(convertToBinary(17, 8)));
        System.out.println("DECIMAL EQUIVALENT FOR 17 IN BINARY "+ binaryToDecimal(Arrays.asList(1, 0, 0, 0, 1)));
    }

    // TC = O(1) and SC = O(1) since we are just using right shift operator and & operator for solution
    public static boolean checkIfBitIsSetInPosition(int a, int i) {
        return ((a >> i) & 1) == 1;
    }

    public static boolean checkIfBitIsUnSetInPosition(int a, int i) {
        return ((a >> i) & 1) == 0;
    }

    public static int[] convertToBinary(int N, int noOfBits) {
        int[] binary = new int[noOfBits];
        int index = 0;
        while(N > 0){
            binary[index++] = N % 2;
            N = N/2;
        }
        return ArrayUtils.reversePartOfArray(binary, 0, binary.length - 1);
    }

    public static int binaryToDecimal(List<Integer> binaryArray) {
        int decimal = 0;
        int power = 0;

        for (int i = binaryArray.size() - 1; i >= 0; i--) {
            if (binaryArray.get(i) != 0 && binaryArray.get(i) != 1) {
                throw new IllegalArgumentException("Invalid binary array. It should contain only 0s and 1s.");
            }
            decimal += (int) (binaryArray.get(i) * Math.pow(2, power));
            power++;
        }

        return decimal;
    }
}
