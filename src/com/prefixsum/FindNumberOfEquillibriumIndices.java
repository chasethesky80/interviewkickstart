package com.prefixsum;

import com.util.ArrayUtils;

import java.util.List;

// GIVEN AN ARRAY OF N INTEGERS, FIND NUMBER OF EQUILLIBRIUM INDICES, AN EQUILLIBRIUM INDEX IS ONE WHERE SUM
// OF VALUES BEFORE INDEX EQUALS SUM OF VALUES AFTER INDEX
public class FindNumberOfEquillibriumIndices {

    public static void main(String[] args) {
        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndices(List.of(-3, 2, 4, -1)));
        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndices(List.of(3, -1, 2, -1, 1, 2, 1)));
        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndices(List.of(-7, -1, 5, 2, -4, 3, 0)));

        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndicesAlternativeSolution(List.of(-3, 2, 4, -1)));
        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndicesAlternativeSolution(List.of(3, -1, 2, -1, 1, 2, 1)));
        System.out.println("NO OF EQUILLIBRIUM INDICES "+getNumberOfEquillibriumIndicesAlternativeSolution(List.of(-7, -1, 5, 2, -4, 3, 0)));
    }

    // TC = O(N) TO LOOP THROUGH FOR LOOP AND SC = O(N) FOR EXTRA PREFIX SUM ARRAY
    private static int getNumberOfEquillibriumIndices(final List<Integer> input) {
        int count = 0;
        final List<Integer> pfSumArray = ArrayUtils.buildPrefixSumArray(input);
        for (int i = 0; i < input.size(); i++) {
            int leftSum = i == 0 ? 0 : pfSumArray.get(i-1);
            int rightSum = pfSumArray.get(input.size() - 1) - pfSumArray.get(i);
            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }

    private static Integer getNumberOfEquillibriumIndicesAlternativeSolution(final List<Integer> input) {
        Integer totalSum = 0, count = 0;
        for (Integer current: input) {
            totalSum = Integer.sum(totalSum, current);
        }

        Integer leftSum = 0;
        for (int i = 0; i < input.size(); i++) {
            leftSum = i == 0 ? 0 : leftSum + input.get(i-1);
            int rightSum = totalSum - leftSum - input.get(i);
            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }
}
