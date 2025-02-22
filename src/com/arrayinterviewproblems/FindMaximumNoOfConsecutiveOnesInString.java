package com.arrayinterviewproblems;

/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 */
public class FindMaximumNoOfConsecutiveOnesInString {

    public static void main(String[] args) {
        System.out.println("MAX CONSECUTIVE ONES IN A BINARY STRING IF ONLY ONE SWAP BETWEEN 0 AND 1 IS ALLOWED IS "+ findMaxNumberOfConsecutiveOnes(
                "111011110110011011"
        ));
        System.out.println("MAX CONSECUTIVE ONES IN A BINARY STRING IF ONLY ONE SWAP BETWEEN 0 AND 1 IS ALLOWED IS "+ findMaxNumberOfConsecutiveOnes(
                "110111011"
        ));
        System.out.println("MAX CONSECUTIVE ONES IN A BINARY STRING IF ONLY ONE SWAP BETWEEN 0 AND 1 IS ALLOWED IS "+ findMaxNumberOfConsecutiveOnes(
                "00110110"
        ));
    }
    // TC = O(3N) ~ O(N) BECAUSE EACH CHARACTER IS ONLY VISITED 3 TIMES AT MAX WHILE COMPUTING LEFT AND RIGHT COUNTS
    // OF EACH CHARACTER IF IS A '0', SC = O(1) SINCE NO EXTRA SPACE USED
    private static int findMaxNumberOfConsecutiveOnes(final String A) {
        int numberOfOnes = 0;
        int maxConsecutiveOnes = Integer.MIN_VALUE;
        char[] charArray = A.toCharArray();
        for (char element: charArray) {
            if (element == '1') {
                numberOfOnes++;
            }
        }
        int strLength = A.length();
        if (numberOfOnes == strLength) {
            return numberOfOnes;
        }
        if (numberOfOnes == 0) {
            return 0;
        }
        for (int i = 0; i < strLength; i++) {
            if (A.charAt(i) == '1') {
                continue;
            }
            int leftCount = 0;
            for (int j = i-1; j >= 0; j--) {
                if (A.charAt(j) == '0') {
                    break;
                }
                leftCount++;
            }
            int rightCount = 0;
            for (int j = i+1; j < strLength; j++) {
                if (A.charAt(j) == '0') {
                    break;
                }
                rightCount++;
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, leftCount + rightCount == numberOfOnes ? leftCount + rightCount :
                    leftCount + rightCount + 1);
        }
        return maxConsecutiveOnes;
    }
}
