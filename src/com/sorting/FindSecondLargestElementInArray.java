package com.sorting;

import java.util.Arrays;
import java.util.List;

public class FindSecondLargestElementInArray {

    public static void main(String[] args) {
        System.out.println("SECOND MAXIMUM ELEMENT IN ARRAY "+ findSecondMaximumElementInGivenArray(Arrays.asList(3, 8, 8, 2, -1, 5, 5, -3)));
    }

    private static Integer findSecondMaximumElementInGivenArray(final List<Integer> input) {
        Integer maximumElement = Integer.MIN_VALUE;
        for (Integer element: input) {
            if (element.compareTo(maximumElement) > 0) {
                maximumElement = element;
            }
        }

        Integer secondMaximumElement = Integer.MIN_VALUE;
        for (Integer element: input) {
            if (element.compareTo(secondMaximumElement) > 0 && element.compareTo(maximumElement) < 0) {
                secondMaximumElement = element;
            }
        }
        return secondMaximumElement;
    }
}
