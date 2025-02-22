package com.subarrays;

import com.util.ArrayUtils;

import java.util.List;

// GIVEN AN ARRAY OF SIZE N, PRINT ALL SUBARRAY SUMS
public class PrintAllSubarraySumsOfGivenArray {

    public static void main(String[] args) {
        System.out.println("PRINT ALL SUB-ARRAYS OF ARRAY ");
        printAllSubarraySumsOfArrayBruteForce(List.of( -1, 3, 5, 6, 8 ));
        System.out.println("PRINTING ALL SUB-ARRAY SUMS USING PREFIX SUM --------");
        printAllSubarraySumsOfArrayOptimized(List.of( -1, 3, 5, 6, 8 ));
        System.out.println("PRINTING ALL SUB-ARRAY SUMS FROM A SPECIFIC INDEX USING PREFIX SUM TECHNIQUE -------");
        printAllSubarraySumsOfArrayFromAnIndexOptimized(List.of( -1, 3, 5, 6, 8 ), 2);
        System.out.println("/n/n/n");
        printAllSubarraySumsOfArrayFromAnIndexOptimized(List.of( 7, 3, 2, -1, 6, 8, 2, 3 ), 2);
        System.out.println("PRINTING ALL SUB-ARRAY SUMS STARTING AT SPECIFIC INDEX USING PREFIX SUM TECHNIQUE -------");
        printAllSubarraySumsStartingAtAnIndexOptimized(List.of( 7, 3, 2, -1, 6, 8, 2, 3 ), 2);
        System.out.println("PRINTING ALL SUB-ARRAY SUMS STARTING AT SPECIFIC INDEX USING CARRY FORWARD TECHNIQUE -------");
        printAllSubarraySumsStartingAtAnIndexOptimizedUsingCarryForward(List.of( 7, 3, 2, -1, 6, 8, 2, 3 ), 0);
        System.out.println("PRINTING ALL SUB-ARRAY SUMS USING CARRY FORWARD TECHNIQUE -------");
        printAllSubarraySumsOptimizedUsingCarryForward(List.of( 7, 3, 2, -1, 6, 8, 2, 3 ));
    }

    // TC = O(N^3) and SC = O(1)
    private static void printAllSubarraySumsOfArrayBruteForce(final List<Integer> input) {
        int N = input.size();
        for (int i=0; i < N; i++) {
            for (int j =i; j < N; j++) {
                int sum = 0;
                for (int e = i; e <=j; e++) {
                    sum = sum + input.get(e);
                }
                System.out.println(sum);
            }
        }
    }

    // TC = O(N^2) USING PREFIX SUM AND SC = O(N) FOR THE PREFIX SUM ARRAY
    private static void printAllSubarraySumsOfArrayOptimized(final List<Integer> input) {
        int N = input.size();
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        for (int i=0; i < N; i++) {
            for (int j =i; j < N; j++) {
                System.out.println(i == 0 ? prefixSumArray.get(j) : prefixSumArray.get(j) - prefixSumArray.get(i-1));
            }
        }
    }

    // TC = O(N^2) USING PREFIX SUM AND SC = O(N) FOR THE PREFIX SUM ARRAY
    private static void printAllSubarraySumsOfArrayFromAnIndexOptimized(final List<Integer> input, final int startIndex) {
        int N = input.size();
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        for (int i=startIndex; i < N; i++) {
            for (int j =i; j < N; j++) {
                System.out.println(i == 0 ? prefixSumArray.get(j) : prefixSumArray.get(j) - prefixSumArray.get(i-1));
            }
        }
    }

    // TC = O(N) DUE TO SINGLE FOR LOOP AND SC = O(N) FOR THE PREFIX SUM ARRAY
    private static void printAllSubarraySumsStartingAtAnIndexOptimized(final List<Integer> input, final int startIndex) {
        int N = input.size();
        final List<Integer> prefixSumArray = ArrayUtils.buildPrefixSumArray(input);
        for (int j =startIndex; j < N; j++) {
            System.out.println(prefixSumArray.get(j) - prefixSumArray.get(startIndex-1));
        }
    }

    // TC = O(N) DUE TO SINGLE FOR LOOP AND SC = O(1) SINCE NO EXTRA SPACE NEEDED
    private static void printAllSubarraySumsStartingAtAnIndexOptimizedUsingCarryForward(final List<Integer> input, final int startIndex) {
        int N = input.size();
        int sum = 0;
        for (int j =startIndex; j < N; j++) {
            sum = sum + input.get(j);
            System.out.println(sum);
        }
    }

    // TC = O(N^2) DUE TO SINGLE FOR LOOP AND SC = O(1) SINCE NO EXTRA SPACE NEEDED
    private static void printAllSubarraySumsOptimizedUsingCarryForward(final List<Integer> input) {
        int N = input.size();
        for (int i =0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum = sum + input.get(j);
                System.out.println(sum);
            }
        }
    }
}
