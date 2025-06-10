package com.bitmanipulation;

/**
 * LEETCODE PROBLEM: Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in
 * this range, inclusive. (PLEASE REFER BOSSCODE ACADEMY - VIDEO LECTURE - Bit Manipulation || IL : Bit Manipulation)
 */
public class BitwiseAndOfNumbersInRange {

    public static void main(String[] args) {
        System.out.println("Bitwise And Of Numbers in Range "+ bitwiseAndOfNumbersInRange(5, 7)); // EXPECTED VALUE IS 4
    }

    private static int bitwiseAndOfNumbersInRange(int left, int right) {
        int i = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            i++;
        }
        left <<= i;
        return left;
    }
}
