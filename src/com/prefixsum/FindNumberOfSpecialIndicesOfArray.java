package com.prefixsum;

import com.util.ArrayUtils;

import java.util.List;

// AN INDEX IS A SPECIAL INDEX IF AFTER REMOVING ELEMENT AT THAT INDEX, THE SUM OF EVEN INDICES = SUM OF ODD INDICES OF ARRAY,
// FIND NUMBER OF SUCH SPECIAL INDICES IN A GIVEN ARRAY OF N ELEMENTS
public class FindNumberOfSpecialIndicesOfArray {

    public static void main(String[] args) {
        System.out.println("FIND NUMBER OF SPECIAL INDICES FOR ARRAY "+ findNumberOfSpecialIndices(List.of( 4, 3, 2, 7, 6, -2 )));
    }
    // TC = 0(N), SC = O(N)
    private static int findNumberOfSpecialIndices(final List<Integer> input) {
        final List<Integer> pfEvenSum = ArrayUtils.buildEvenPrefixSumArray(input);
        final List<Integer> pfOddSum = ArrayUtils.buildOddPrefixSumArray(input);
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            int pfOddSumAfterRemoval = i == 0
                    ? pfEvenSum.get(input.size()-1) - pfEvenSum.get(0)
                    : pfOddSum.get(i-1) + (pfEvenSum.get(input.size()-1) - pfEvenSum.get(i));
            int pfEvenSumAfterRemoval = i == 0
                    ? pfOddSum.get(input.size()-1) - pfOddSum.get(0)
                    : pfEvenSum.get(i-1) + (pfOddSum.get(input.size()-1) - pfOddSum.get(i));
            if (pfEvenSumAfterRemoval == pfOddSumAfterRemoval) {
                count++;
            }
        }
        return count;
    }
}
