package com.bitmanipulation;

public class GenerateNoWithXSetBitsYUnsetBits {

    public static void main(String[] args) {
        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generate(2, 3));
        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generate(3, 2));

        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generateAlternative(2, 3));
        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generateAlternative(3, 2));

        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generateOptimized(2, 3));
        System.out.println("NUMBER GENERATED AFTER X SET BITS AND Y UNSET BITS "+ generateOptimized(3, 2));
    }

    private static int generate(int x, int y) {
        int ans = 0;
        for (int i = y; i < x + y; i++) {
            ans = ans + (1 << i);
        }
        return ans;
    }
    // TC = O(x) where x is number of bits to set and SC = O(1) since no extra space used
    private static int generateAlternative(int x, int y) {
        int n = 0;
        for (int i = y; i < y + x; i++) {
            n = n | (1 << i);
        }
        return n;
    }

    private static int generateOptimized(int x, int y) {
        return ((1 << x) - 1) << y;
    }
}