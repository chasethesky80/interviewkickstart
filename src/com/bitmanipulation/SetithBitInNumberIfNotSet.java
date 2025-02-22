package com.bitmanipulation;

import com.util.BitManipulationHelper;

public class SetithBitInNumberIfNotSet {

    public static void main(String[] args) {
        System.out.println("VALUE OF N AFTER SETTING 2ND BIT IN 17 -> " + setIthBitInNumberIfNotSet(17, 2));
        System.out.println("VALUE OF N AFTER SETTING 2ND BIT (IF NOT SET) IN 21 IS SAME AS 21 " +
                "SINCE ITS ALREADY SET IN FIRST STEP ABOVE -> " + setIthBitInNumberIfNotSet(21, 2));
        System.out.println("VALUE OF N AFTER SETTING 2ND BIT IN 17 -> " + setithBitInNumberIfNotSetOptimizedLesserLinesOfCode(17, 2));
    }

    // TC = O(1) and SC = O(1) since bit operations take constant time
    private static int setIthBitInNumberIfNotSet(int n, int i) {
        if (BitManipulationHelper.checkIfBitIsUnSetInPosition(n, i)) {
            // Here we set the bit at ith position of n if not set which is same as adding 2^i (in other words: 1 << i) to n
            // and returning the modified value of n after setting the ith bit
            n = n + (1 << i);
        }
        // if ith bit is set, then just return n
        return n;
    }

    // TC = O(1) and SC = O(1) with lesser lines of code
    // Here we just OR the number - n with a number that has 0s in all its bits except the ith bit
    // For eg: 1011 | 0100 -> 1111 where i = 2 and n = 11 -> (1011 in binary representation) and if the ith bit of n is
    // already set then nothing to do, so the problem solved in just 1 line of code with constant time TC
    // So to set the ith bit if not set, just do -> n | 2^i which is same as n | (1 << i)
    private static int setithBitInNumberIfNotSetOptimizedLesserLinesOfCode(int n, int i) {
        return n | (1 << i);
    }
}
