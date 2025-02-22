package com.carryforward;

import com.util.ArrayUtils;

import java.util.List;

// GIVEN AN ARRAY OF N ELEMENTS, FIND THE LENGTH OF THE SMALLEST SUB-ARRAY CONTAINING THE MIN AND MAX OF THE ARRAY
// USING CARRY FORWARD TECHNIQUE
public class FindSmallestSubArrayHavingMinAndMaxOfArray {

    public static void main(String[] args) {
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxOptimized(List.of( 1, 2, 3, 1, 3, 4, 6, 4, 6, 3 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxBruteForce(List.of( 1, 2, 3, 1, 3, 4, 6, 4, 6, 3 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxOptimized(List.of( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxBruteForce(List.of( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxOptimized(List.of( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 3, 4, 1 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxBruteForce(List.of( 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 3, 4, 1 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxOptimized(List.of( 8, 3, 8, 7, 3, 1, 2, 8 )));
        System.out.println("MIN SUB ARRAY LENGTH CONTAINING MIN AND MAX ELEMENTS "+
                getSmallestSubarrayLengthHavingMinAndMaxBruteForce(List.of( 8, 3, 8, 7, 3, 1, 2, 8 )));
    }

    // TC = O(N^2) DUE TO 2 NESTED FOR LOOPS AND SC = O(1) SINCE NO EXTRA SPACE NEEDED
    private static int getSmallestSubarrayLengthHavingMinAndMaxBruteForce(final List<Integer> input) {
        final Integer[] minAndMaxElements = ArrayUtils.findMinAndMaxOfGivenArray(input);
        final Integer minElement = minAndMaxElements[0], maxElement = minAndMaxElements[1];
        int N = input.size();
        int answer = N;
        for (int i = 0; i < N; i++) {
            if (input.get(i).compareTo(minElement) == 0) {
                for (int j = i + 1; j < N; j++) {
                    if (input.get(j).compareTo(maxElement) == 0) {
                        answer = Math.min(answer, j - i + 1);
                        break;
                    }
                }
            } else if (input.get(i).compareTo(maxElement) == 0) {
                for (int j = i + 1; j < N; j++) {
                    if (input.get(j).compareTo(minElement) == 0) {
                        answer = Math.min(answer, j - i + 1);
                        break;
                    }
                }
            }
        }
        return answer;
    }

    // TC = O(N) DUE TO A SINGLE FOR LOOP AND SC = O(1) SINCE NO EXTRA SPACE NEEDED
    private static int getSmallestSubarrayLengthHavingMinAndMaxOptimized(final List<Integer> input) {
        // FIRST FIND MAX AND MIN ELEMENT OF ARRAY
        final Integer[] minAndMaxElements = ArrayUtils.findMinAndMaxOfGivenArray(input);
        final Integer minElement = minAndMaxElements[0], maxElement = minAndMaxElements[1];
        int maxElementIndex = -1, minElementIndex = -1;
        int N = input.size();
        int minSubArrayLength = N;
        // ALGORITHM TO KEEP UPDATING THE SUBARRAY LENGTH USING CARRY-FORWARD TECHNIQUE
        for (int i = N-1; i>=0; i--) {
            final Integer currentElement = input.get(i);
            if (currentElement.compareTo(maxElement) == 0) {
                maxElementIndex = i;
            } else if (currentElement.compareTo(minElement) == 0) {
                minElementIndex = i;
            }
            if (maxElementIndex != -1 && minElementIndex != -1) {
                minSubArrayLength = Math.min(minSubArrayLength, Math.abs(maxElementIndex - minElementIndex) + 1);
            }
        }
        return minSubArrayLength;
    }
}
