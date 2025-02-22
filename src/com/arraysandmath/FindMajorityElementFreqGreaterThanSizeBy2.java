package com.arraysandmath;

// Given an array of size N, find if there exists an element whose frequency in the array > N/2 and return it as the majority element
// else return -1. NOTE: The constraint is no extra space is allowed and the solution should be implemented in-place
public class FindMajorityElementFreqGreaterThanSizeBy2 {

    public static void main(String[] args) {
        System.out.println("MAJORITY ELEMENT FOR ARRAY IS "+findMajorityElementBruteForce(new int[]{ 3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3 }));
        System.out.println("MAJORITY ELEMENT FOR ARRAY IS "+findMajorityElementBruteForce(new int[]{ 1, 6, 1, 1, 2, 1 }));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+findMajorityElementOptimized(new int[]{ 3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3 }));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+findMajorityElementOptimized(new int[]{ 1, 6, 1, 1, 2, 1 }));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+findMajorityElementOptimized(new int[]{ 3, 3, 3, 2, 4, 4 }));
        System.out.println("MAJORITY ELEMENT FOR ARRAY OPTIMIZED IS "+findMajorityElementOptimized(new int[]{ 2, 1, 1 }));
    }

    // TC = O(N^2) and SC = O(1) since we have 2 nested for loops
    private static int findMajorityElementBruteForce(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int freqCount = 1;
            for (int j =0; j < input.length; j++) {
                if (j != i && input[j] == input[i]) {
                    freqCount++;
                }
            }
            if (freqCount > input.length / 2) {
                return input[i];
            }
        }
        return -1;
    }

    // OPTIMIZED SOLUTION USES - MOORE'S VOTING ALGORITHM: TC = O(N) since we just have 2 linear for loops one for finding the
    // best possible candidate for majority element and another for loop to verify if the best possible candidate is the majority element
    // and SC = O(1) since we use no extra space
    private static int findMajorityElementOptimized(int[] input) {
        int bestPossibleCandidateForMajorityElement = getBestPossibleCandidateForMajorityElement(input);
        int majorityElementFrequency = 0;
        //FOR LOOP TO VERIFY IF THE BEST POSSIBLE CANDIDATE FOUND ABOVE IS ACTUALLY THE MAJORITY ELEMENT BY COMPUTING ITS FREQUENCY
        // IN THE ARRAY AND VERIFYING IF ITS FREQUENCY > array.length / 2 OR ELSE RETURN -1 SINCE NO MAJORITY ELEMENT FOUND
        for (int i = 0; i < input.length; i++) {
            if (input[i] == bestPossibleCandidateForMajorityElement) {
                majorityElementFrequency++;
            }
        }
        return majorityElementFrequency > input.length / 2 ? bestPossibleCandidateForMajorityElement : -1;
    }

    private static int getBestPossibleCandidateForMajorityElement(int[] input) {
        int bestPossibleCandidateForMajorityElement = -1;
        int count = 0;
        // FOR LOOP TO FIND BEST POSSIBLE CANDIDATE FOR MAJORITY ELEMENT
        for (int i = 0; i < input.length; i++) {
            if (count == 0) {
                bestPossibleCandidateForMajorityElement = input[i];
                count = 1;
            } else if (input[i] == bestPossibleCandidateForMajorityElement) {
                count++;
            } else {
                count--;
            }
        }
        return bestPossibleCandidateForMajorityElement;
    }
}
