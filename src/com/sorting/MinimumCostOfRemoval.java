package com.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// GIVEN AN ARRAY OF INTEGERS OF SIZE N, YOU CAN REMOVE ONE ARRAY ELEMENT AT A TIME. COST OF REMOVAL OF AN ELEMENT IS THE SUM OF ALL
// ELEMENTS OF ARRAY JUST BEFORE REMOVAL OF THAT ELEMENT. FIND THE MINIMUM COST OF REMOVAL OF ALL ELEMENTS
public class MinimumCostOfRemoval {

    public static void main(String[] args) {
     System.out.println("FIND MINIMUM COST OF REMOVAL OF INTEGERS IN ARRAY "+findMinimumCostOfRemovalOfAllElements(new int[]{ 2, 1, 4 }));
    }

    // SORT ALL NUMBERS IN DESCENDING ORDER WHICH WILL LEAD TO MINIMUM COST OF REMOVAL,
    // AND USE CONTRIBUTION TECHNIQUE TO FIND SUM OF ALL REMOVALS
    // FOR EXAMPLE IF WE HAVE AN ARRAY OF 4 INTEGERS: a0, a1, a2, a3, then total cost of removal of all integers in array is
    // a0 + 2*a1 + 3*a2 + 4*a3 and so for an array of integers from index: 0 to n-1, the cost for an element at index i is: (i+1)*A[i]
    // WHERE A is the input array
    // TC = O(NLOGN) + O(N) = O(NLOGN) since O(NLOGN) is for the sorting algorithm and O(N) for computing the sum
    // SC = WHATEVER SPACE THE SORTING ALGORITHM TAKES
    private static int findMinimumCostOfRemovalOfAllElements(int[] input) {
       Arrays.sort(input);
       int sum = 0;
       for (int i = 0; i < input.length; i++) {
           sum = sum + (i+1)*input[i];
       }
       return sum;
    }

    private static int countNumberOfNobleIntegers(final List<Integer> input) {
        int count = 0;
        Collections.sort(input, Collections.reverseOrder());
        if (input.get(0) == 0) {
            count++;
        }
        int elementsLesserThanCurrent = -1;
        for (int i = 1; i <input.size(); i++) {
            final Integer current = input.get(i);
            if (current.compareTo(input.get(i-1)) != 0) {
                elementsLesserThanCurrent = i;
            } else if (current.compareTo(input.get(i-1)) == 0 && current.compareTo(i-1)== 0){
                count++;
            }
        }
        return count;
    }
}
