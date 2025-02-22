package com.carryforward;

import java.util.Arrays;
import java.util.List;

/**
 * A wire connects N light bulbs.
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 */
public class FindMinNoOfOperationsToTurnOnAllBulbs {

    public static void main(String[] args) {
        System.out.println("MINIMUM NUMBER OF OPERATIONS "+ minNumberOfOperationsToTurnOnAllBulbsBruteForce(Arrays.asList(1, 1, 0, 1, 0, 0, 1)));
        System.out.println("MINIMUM NUMBER OF OPERATIONS "+ minNumberOfOperationsToTurnOnAllBulbsOptimized(Arrays.asList(1, 1, 0, 1, 0, 0, 1)));
    }

    // TC = O(N^2) due to 2 nested for loops and SC = O(1) since no extra space needed
    private static int minNumberOfOperationsToTurnOnAllBulbsBruteForce(final List<Integer> input) {
        int minNumberOfOperations = 0;
        int N = input.size();
        for (int i = 0; i < N; i++) {
            if (input.get(i).compareTo(0) == 0) {
                minNumberOfOperations++;
                for (int j = i; j < input.size(); j++) {
                    input.set(j, 1 - input.get(j));
                }
            }
        }
        return minNumberOfOperations;
    }

    // TC = O(N) due to single for loop and SC = O(1) since no extra space needed
    private static int minNumberOfOperationsToTurnOnAllBulbsOptimized(final List<Integer> input) {
        int minNumberOfOperations = 0;
        int N = input.size();
        for (int i = 0; i < N; i++) {
            Integer state;
            if (minNumberOfOperations % 2 != 0) {
                state = 1 - input.get(i);
            } else {
                state = input.get(i);
            }
            if (state.compareTo(0) == 0) {
                minNumberOfOperations++;
            }
        }
        return minNumberOfOperations;
    }
}
