package com.bitmanipulation;

import java.util.Arrays;

// Given a binary array (meaning array contains only 1s and 0s), if at most one zero can be swapped with 1 from inside the array (internal swap),
// then find the number of consecutive 1s possible
public class MaxConsecutuve1sPossibleOnlyWithInternalSwaps {

    public static void main(String[] args) {
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 1, 1, 0, 1, 1, 1, 0, 1, 1 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 0 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 0, 1, 1, 0, 1, 1, 0 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 }));
        // EDGE CASES WHERE ALL ELEMENTS IN ARRAY ARE 0s and ALL ELEMENTS ARE 1s
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 0, 0, 0, 0 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 1, 1, 1, 1, 1 }));
    }
    // TC = O(N) since for each element in array, at max it is being visited 3 times, one for outer main loop, once when a 0 is encountered
    // then to right of that 0 and once when another 0 is encountered then to the left of that 0 so O(3N) since for each element
    // in array it is visited 3 times and so for N elements, its O(3N) ~ O(N) and SC = O(1) since no extra space used
    private static int numberOfConsecutiveOnesPossibleBruteForce(int[] input) {
        int countOfOnes = (int) Arrays.stream(input).filter(item -> item == 1).count();
        int totalCount = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                continue;
            }
            int leftCount = 0;
            for (int j = i-1; j >=0; j--) {
                if (input[j] == 1) {
                    leftCount++;
                } else {
                    break;
                }
            }
            int rightCount = 0;
            for (int k = i+1; k < input.length; k++) {
                if (input[k] == 1) {
                    rightCount++;
                } else {
                    break;
                }
            }
            totalCount = Math.max(totalCount, leftCount + rightCount < countOfOnes ? leftCount + rightCount + 1 : leftCount + rightCount);
        }
        return totalCount == Integer.MIN_VALUE ? input.length : totalCount;
    }

}
