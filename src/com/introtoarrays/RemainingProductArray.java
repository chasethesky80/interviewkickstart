package com.introtoarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GIVEN AN ARRAY RETURN A NEW ARRAY WHICH CONTAINS PRODUCT OF ALL REMAINING ELEMENTS EXCEPT THE ELEMENT AT THAT INDEX
 */
public class RemainingProductArray {

    public static void main(String[] args) {
        System.out.println("REMANING PROODUCT ARRAY FOR "+ remainingElementsProductArray(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println("REMANING PROODUCT ARRAY FOR "+ remainingElementsProductArrayAlternate(Arrays.asList(1, 2, 3, 4, 5)));
    }

    private static List<Integer> remainingElementsProductArray(final List<Integer> input) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            result.add(1);
        }
        int ans = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            ans = ans * input.get(i-1);
            result.set(i, ans);
        }
        ans = 1;
        for (int i = input.size()-2; i>= 0; i--) {
            ans = ans * input.get(i+1);
            result.set(i, result.get(i) * ans);
        }
        return result;
    }

    private static List<Integer> remainingElementsProductArrayAlternate(final List<Integer> input) {
        int leftProduct = 1;
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            result.add(1);
        }
        for (int i = 0; i < input.size(); i++) {
            result.set(i, leftProduct);
            leftProduct = leftProduct * input.get(i);
        }

        int rightProduct = 1;
        for (int j = input.size() - 1; j >= 0; j--) {
            result.set(j, result.get(j) * rightProduct);
            rightProduct = rightProduct * input.get(j);
        }
        return result;
    }
}
