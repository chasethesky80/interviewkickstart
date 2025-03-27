package com.util;

import com.introtoproblemsolving.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

    // TC = O(N) and SC = O(N) due to the new PFSum array
    public static List<Integer> buildPrefixSumArray(final List<Integer> input) {
        final List<Integer> prefixSumArray = new ArrayList<>();
        prefixSumArray.add(input.get(0));
        for (int i =1; i < input.size(); i++) {
            prefixSumArray.add(Integer.sum(input.get(i), prefixSumArray.get(i-1)));
        }
        return prefixSumArray;
    }

    // TC = O(N) and SC = O(N) due to the new even PFSum array
    public static List<Integer> buildEvenPrefixSumArray(final List<Integer> input) {
        final List<Integer> prefixSumArray = new ArrayList<>();
        prefixSumArray.add(input.get(0));
        for (int i =1; i < input.size(); i++) {
            if (i % 2 == 0) {
                prefixSumArray.add(Integer.sum(input.get(i), prefixSumArray.get(i-1)));
            } else {
                prefixSumArray.add(prefixSumArray.get(i-1));
            }
        }
        return prefixSumArray;
    }

    // TC = O(N) and SC = O(N) due to the new even PFSum array
    public static List<Integer> buildOddPrefixSumArray(final List<Integer> input) {
        final List<Integer> prefixSumArray = new ArrayList<>();
        prefixSumArray.add(input.get(0));
        prefixSumArray.add(input.get(1));
        for (int i =2; i < input.size(); i++) {
            if (i % 2 == 1) {
                prefixSumArray.add(Integer.sum(input.get(i), prefixSumArray.get(i-1)));
            } else {
                prefixSumArray.add(prefixSumArray.get(i-1));
            }
        }
        return prefixSumArray;
    }

    public static Integer[] findMinAndMaxOfGivenArray(final List<Integer> input) {
        int maxElement = Integer.MIN_VALUE, minElement = Integer.MAX_VALUE;
        // FIRST FIND MAX AND MIN ELEMENT OF ARRAY
        int N = input.size();
        for (int i = 0; i < N; i++) {
            final Integer currentElement = input.get(i);
            if (currentElement.compareTo(maxElement) > 0) {
                maxElement = currentElement;
            } else if (currentElement.compareTo(minElement) < 0) {
                minElement = currentElement;
            }
        }
        return new Integer[]{ minElement, maxElement };
    }

    public static void reversePartOfArray(final List<Integer> input, final int startIndex, final int endIndex) {
        for (int i =startIndex, j = endIndex; i <= j; i++, j--) {
            Integer temp = input.get(i);
            input.set(i, input.get(j));
            input.set(j, temp);
        }
    }

    public static int[] reversePartOfArray(final int[] input, final int startIndex, final int endIndex) {
        for (int i =startIndex, j = endIndex; i <= j; i++, j--) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        return input;
    }

    public static List<List<Integer>> getTransposeOf2DSquareMatrix(final List<List<Integer>> input) {
        for (int i=0;i < input.size();i++) {
            for (int j = i+1; j < input.get(0).size(); j++) {
                Integer temp = input.get(i).get(j);
                input.get(i).set(j, input.get(j).get(i));
                input.get(j).set(i, temp);
            }
        }
        return input;
    }

    public static List<List<Integer>> getTransposeOf2DRectangularMatrix(final List<List<Integer>> input) {
        final List<List<Integer>> transposedMatrix = new ArrayList<>();
        for (int j=0;j < input.get(0).size();j++) {
            final List<Integer> row = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                row.add(input.get(i).get(j));
            }
            transposedMatrix.add(row);
        }
        return transposedMatrix;
    }

    /**
     * Return all the maximum value arrays going from beginning to end of list
     * @param input
     * @return
     */
    public static List<Integer> constructLeftMaxArray(final List<Integer> input) {
        final List<Integer> leftMaxArray = new ArrayList<>();
        leftMaxArray.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i).compareTo(input.get(i-1)) > 0) {
                leftMaxArray.add(input.get(i));
            } else {
                leftMaxArray.add(input.get(i-1));
            }
        }
        return leftMaxArray;
    }

    /**
     * Return all the maximum value arrays going from end to beginning of list
     * @param input
     * @return
     */
    public static List<Integer> constructRightMaxArray(final List<Integer> input) {
        final List<Integer> rightMaxArray = new ArrayList<>();
        rightMaxArray.add(input.size() - 1);
        for (int j = input.size() - 2; j >= 0 ; j--) {
            if (input.get(j).compareTo(input.get(j+1)) > 0) {
                rightMaxArray.add(input.get(j));
            } else {
                rightMaxArray.add(input.get(j+1));
            }
        }
        return rightMaxArray;
    }

    public static List<List<Integer>> generateKthSymbolSequence(int N) {
        final List<Integer> firstList = List.of(0);
        final List<List<Integer>> result = new ArrayList<>();
        result.add(firstList);
        for (int i = 1; i < N; i++) {
            final List<Integer> previous = result.get(i-1);
            final List<Integer> current = new ArrayList<>();
            for (Integer element: previous) {
                if (element == 0) {
                    current.add(0);
                    current.add(1);
                } else {
                    current.add(1);
                    current.add(0);
                }
            }
            result.add(current);
        }
        return result;
    }

    public static Pair findTheMaxAndSecondMaxOfAnArray(final List<Integer> input) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            Integer current = input.get(i);
            if (current.compareTo(max) > 0) {
                secondMax = max;
                max = current;
            } else if (current.compareTo(secondMax) > 0) {
                secondMax = current;
            }
        }
        return new Pair(secondMax, max);
    }

    public static Pair findTheMinAndSecondMinOfAnArray(final List<Integer> input) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < input.size(); i++) {
            Integer current = input.get(i);
            if (current.compareTo(min) < 0) {
                secondMin = min;
                min = current;
            } else if (current.compareTo(secondMin) < 0) {
                secondMin = current;
            }
        }
        return new Pair(secondMin, min);
    }
}
