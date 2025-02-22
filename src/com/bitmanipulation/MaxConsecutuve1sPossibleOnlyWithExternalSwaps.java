package com.bitmanipulation;

// Given a binary array (meaning array contains only 1s and 0s), if at most one zero can be replaced with 1 from outside array (external replace), then find
// the number of consecutive 1s possible
public class MaxConsecutuve1sPossibleOnlyWithExternalSwaps {

    public static void main(String[] args) {
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1 }));
        // EDGE CASES WHERE ALL ELEMENTS IN ARRAY ARE 0s and ALL ELEMENTS ARE 1s
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 0, 0, 0, 0, 0 }));
        System.out.println("MAX NO OF CONSECUTIVE 1s for ARRAY "+ numberOfConsecutiveOnesPossibleBruteForce(new int[]{ 1, 1, 1, 1, 1 }));
    }
    // TC = O(N) since for each element in array, at max it is being visited 3 times, one for outer main loop, once when a 0 is encountered
    // then to right of that 0 and once when another 0 is encountered then to the left of that 0 so O(3N) since for each element
    // in array it is visited 3 times and so for N elements, its O(3N) ~ O(N) and SC = O(1) since no extra space used
    private static int numberOfConsecutiveOnesPossibleBruteForce(int[] input) {
        int totalCount = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                continue;
            }
            // left count of 1s
            int leftCount = 0;
            for (int j = i-1; j >= 0; j--) {
                if (input[j] == 1) {
                    leftCount = leftCount + 1;
                } else {
                    break;
                }
            }
            int rightCount = 0;
            for (int k = i+1; k < input.length; k++) {
                if (input[k] == 1) {
                    rightCount = rightCount + 1;
                } else {
                    break;
                }
            }
            totalCount = Math.max(totalCount, leftCount + rightCount + 1);
        }
        return totalCount == Integer.MIN_VALUE ? input.length : totalCount;
    }
}
