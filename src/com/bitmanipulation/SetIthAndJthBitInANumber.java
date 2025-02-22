package com.bitmanipulation;

public class SetIthAndJthBitInANumber {

    public static void main(String[] args) {
        System.out.println("SET Ith AND Jth BIT IN NUMBER N "+setIthAndJthBit(0, 2, 3));
        System.out.println("SET Ith AND Jth BIT IN NUMBER N "+setIthAndJthBit(11, 2, 4));
    }
    // TC = O(1) and SC = O(1)
    private static int setIthAndJthBit(int n, int i, int j) {
        n = n | (1 << i) | (1 << j);
        return n;
    }
}
