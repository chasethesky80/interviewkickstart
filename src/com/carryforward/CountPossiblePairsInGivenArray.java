package com.carryforward;

// GIVEN AN ARRAY OF SIZE N AND INDICES (I, J) SUCH THAT I < J COUNT NUMBER OF PAIRS SUCH THAT
// ARR[I] = 'a' AND ARR[J] = 'g'
public class CountPossiblePairsInGivenArray {

    public static void main(String[] args) {
        System.out.println("COUNT NUMBER OF 'AG' PAIRS IN ARRAY "+ countNumberOfPairsBruteForce(
                new char[]{ 'b', 'a', 'a', 'g', 'd', 'c', 'a', 'g' }));
        System.out.println("COUNT NUMBER OF 'AG' PAIRS IN ARRAY "+ countNumberOfPairsOptimizedFromEnd(
                new char[]{ 'b', 'a', 'a', 'g', 'd', 'c', 'a', 'g' }));
        System.out.println("COUNT NUMBER OF 'AG' PAIRS IN ARRAY "+ countNumberOfPairsOptimizedFromEnd(
                new char[]{ 'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g' }));
        System.out.println("COUNT NUMBER OF 'AG' PAIRS IN ARRAY "+ countNumberOfPairsOptimizedFromBeginning(
                new char[]{ 'a', 'd', 'g', 'a', 'g', 'a', 'g', 'f', 'g' }));
    }
    // TC = O(N^2) and SC = O(1) since no extra space is used
    private static int countNumberOfPairsBruteForce(final char[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 'a') {
                continue;
            }
            for (int j = i+1; j < input.length; j++) {
                if (input[j] != 'g') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    // TC = O(N) and SC = O(1)
    private static int countNumberOfPairsOptimizedFromEnd(final char[] input) {
        int answer = 0;
        int gCount = 0;
        for (int i = input.length-1; i >=0 ; i--) {
            if (input[i] == 'g') {
                gCount++;
            } else if (input[i] == 'a') {
                answer = answer + gCount;
            }
        }
        return answer;
    }

    private static int countNumberOfPairsOptimizedFromBeginning(final char[] input) {
        int answer = 0;
        int aCount = 0;
        for (int i = 0; i < input.length ; i++) {
            if (input[i] == 'a') {
                aCount++;
            } else if (input[i] == 'g') {
                answer = answer + aCount;
            }
        }
        return answer;
    }
}
