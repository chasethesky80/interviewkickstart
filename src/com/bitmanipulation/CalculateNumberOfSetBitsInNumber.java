package com.bitmanipulation;

import com.util.BitManipulationHelper;

// Calculate the number of set bits for a 32 bit integer number where 0 <= n <= 10^9 (which means n is a positive number)
public class CalculateNumberOfSetBitsInNumber {

    public static void main(String[] args) {
        System.out.println("NO OF SET BITS FOR NUMBER N IS "+calculateNoOfSetBits(150));
        System.out.println("NO OF SET BITS FOR NUMBER N IS "+calculateNoOfSetBits(35));
    }

    // NOTE: Here since n is a positive number its MSB cannot be 1 and so we do not need to compute the number of set
    // bits in 32 bits of n but only 31 bits, so just loop through 30 bits of n which is from 0 to 31 which is 30 times
    // and so is constant time. TC = O(1) since checkIfBitIsSetInPosition function takes O(1) time and we only loop till
    // 31 bits which is constant and is not dependent on N, SC = O(1)
    private static int calculateNoOfSetBits(int n) {
        int setBitCount = 0;
      for (int i=0; i < 31; i++) {
          if (BitManipulationHelper.checkIfBitIsSetInPosition(n, i)) {
              setBitCount++;
          }
      }
      return setBitCount;
    }
}
