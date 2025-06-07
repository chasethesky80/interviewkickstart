package com.bitmanipulation;

import com.util.BitManipulationHelper;

/**
 * GIVEN 3 NUMBERS a, b and c FIND THE MINIMUM NUMBER OF FLIPS NEEDED SO THAT a | b = c
 */
public class MinimumNumberOfFlipsNeeded {

    public static void main(String[] args) {
        System.out.println("MINIMUM NUMBER OF FLIPS NEEDED "+ minimumNumberOfFlips(2, 6, 5));
    }

    private static int minimumNumberOfFlips(int A, int B, int C) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (BitManipulationHelper.checkIfBitIsSetInPosition(C, i)) {
                if (!BitManipulationHelper.checkIfBitIsSetInPosition(B, i) &&
                    !BitManipulationHelper.checkIfBitIsSetInPosition(A, i)) {
                    count++;
                }
            } else {
                if ((!BitManipulationHelper.checkIfBitIsSetInPosition(B, i) &&
                    BitManipulationHelper.checkIfBitIsSetInPosition(A, i)) ||
                    (BitManipulationHelper.checkIfBitIsSetInPosition(B, i) &&
                       !BitManipulationHelper.checkIfBitIsSetInPosition(A, i))) {
                     count++;
                    } else if (BitManipulationHelper.checkIfBitIsSetInPosition(A, i) &&
                              BitManipulationHelper.checkIfBitIsSetInPosition(B, i)) {
                         count = count + 2;
                    }
                }
        }
        return count;
    }
}
