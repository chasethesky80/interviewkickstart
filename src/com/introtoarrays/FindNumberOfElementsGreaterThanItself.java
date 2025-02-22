package com.introtoarrays;

import java.util.List;

// GIVEN AN ARRAY, FIND NUMBER OF ELEMENTS THAT HAVE AT LEAST ONE ELEMENT GREATER THAN ITSELF
public class FindNumberOfElementsGreaterThanItself {

    public static void main(String[] args) {
        // BRUTEFORCE SOLUTION
        System.out.println("GET COUNT OF NO OF ELEMENTS HAVING ATLEAST 1 ELEMENT GREATER THAN ITSELF "+ getNumberOfElementsWithAtleastOneElementGreaterThanItselfBruteForce(
                List.of(2, 3, 10, 7, 3, 2, 10, 8)));
        System.out.println("GET COUNT OF NO OF ELEMENTS HAVING ATLEAST 1 ELEMENT GREATER THAN ITSELF "+ getNumberOfElementsWithAtleastOneElementGreaterThanItselfBruteForce(
                List.of(2, 5, 1, 4, 8, 0, 8, 13, 8, 9)));
        // OPTIMIZED SOLUTION
        System.out.println("GET COUNT OF NO OF ELEMENTS HAVING ATLEAST 1 ELEMENT GREATER THAN ITSELF "+ getNumberOfElementsWithAtleastOneElementGreaterThanItselfOptimized(
                List.of(2, 3, 10, 7, 3, 2, 10, 8)));
        System.out.println("GET COUNT OF NO OF ELEMENTS HAVING ATLEAST 1 ELEMENT GREATER THAN ITSELF "+ getNumberOfElementsWithAtleastOneElementGreaterThanItselfOptimized(
                List.of(2, 5, 1, 4, 8, 0, 8, 13, 8, 9)));
    }

    // TC = O(N^2) for the outer and inner loops and SC = O(1) since no extra space needed
    private static int getNumberOfElementsWithAtleastOneElementGreaterThanItselfBruteForce(final List<Integer> input) {
        int count = 0;
        for (Integer element: input) {
            for (Integer innerElement: input) {
                if (innerElement.compareTo(element) > 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // TC = O(2N) for the 2 for loops = O(N) and SC = O(1)
    private static int getNumberOfElementsWithAtleastOneElementGreaterThanItselfOptimized(final List<Integer> input) {
        //THIS WILL BE SAME AS -> SIZE OF ARRAY - COUNT OF MAXIMUM ELEMENT IN ARRAY
        // STEP 1 - FIND MAX ELEMENT
        int maxElement = Integer.MIN_VALUE;
        for (Integer element: input) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        // STEP 2 - FIND COUNT OF MAX ELEMENT
        int maxElementCount = 0;
        for (Integer element: input) {
            if (element.compareTo(maxElement) == 0) {
                maxElementCount++;
            }
        }
        return input.size() - maxElementCount;
    }
}
