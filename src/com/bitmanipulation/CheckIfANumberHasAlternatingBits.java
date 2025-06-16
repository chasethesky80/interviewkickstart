package com.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, check whether it has alternating bits: namely,
 * if two adjacent bits will always have different values.
 */
public class CheckIfANumberHasAlternatingBits {

    public static void main(String[] args) {
        System.out.println("CHECK IF A NUMBER HAS ALTERNATING BITS "+ hasAlternatingBits(7));
        System.out.println("CHECK IF A NUMBER HAS ALTERNATING BITS "+ hasAlternatingBits(11));
    }
    private static boolean hasAlternatingBits(int n) {
        List<Integer> bits = new ArrayList<>();
        while (n > 0) {
            int remainder = n % 2;
            bits.add(remainder);
            n /= 2;
        }
        for (int i = 0; i < bits.size() - 1; i++){
            if (bits.get(i).compareTo(bits.get(i+1)) == 0){
                return false;
            }
        }
        return true;
    }
}
